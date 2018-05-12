package org.spring.springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.entity.User;
import org.spring.springboot.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserProperties userProperties;

    @RequestMapping("/user")
    public Object getUser() {

        log.info("获取urser 信息");

        User user = new User();
        user.setName("mongoding");
        user.setMail("1144673474@qq.com");
        user.setBlogUrl("https://mongoding.github.io/");
        user.setGithubUrl("https://github.com/mongoding");
        return user;
    }

    @RequestMapping("/user/pro")
    public Object getUserPropertis() {

        return userProperties;
    }


}
