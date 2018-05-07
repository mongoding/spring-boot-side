package org.spring.springboot.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRuner implements CommandLineRunner {

    private boolean flag = true;

    private int a = 2;

    @Override
    public void run(String... args) throws Exception {
        while (flag) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":running man==" + a);

        }
    }
}
