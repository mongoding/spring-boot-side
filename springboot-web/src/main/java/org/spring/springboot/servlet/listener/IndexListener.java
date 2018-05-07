package org.spring.springboot.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class IndexListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("IndexListener contextDestroyed method");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("IndexListener contextInitialized method");
    }
}