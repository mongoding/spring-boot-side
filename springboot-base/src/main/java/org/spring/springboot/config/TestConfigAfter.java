package org.spring.springboot.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(TestConditionConfig.class)
public class TestConfigAfter {

    @Bean
    public Object configAfter() {

        System.out.println("configAfter running");
        return new Object();
    }


}
