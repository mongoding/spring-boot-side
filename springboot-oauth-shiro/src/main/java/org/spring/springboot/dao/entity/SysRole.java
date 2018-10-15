package org.spring.springboot.dao.entity;

import org.spring.springboot.common.dao.entity.Permission;
import org.spring.springboot.common.dao.entity.Role;

import java.io.Serializable;
import java.util.List;

/**
 * Description  : 角色信息
 */
public class SysRole extends Role implements Serializable {

    private static final long serialVersionUID = 1L;

    // 拥有的权限列表
    private List<Permission> permissions;

    public SysRole() {
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
