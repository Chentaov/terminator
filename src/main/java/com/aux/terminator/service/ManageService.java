package com.aux.terminator.service;

import com.aux.terminator.dao.mapper.ManageMapper;
import com.aux.terminator.pojo.Notice;
import com.aux.terminator.pojo.Pages;
import com.aux.terminator.pojo.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageService {
    @Autowired
    ManageMapper manageMapper;

    public int NewVote(Vote vote){manageMapper.NewVote(vote);return vote.getVote_id();} //新建投票
    public int NewItem(String item_name,int vote_id){return manageMapper.NewItem(item_name, vote_id);} //新建投票项
    public int NewPage(Pages pages){return manageMapper.NewPage(pages);} //添加页面
    public int NewNotice(Notice notice){return manageMapper.NewNotice(notice);}//添加公告
}
