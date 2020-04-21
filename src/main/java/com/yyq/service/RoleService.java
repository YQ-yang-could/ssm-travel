package com.yyq.service;

import com.yyq.po.Role;

import java.util.List;
/**
 * 角色业务层接口
 * @author admin
 * 2020/04/19
 */
public interface RoleService {

    public List<Role> findAll() throws Exception;

    public void save(Role role) throws Exception;
}
