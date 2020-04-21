package com.yyq.dao;

import com.yyq.po.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 产品dao接口
 * @author admin
 */
public interface ProductDao {
    //根据id查询商品
    @Select("sekect * from product where id =#{id}")
    public Product findById(String id) throws Exception;
    //查询所有商品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
    //保存商品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product);
}
