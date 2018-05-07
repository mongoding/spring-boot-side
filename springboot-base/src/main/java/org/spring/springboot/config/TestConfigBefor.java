package org.spring.springboot.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(TestConditionConfig.class)
public class TestConfigBefor {

    @Bean
    public Object configBefore() {
        System.out.println("configBefore running");
        return new Object();
    }


}
