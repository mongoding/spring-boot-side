package org.spring.springboot.config;

import org.springframework.context.annotation.Bean;

public class TestImportConfig {

    @Bean
    public Object getA() {
        System.out.println("我是被@Improt 导入的配置");
        return new Object();
    }
}
