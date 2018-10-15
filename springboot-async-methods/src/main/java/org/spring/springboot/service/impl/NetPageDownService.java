package org.spring.springboot.service.impl;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.service.INetPageDownService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

@Service
public class NetPageDownService implements INetPageDownService {

    private static final Logger logger = LoggerFactory.getLogger(NetPageDownService.class);

    OkHttpClient okHttpClient=new OkHttpClient.Builder().build();



    @Override
    public String findByUrl(String url) {

        logger.info("Looking up " + url);
        String string = null;
        try {
            Request req = new Request.Builder().url(url).build();
            Call call = okHttpClient.newCall(req);
            Response execute = call.execute();
            string = execute.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
