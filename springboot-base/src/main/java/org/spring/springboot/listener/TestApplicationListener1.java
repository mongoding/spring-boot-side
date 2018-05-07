package org.spring.springboot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestApplicationListener1 implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("TestApplicationListener1.onApplicationEvent running");
    }
}
