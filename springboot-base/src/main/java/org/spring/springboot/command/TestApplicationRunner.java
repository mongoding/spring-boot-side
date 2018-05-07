package org.spring.springboot.command;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class TestApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        System.out.println("TestApplicationRunner.run  running ");
    }
}
