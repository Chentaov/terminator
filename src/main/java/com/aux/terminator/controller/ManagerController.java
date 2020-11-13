package com.aux.terminator.controller;

import com.aux.terminator.pojo.Notice;
import com.aux.terminator.pojo.Pages;
import com.aux.terminator.pojo.Vote;
import com.aux.terminator.service.ManageService;
import com.aux.terminator.tool.DataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("/")
public class ManagerController {

    @Autowired
    ManageService manageService;


    @RequestMapping("newvote")
    public RedirectView newvote(Vote vote){ //执行投票
        int id = manageService.NewVote(vote);
        String url = "404";
        DataTransfer d = new DataTransfer();
        String []  item_Array = d.PickItemsWith(',',vote.getItem_name());
        for(int i = 0;i<item_Array.length;i++){
            if(item_Array[i]!=null){
                manageService.NewItem(item_Array[i],id);
            }
        }
        url = "success";
        RedirectView r = new RedirectView();
        r.setContextRelative(true);
        r.setUrl(url);
        return r;
    }

    @RequestMapping("addpage") //添加页面
    public RedirectView addpage(Pages pages){
        String url = "404";
        if(manageService.NewPage(pages)>0){
            url = "success";
        }
        RedirectView r = new RedirectView();
        r.setContextRelative(true);
        r.setUrl(url);
        return r;
    }

    @RequestMapping("newnotice")//添加公告
    public RedirectView newnotice(Notice notice){
        String url = "404";
        if(manageService.NewNotice(notice)>0){
            url = "/workspace/main";
        }
        RedirectView r = new RedirectView();
        r.setContextRelative(true);
        r.setUrl(url);
        return r;
    }

}
