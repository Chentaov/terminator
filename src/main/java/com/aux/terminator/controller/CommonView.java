package com.aux.terminator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class CommonView {
    @RequestMapping("common/navhead") //头导航
    public ModelAndView navhead(HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = session.getAttribute("id").toString();
        ModelAndView m = new ModelAndView();
        m.setViewName("common/navhead");
        m.addObject("id",id);
        return m;
    }

    @RequestMapping("404") //404页面
    public ModelAndView page404(){
        ModelAndView m = new ModelAndView();
        m.setViewName("response/404");
        return m;
    }

}
