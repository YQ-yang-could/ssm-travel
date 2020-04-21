package com.yyq.service.impl;

import com.github.pagehelper.PageHelper;
import com.yyq.dao.OrderDao;
import com.yyq.po.Orders;
import com.yyq.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单业务接口实现类
 * @author admin
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrderDao orderDao;

    public List<Orders> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    public Orders findById(Integer orderId) throws Exception {
        return orderDao.findById(orderId);
    }
}
