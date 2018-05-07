package org.spring.springboot.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * Created by mongoding on 2017/4/19.
 */
@ConfigurationProperties(prefix = "org.spring.springboot.user")
public class User implements Serializable {

    private static final long serialVersionUID = 4729953060550368401L;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", blogUrl='" + blogUrl + '\'' +
                ", githubUrl='" + githubUrl + '\'' +
                '}';
    }
}