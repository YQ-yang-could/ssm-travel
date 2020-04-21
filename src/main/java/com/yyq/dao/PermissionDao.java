package com.yyq.dao;

import com.yyq.po.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限dao接口
 * @author admin
 * 2020/04/19
 */
public interface PermissionDao {
    //根据角色来查询权限
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(Integer id) throws Exception;

    //查看所有权限
    @Select("select * from permission")
    public List<Permission> findAll() throws Exception;

    //保存权限
    @Select("insert into permission(permissionName,url) values(#{permission},#{url})")
    public void save(Permission permission) throws Exception;
}
