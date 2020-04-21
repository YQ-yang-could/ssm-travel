package com.yyq.service;

import com.yyq.po.Orders;

import java.util.List;

/**
 * 订单业务层接口
 * @author admin
 */
public interface OrdersService {
    //查询所有订单业务方法
    List<Orders> findAll(int page,int size)throws Exception;
    //根据订单id查询订单
    Orders findById(Integer orderId) throws Exception;
}
