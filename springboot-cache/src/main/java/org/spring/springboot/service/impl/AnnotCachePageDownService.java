package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.service.INetPageDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AnnotCachePageDownService implements INetPageDownService {

    private static final Logger logger = LoggerFactory.getLogger(AnnotCachePageDownService.class);

    @Autowired
    private INetPageDownService netPageDownService;

    @Override
    @Cacheable(value = "cacheDemo", key = "#url + 'data'")
    public String findByUrl(String url) {
        logger.info("请求url：{}", url);
        String content = netPageDownService.findByUrl(url);
        return content;
    }
}
