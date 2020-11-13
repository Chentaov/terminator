package com.aux.terminator.service;

import com.aux.terminator.dao.mapper.ManageViewMapper;
import com.aux.terminator.pojo.Notice;
import com.aux.terminator.pojo.Pages;
import com.aux.terminator.pojo.Vote;
import com.aux.terminator.pojo.Vote_item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageViewService {
    @Autowired
    ManageViewMapper mvp;
    public List<Vote> findAllVote(){return mvp.findAllVote();} //返回所有投票信息
    public Vote findVoteById(int vote_id){return mvp.findVoteById(vote_id);} //根据id返回投票信息
    public List<Vote_item> findItemById(int vote_id){return mvp.findItemById(vote_id);} //根据id返回投票项
    public Vote findVotedItem(int vote_id,String voter_id){return mvp.findVotedItem(vote_id,voter_id);}//根据用户id和投票id找该用户投票的项
    public List<Pages> findPageByType(String type){return mvp.findPageByType(type);}//根据类别找出页面
    public List<Notice> findNotice(){return mvp.findNotice();}//查找公告
    public Notice findNoticeById(int id){return mvp.findNoticeById(id);}//根据id查公告
}
