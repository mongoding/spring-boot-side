package org.spring.springboot.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(TestConditionConfig.class)
@AutoConfigureOrder(-1000)
public class TestConfigBefor {

    @Bean
    public Object configBefore() {
        System.out.println("configBefore running");
        return new Object();
    }


}
