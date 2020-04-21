package com.yyq.controller;

import com.github.pagehelper.PageInfo;
import com.yyq.po.Orders;
import com.yyq.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 订单控制层
 * @author admin
 * 2020/4/17
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size", required = true, defaultValue = "4")int size) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList=ordersService.findAll(page, size);
        //分页
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    @RequestMapping("/findById.do")
     public ModelAndView findById(@RequestParam(name = "id",required = true) Integer orderId)throws Exception{
        ModelAndView mv=new ModelAndView();
        Orders orders=ordersService.findById(orderId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
     }
}
