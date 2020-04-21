package com.yyq.service;

import com.yyq.po.Product;

import java.util.List;

/**
 * 产品业务层接口
 * @author admin
 */
public interface ProductService {
    //查询所有商品业务方法
    public List<Product> findAll() throws Exception;
    //保存商品业务方法
    public void save(Product product) throws Exception;
}
