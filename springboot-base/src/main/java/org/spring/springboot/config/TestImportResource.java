package org.spring.springboot.config;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component
@ImportResource("applicationContext.xml")
public class TestImportResource {

    public static class TestImportResourceBean {

        public TestImportResourceBean() {
            System.out.println("TestImportResourceBean 被初始化了");
        }
    }
}

