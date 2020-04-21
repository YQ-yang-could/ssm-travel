package com.yyq.dao;

import com.yyq.po.Member;
import com.yyq.po.Orders;
import com.yyq.po.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 订单dao层接口
 * @author admin
 */
public interface OrderDao {
    @Select("select * from orders")
    @Results(
            {
                    @Result(id=true,property = "id" ,column = "id"),
                    @Result(property = "orderNum",column = "orderNum"),
                    @Result(property = "orderTime",column = "orderTime"),
                    @Result(property = "orderStatus",column = "orderStatus"),
                    @Result(property = "peopleCount",column = "peopleCount"),
                    @Result(property = "payType",column = "payType"),
                    @Result(property = "orderDesc",column = "orderDesc"),
                    @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select = "com.yyq.dao.ProductDao.findById")),
            }
    )
    public List<Orders> findAll() throws Exception;//查询所有订单
    //多表操作
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product",column = "porductId",javaType = Product.class,one = @One(select = "com.yyq.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.itheima.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yyq.dao.TravellerDao.findById"))
    })
    public Orders findById(Integer orderId) throws Exception;
}
