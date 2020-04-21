package com.yyq.dao;

import com.yyq.po.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 游客dao接口
 * @author admin
 * 2020/04/19
 */
public interface TravellerDao {
    //根据订单id查询所有的游客
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{orderId})")
    public List<Traveller> findByOrderId(Integer orderId) throws Exception;
}
