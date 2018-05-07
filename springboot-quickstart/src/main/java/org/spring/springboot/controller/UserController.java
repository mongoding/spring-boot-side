package org.spring.springboot.controller;


import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class UserController {

    @RequestMapping("/name")
    public Object getUser() {

        return "dingzhenhao";
    }


}
