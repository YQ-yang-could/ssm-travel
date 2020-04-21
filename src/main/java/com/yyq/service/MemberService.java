package com.yyq.service;

import com.yyq.po.Member;
/**
 * 会员业务层接口
 * @author admin
 * 2020/04/19
 */
public interface MemberService {

    public Member findById(Integer id)throws Exception;
}
