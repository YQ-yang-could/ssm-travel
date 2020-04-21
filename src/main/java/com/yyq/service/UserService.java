package com.yyq.service;

import com.yyq.po.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 用户业务层接口
 * @author admin
 * 2020/04/19
 */
public interface UserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(Integer id) throws Exception;
}
