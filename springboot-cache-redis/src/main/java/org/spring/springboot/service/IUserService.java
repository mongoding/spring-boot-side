package org.spring.springboot.service;


import org.spring.springboot.domain.User;

import java.util.List;

public interface IUserService {

    User findUserById(int id);

    User findUserByName(String name);

    List<User> listUsersByIds(List<Integer> userIds);


}
