package org.spring.springboot.commond;

import org.spring.springboot.cache.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRedisRunner implements CommandLineRunner {

    @Autowired
    private RedisServiceImpl<String> redisService;
    @Override
    public void run(String... args) {

        redisService.set("test-key1", "test");

        redisService.get("test-key1");

    }
}
