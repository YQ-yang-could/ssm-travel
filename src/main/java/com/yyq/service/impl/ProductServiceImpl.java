package com.yyq.service.impl;

import com.yyq.dao.ProductDao;
import com.yyq.po.Product;
import com.yyq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品业务实现类
 * @author admin
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
