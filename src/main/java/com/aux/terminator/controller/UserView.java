package com.aux.terminator.controller;

import com.aux.terminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class UserView {
    @Autowired
    UserService userService;

    @RequestMapping("signin") //注册
    public ModelAndView signin(){
        ModelAndView m = new ModelAndView();
        m.setViewName("admin/signin");
        return m;
    }

    @RequestMapping("success")  //成功界面
    public ModelAndView success(){
        ModelAndView m = new ModelAndView();
        m.setViewName("success");
        return m;
    }

    @RequestMapping("admin/resetpass")//修改密码
    public ModelAndView resetpass(HttpSession session){
        String id = session.getAttribute("id").toString();
        ModelAndView m = new ModelAndView();
        m.setViewName("admin/resetpass");
        m.addObject("id",id);
        return m;
    }

}
