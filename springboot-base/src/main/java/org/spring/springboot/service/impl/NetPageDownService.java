package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.service.INetPageDownService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NetPageDownService implements INetPageDownService {

    private static final Logger logger = LoggerFactory.getLogger(NetPageDownService.class);

    private final RestTemplate restTemplate;

    public NetPageDownService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public String findByUrl(String url) {
        logger.info("Looking up " + url);
        String results = restTemplate.getForObject(url, String.class);
        // Artificial delay of 1s for demonstration purposes
        return results;
    }
}
