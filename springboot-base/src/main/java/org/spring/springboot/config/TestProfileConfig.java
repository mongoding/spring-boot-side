package org.spring.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class TestProfileConfig {
    @Bean
    @Profile("test")
    public Object test1() {
        System.out.println("TestProfileConfig.test1 running");
        return new Object();
    }

    @Bean
    @Profile("dev")
    public Object test2() {
        System.out.println("TestProfileConfig.test2 running");
        return new Object();
    }
}
