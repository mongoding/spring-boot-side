package org.spring.springboot.command;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;

/**
 * @Value注入 不通过配置文件的注入属性的情况
 * 通过@Value将外部的值动态注入到Bean中，使用的情况有：
 * <p>
 * 注入普通字符串
 * 注入操作系统属性
 * 注入表达式结果
 * 注入其他Bean属性：注入beanInject对象的属性another
 * 注入文件资源
 * 注入URL资源
 */
//@Component
public class AppRuner implements CommandLineRunner {

    private boolean flag = true;

    @Value("${org.spring.springboot.incr.num}")
    private String num;

    @Value("normal")
    private String normal; // 注入普通字符串

    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName; // 注入操作系统属性

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber; //注入表达式结果

    @Value("classpath:test.properties")
    private Resource resourceFile; // 注入文件资源

    @Value("http://www.baidu.com")
    private Resource testUrl; // 注入URL资源

    @Override
    public void run(String... args) throws Exception {
        System.out.println("normal:" + normal);
        System.out.println("systemPropertiesName:" + systemPropertiesName);
        System.out.println("randomNumber:" + randomNumber);
        System.out.println("resourceFile" + resourceFile.getFilename());
        System.out.println("testUrl" + resourceFile.getFilename());
        while (flag) {
            Thread.sleep(1000);

            System.out.println(Thread.currentThread().getName() + ":running man==" + num);

        }
    }
}
