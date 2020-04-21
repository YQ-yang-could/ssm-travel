package com.yyq.service;

import com.yyq.po.Permission;

import java.util.List;
/**
 * 权限业务层接口
 * @author admin
 * 2020/04/19
 */
public interface PermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
