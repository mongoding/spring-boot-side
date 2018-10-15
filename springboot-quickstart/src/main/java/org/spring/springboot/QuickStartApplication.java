package org.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by mongoding on 26/09/2017.
 */
@SpringBootApplication
public class QuickStartApplication {

    public static void main(String[] args) {
        /*try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {


        }*/
        SpringApplication.run(QuickStartApplication.class, args);
    }
}
