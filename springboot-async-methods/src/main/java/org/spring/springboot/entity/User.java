package org.spring.springboot.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by mongoding on 2017/4/19.
 */
@Slf4j
@Data
@ConfigurationProperties(prefix = "org.spring.springboot.user")
public class User {

    private int id;

    /**
     * 名字
     */
    private String name;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 独立博客地址
     */
    private String blogUrl;

    /**
     * github 主页地址
     */
    private String githubUrl;


}