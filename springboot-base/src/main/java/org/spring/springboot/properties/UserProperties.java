package org.spring.springboot.properties;

import org.spring.springboot.entity.User;
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

    @Max(150)
    @Min(0)
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserProperties{" +
                "age=" + age +
                '}';
    }
}
