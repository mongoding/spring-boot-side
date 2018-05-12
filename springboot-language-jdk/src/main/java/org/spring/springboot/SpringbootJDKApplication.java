package org.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootJDKApplication {


    public static void main(String[] args) {
        System.out.println("主线程start：" + Thread.currentThread().getName());
        ApplicationContext ctx = SpringApplication.run(SpringbootJDKApplication.class, args);
        System.out.println("主线程：" + Thread.currentThread().getName());

    }


}
