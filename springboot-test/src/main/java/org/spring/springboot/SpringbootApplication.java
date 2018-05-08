package org.spring.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootApplication.class);


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringbootApplication.class, args);


    }


}
