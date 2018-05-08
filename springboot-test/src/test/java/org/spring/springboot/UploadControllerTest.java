package org.spring.springboot;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.spring.springboot.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void upload() {
        Resource resource = new FileSystemResource("/home/lake/github/wopi/build.gradle");
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username", "lake");
        multiValueMap.add("files", resource);
        ResponseDTO result = testRestTemplate.postForObject("/test/upload", multiValueMap, ResponseDTO.class);
        Assert.assertEquals(result.getCode(), 0);
    }

    @Test
    public void download() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "xxxxxx");
        HttpEntity formEntity = new HttpEntity(headers);
        String[] urlVariables = new String[]{"admin"};
        ResponseEntity<byte[]> response = testRestTemplate.exchange("/test/download?username={1}", HttpMethod.GET, formEntity, byte[].class, urlVariables);
        if (response.getStatusCode() == HttpStatus.OK) {
            Path path = Paths.get("/home/lake/github/file/test.gradle");
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {

                writer.write(new Gson().toJson(response.getBody()));
            }
        }
    }
}
