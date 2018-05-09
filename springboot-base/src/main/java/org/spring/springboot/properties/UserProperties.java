package org.spring.springboot.properties;

import org.spring.springboot.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by mongoding on 2017/4/18.
 */


@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "org.spring.springboot.user")
@Validated
public class UserProperties extends User {

    @Max(100)
    @Min(10)
    private int age;

    @Value("${org.spring.springboot.msg}")
    private String msg = "";


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "UserProperties{" +
                "age=" + age +
                ", msg='" + msg + '\'' +
                '}';
    }
}
