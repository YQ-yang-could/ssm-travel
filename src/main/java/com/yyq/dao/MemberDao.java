package com.yyq.dao;

import com.yyq.po.Member;
import org.apache.ibatis.annotations.Select;

/**
 * 会员dao接口
 * @author admin
 * 2020/04/19
 */
public interface MemberDao {
    //根据id查询
    @Select("select * from member where id=#{id}")
    public Member findById(Integer id)throws Exception;
}
