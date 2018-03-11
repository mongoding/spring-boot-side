package io.github.mongoding.springbootside.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest httpServletRequest) {
        AsyncContext asyncContext = httpServletRequest.startAsync();

        return "test";
    }

    @RequestMapping({"/index", "/"})
    public String sayHello(HttpServletRequest httpServletRequest) {
        AsyncContext asyncContext = httpServletRequest.startAsync();

        return "index";
    }

    @RequestMapping("/changepwd")
    public String changepwd(HttpServletRequest httpServletRequest) {
        AsyncContext asyncContext = httpServletRequest.startAsync();

        return "changepwd";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest httpServletRequest) {
        AsyncContext asyncContext = httpServletRequest.startAsync();

        return "login";
    }

    @RequestMapping("/main")
    public String main(HttpServletRequest httpServletRequest) {
        AsyncContext asyncContext = httpServletRequest.startAsync();

        return "main";
    }

    @RequestMapping("/myloginfo")
    public String myloginfo(HttpServletRequest httpServletRequest) {
        AsyncContext asyncContext = httpServletRequest.startAsync();

        return "myloginfo";
    }

    @RequestMapping("/personInfo")
    public String personInfo(HttpServletRequest httpServletRequest) {
        AsyncContext asyncContext = httpServletRequest.startAsync();

        return "personInfo";
    }

    @RequestMapping("/temp")
    public String temp(HttpServletRequest httpServletRequest) {
        AsyncContext asyncContext = httpServletRequest.startAsync();

        return "temp";
    }
}
