package org.spring.springboot.kafka.web;

import org.spring.springboot.kafka.config.ApplicationConfiguration;
import org.spring.springboot.kafka.kafka.KafkaProducerUtil;
import org.spring.springboot.kafka.pojo.User;
import org.spring.springboot.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 
* Title: UserRestController
* Description: 
* 用户数据操作接口
* Version:1.0.0  
* @author mongoding
* @date 2018年1月9日
 */
@RestController
@RequestMapping(value = "/api")
public class UserRestController {
	@Autowired
    private UserService userService;
	@Autowired
    ApplicationConfiguration app;
	
    @GetMapping("/user")
    public List<User> findByUser(User user) {
    	System.out.println("开始查询...");
        return userService.findByUser(user);
    }
    
    @PostMapping("/user")
    public boolean sendKafka(@RequestBody User user) {
        return KafkaProducerUtil.sendMessage(user.toString(), app.getServers(), app.getTopicName());
    }
}
