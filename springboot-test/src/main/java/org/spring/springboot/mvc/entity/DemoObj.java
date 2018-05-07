package org.spring.springboot.mvc.entity;


/**
 * Author: 王俊超
 * Date: 2017-07-11 22:07
 * All Rights Reserved !!!
 */
public class DemoObj {
    private Long id;
    private String name;

    public DemoObj() {
        super();
    }

    public DemoObj(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}