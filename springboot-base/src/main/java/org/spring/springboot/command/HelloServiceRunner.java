package org.spring.springboot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class HelloServiceRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceRunner.class);
    @Autowired
    private HelloService helloService;

    @Override
    public void run(String... args) {
        logger.info("helloService.say:{}", helloService.say());
    }
}
