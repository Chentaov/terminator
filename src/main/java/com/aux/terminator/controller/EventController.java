package com.aux.terminator.controller;

import com.aux.terminator.pojo.Investigation;
import com.aux.terminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/")
public class EventController {
    @Autowired
    UserService userService;


    @RequestMapping("workspace/renovation") //装修报备
    public ModelAndView renovation(HttpSession session){
        String id = session.getAttribute("id").toString();
        ModelAndView m = new ModelAndView();
        m.setViewName("workspace/renovation");
        m.addObject("id",id);
        return m;
    }

    @RequestMapping("workspace/report") //举报不文明行为
    public ModelAndView report(HttpSession session){
        String id = session.getAttribute("id").toString();
        ModelAndView m = new ModelAndView();
        m.setViewName("workspace/report");
        m.addObject("id",id);
        return m;
    }

    @RequestMapping("workspace/vehicle") //车库录库
    public ModelAndView vehicle(HttpSession session){
        String id = session.getAttribute("id").toString();
        ModelAndView m = new ModelAndView();
        m.setViewName("workspace/vehicle");
        m.addObject("id",id);
        return m;
    }


    @RequestMapping("investigation")  //问卷
    public ModelAndView investigation(){
        ModelAndView m = new ModelAndView();
        m.setViewName("investigation");
        return m;
    }


    @RequestMapping("addinvestation") //提交问卷
    public ModelAndView addinvestation(Investigation investigation){
        userService.addInvestation(investigation);
        return new ModelAndView("success");
    }

}
