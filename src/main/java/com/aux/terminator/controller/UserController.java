package com.aux.terminator.controller;
import com.alibaba.fastjson.JSONObject;
import com.aux.terminator.pojo.User;
import com.aux.terminator.pojo.Voter;
import com.aux.terminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("workspace/tel") //电话簿
    public ModelAndView tel(){
        ModelAndView m = new ModelAndView();
        m.setViewName("workspace/tel");
        return m;
    }

    @RequestMapping("dosigin")  //登录
    public int dosigin(User user, HttpServletRequest request){
        int flag = 0;
        HttpSession session = request.getSession();
       if( userService.signin(user)!=null){
           session.setAttribute("id",user.getId());
           flag = 1;
       }
        return  flag;
    }

    @RequestMapping("testpass")  //登录
    public int testpass(User user){
        int flag = 0;
        if( userService.signin(user)!=null){
            flag = 1;
        }
        return  flag;
    }

    @RequestMapping("loguot") //退出
    public RedirectView logout(HttpSession session){
        session.removeAttribute("id");
        RedirectView r = new RedirectView();
        r.setContextRelative(true);
        r.setUrl("/signin");
        return r;
    }


    @RequestMapping("dovote")
    public JSONObject dovote(Voter voter){
        JSONObject j =new JSONObject();
         if(userService.voted(voter)!=null){ //如果该用户已在该投票产生记录
             int subItemId = userService.findSubItemId(voter);
             j.put("subItemId",subItemId); //要减少投票数的id传给前端处理
             userService.itemNumSub(voter);
             if(userService.itemed(voter)!=null){
                 j.put("itemed",true);
             }
             userService.resetVote(voter);//重置投票情况
             userService.voteById(voter);
             int plusItemId = userService.findPlusItemId(voter.getItem_id());
             j.put("plusItemId",plusItemId);
             userService.itemNumPlus(voter.getItem_id());
             int itemedId = userService.itemed(voter).getItem_id();
             j.put("itemedId",itemedId);
         }
         else{
             userService.voteById(voter);
             int newPlusItemId = userService.findPlusItemId(voter.getItem_id());
             System.out.println(newPlusItemId);
             j.put("newPlusItemId",newPlusItemId);
             userService.itemNumPlus(voter.getItem_id());
         }
        return j;

    }

//    @RequestMapping("addUser")
//    public void addUser(){
//        for(int i = 3;i<=48;i++){
//            for(int j = 1;j<=4;j++){
//                String id = "3-2-"+i+"0"+j;
//                String password = "3-2-"+i+"0"+j;
//                userService.addUser(id,password);
//            }
//        }
//    }

    @RequestMapping("doresetpass") //重置密码
    public RedirectView doresetpass(User user,HttpSession session){
        String url = "404";
        RedirectView r = new RedirectView();
        try{
            if(userService.resetPass(user)>0){
                url = "signin";
                session.removeAttribute("id");
            }
            r.setContextRelative(true);
            r.setUrl(url);
        }
        catch (Exception e){

        }
        return r;
    }

}
