package com.aux.terminator.controller;

import com.aux.terminator.pojo.Notice;
import com.aux.terminator.pojo.Pages;
import com.aux.terminator.pojo.Vote;
import com.aux.terminator.pojo.Vote_item;
import com.aux.terminator.service.ManageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/")
public class ManageView {

    @Autowired
    ManageViewService mvs;


    @RequestMapping("workspace/main") //主页
    public ModelAndView Main(HttpServletRequest request){
        ModelAndView m = new ModelAndView();
        List<Pages> work = mvs.findPageByType("办事");
        List<Pages> vote = mvs.findPageByType("投票");
        List<Notice> notices = mvs.findNotice();
        System.out.println(vote);
        HttpSession session = request.getSession();
        String id = session.getAttribute("id").toString();
        m.setViewName("workspace/main");
        m.addObject("id",id);
        m.addObject("work",work);
        m.addObject("vote",vote);
        m.addObject("notices",notices);
        return m;
    }

    @RequestMapping("manage/vehicle") //管理主页
    public ModelAndView manager(){
        ModelAndView m = new ModelAndView();
        m.setViewName("manage/vehicle");
        return m;
    }

    @RequestMapping("manage/allvote") //所有投票
    public ModelAndView allvote(HttpSession session){
        String id = session.getAttribute("id").toString();
        List<Vote> votes = mvs.findAllVote();
        ModelAndView m = new ModelAndView();
        m.setViewName("manage/allvote");
        m.addObject("votes",votes);
        m.addObject("id",id);
        return m;
    }

    @RequestMapping("manage/newvote") //新建投票
    public ModelAndView newvote_title(HttpSession session){
        String id = session.getAttribute("id").toString();
        ModelAndView m = new ModelAndView();
        m.setViewName("manage/newvote");
        m.addObject("id",id);
        return m;
    }

    @RequestMapping("findVoteById") //按id查找投票
    public ModelAndView findVoteById(int vote_id,HttpSession session){
        ModelAndView m = new ModelAndView();
        try{
            String id  = session.getAttribute("id").toString();
            Vote voteInfo = mvs.findVoteById(vote_id);
            int item_id=0;
            if(mvs.findVotedItem(vote_id,id)!=null){
                 item_id = mvs.findVotedItem(vote_id,id).getItem_id();
            }
            List<Vote_item> items = mvs.findItemById(vote_id);
            m.setViewName("workspace/vote");
            m.addObject("id",id);
            m.addObject("vote",voteInfo);
            m.addObject("items",items);
            m.addObject("item_id",item_id);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return m;
    }

    @RequestMapping("manage/newpage")  //添加页面
    public ModelAndView newpage(HttpSession session){
        ModelAndView m = new ModelAndView();
        String id = session.getAttribute("id").toString();
        m.addObject("id",id);
        m.setViewName("manage/newpage");
        return m;
    }

    @RequestMapping("manage/notice")  //添加页面
    public ModelAndView notice(HttpSession session,int notice_id){
        Notice notice = mvs.findNoticeById(notice_id);
        ModelAndView m = new ModelAndView();
        String id = session.getAttribute("id").toString();
        m.addObject("id",id);
        m.addObject("notice",notice);
        m.setViewName("manage/notice");
        return m;
    }

    @RequestMapping("manage/newnotice") //发布公告
    public ModelAndView newnotice(HttpSession session){
        String id = session.getAttribute("id").toString();
        ModelAndView m = new ModelAndView();
        m.setViewName("manage/newnotice");
        m.addObject("id",id);
        return m;
    }



}
