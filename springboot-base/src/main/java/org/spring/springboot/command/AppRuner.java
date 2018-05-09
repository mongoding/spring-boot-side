package org.spring.springboot.command;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;


public class AppRuner implements CommandLineRunner {

    private boolean flag = true;

    @Value("org.spring.springboot.incr.num")
    private int num;

    @Override
    public void run(String... args) throws Exception {
        while (flag) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":running man==" + num);

        }
    }
}
