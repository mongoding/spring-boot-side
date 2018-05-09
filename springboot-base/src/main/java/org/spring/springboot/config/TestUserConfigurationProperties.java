package org.spring.springboot.config;


import org.spring.springboot.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //配置类
@EnableConfigurationProperties(UserProperties.class)//这里就是前面说的，这个注解读入我们的配置对象类
public class TestUserConfigurationProperties {

    @Autowired
    private UserProperties userProperties;

    @Value("${org.spring.springboot.blog.desc}")
    private String desc;

    @Value("${org.spring.springboot.blog.value}")
    private String randumString;

    @Bean
    public Object getUser() {
        System.out.println("用户信息：" + userProperties);
        return new Object();
    }

    @Bean
    public Object getInfo() {
        System.out.println("打印随机数");
        System.out.println("desc:" + desc);
        System.out.println("randumString:" + randumString);
        return new Object();
    }

}
