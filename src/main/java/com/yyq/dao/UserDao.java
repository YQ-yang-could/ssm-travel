package com.yyq.dao;

import com.yyq.po.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户dao接口
 * @author admin
 * 2020/04/19
 */
public interface UserDao {
    //根据用户名查询用户信息
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yyq.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;
    //查询所有用户
    @Select("select * from users")
    public List<UserInfo> findAll() throws Exception;
    //添加用户
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo) throws Exception;
    //根据id查询用户
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yyq.dao.RoleDao.findRoleByUserId"))
    }
    )
    public UserInfo findById(Integer id)throws Exception;

}
