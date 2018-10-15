package org.spring.springboot.dao.repository;

import org.spring.springboot.common.dao.repository.ManagerMapper;
import org.spring.springboot.dao.entity.ManagerInfo;

import java.util.List;
import java.util.Map;

/**
 * Description  :
 */
public interface ManagerInfoDao extends ManagerMapper {
    ManagerInfo findByUsername(String username);
}
