package org.spring.springboot.base.rmi;

import java.rmi.Naming;

/**
 * Created by mongoding on 2016/4/18.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        org.spring.springboot.base.rmi.UserService userService = (org.spring.springboot.base.rmi.UserService) Naming.lookup("rmi://127.0.0.1:8899/userService");
        User user = new User();
        user.setName("Mars");
        user.setAge(27);
        String hi = userService.hi(user);
        System.out.println(hi);
    }
}
