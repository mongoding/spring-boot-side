package org.spring.springboot.entity;

import lombok.Data;

/**
 * Created by mongoding on 2017/4/19.
 */

@Data
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