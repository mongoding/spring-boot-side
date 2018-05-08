package org.spring.springboot.config;

import org.spring.springboot.mvc.entity.Book;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    // 这里不需要@Primary之类的机制，直接就能够覆盖
    @Bean
    public Book foo() {
        return new Book();
    }

    @Bean
    public Book foo2() {
        return new Book();
    }
}
