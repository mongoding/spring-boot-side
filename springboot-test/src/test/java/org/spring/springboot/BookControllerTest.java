package org.spring.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.spring.springboot.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

public class BookControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void get() {
        Map<String, String> multiValueMap = new HashMap<>();
        multiValueMap.put("username", "lake");//传值，但要在url上配置相应的参数
        ResponseDTO result = testRestTemplate.getForObject("/test/get?username={username}", ResponseDTO.class, multiValueMap);
        Assert.assertEquals(result.getCode(), 0);
    }

    @Test
    public void post() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username", "lake");
        ResponseDTO result = testRestTemplate.postForObject("/test/post", multiValueMap, ResponseDTO.class);
        Assert.assertEquals(result.getCode(), 0);
    }


    @Test
    public void getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "xxxxxx");
        HttpEntity formEntity = new HttpEntity(headers);
        String[] urlVariables = new String[]{"admin"};
        ResponseEntity<ResponseDTO> result = testRestTemplate.exchange("/test/getHeader?username={username}", HttpMethod.GET, formEntity, ResponseDTO.class, urlVariables);
        Assert.assertEquals(result.getBody().getCode(), 0);
    }

    @Test
    public void putHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "xxxxxx");
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username", "lake");
        HttpEntity formEntity = new HttpEntity(multiValueMap, headers);
        ResponseEntity<ResponseDTO> result = testRestTemplate.exchange("/test/putHeader", HttpMethod.PUT, formEntity, ResponseDTO.class);
        Assert.assertEquals(result.getBody().getCode(), 0);
    }

    @Test
    public void delete() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "xxxxx");
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username", "lake");
        HttpEntity formEntity = new HttpEntity(multiValueMap, headers);
        String[] urlVariables = new String[]{"admin"};
        ResponseEntity<ResponseDTO> result = testRestTemplate.exchange("/test/delete?username={username}", HttpMethod.DELETE, formEntity, ResponseDTO.class, urlVariables);
        Assert.assertEquals(result.getBody().getCode(), 0);
    }
}
