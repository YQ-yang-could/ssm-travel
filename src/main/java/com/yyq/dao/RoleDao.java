package com.yyq.dao;

import com.yyq.po.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 角色dao接口
 * @author admin
 * 2020/04/19
 */
public interface RoleDao {
//    根据用户id查询所有对应角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yyq.dao.PermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(Integer userId) throws Exception;

    //查询所有的角色
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    //添加角色
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role);
}
