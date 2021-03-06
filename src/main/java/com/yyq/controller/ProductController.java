package com.yyq.controller;

import com.yyq.po.Product;
import com.yyq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 产品控制层
 * @author admin
 * 2020/04/17
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    //添加产品
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }
    //查询全部产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv =new ModelAndView();
        List<Product> ps=productService.findAll();
        mv.addObject("productlist",ps);
        mv.setViewName("product-list1");
        return mv;
    }
}
