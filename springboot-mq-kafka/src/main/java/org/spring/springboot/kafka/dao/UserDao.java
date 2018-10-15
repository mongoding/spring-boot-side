package org.spring.springboot.kafka.dao;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.kafka.pojo.User;

import java.util.List;

/**
 * 
* Title: UserDao
* Description:
* 用户数据接口 
* Version:1.0.0  
* @author mongoding
* @date 2018年1月9日
 */
@Mapper
public interface UserDao {
	
	
	/**
	 * 批量新增据插入数据
	 * @param entityList
	 * @return
	 * @throws Exception
	 * @throws
	 */
	boolean insertBatch(List<User> entityList) throws Exception;
	
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	List<User> findByUser(User user) ;
    
}
