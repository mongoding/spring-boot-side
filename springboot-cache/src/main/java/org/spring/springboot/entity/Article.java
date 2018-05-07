package org.spring.springboot.entity;

import java.io.Serializable;

public class Article implements Serializable {

    private static final long serialVersionUID = 4729953060550368401L;


    private int id;

    private String name;

    private String authorName;

    private String articleUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                '}';
    }
}
