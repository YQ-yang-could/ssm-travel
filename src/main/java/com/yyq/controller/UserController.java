package com.yyq.controller;

import com.yyq.po.UserInfo;
import com.yyq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception{
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-show1");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv=new ModelAndView();
        List<UserInfo> userInfoList=userService.findAll();
        mv.addObject("userInfoList",userInfoList);
        mv.setViewName("user-list");
        return mv;
    }
}
