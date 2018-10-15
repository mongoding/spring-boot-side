package org.spring.springboot.kafka.service;


import org.spring.springboot.kafka.pojo.User;

import java.util.List;


/**
 * 
* Title: UserService
* Description:用户接口 
* Version:1.0.0  
* @author mongoding
* @date 2018年1月9日
 */
public interface UserService {
	
	
	/**
	 * 批量新增用户
	 * @param user
	 * @return
	 */
	boolean insertBatch(List<User> user);
	
	
	/**
	 * 查询用于
	 * @param user
	 * @return
	 */
	List<User> findByUser(User user);
	
	
}
