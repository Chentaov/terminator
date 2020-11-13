package com.aux.terminator.dao.mapper;

import com.aux.terminator.pojo.Notice;
import com.aux.terminator.pojo.Pages;
import com.aux.terminator.pojo.Vote;
import com.aux.terminator.pojo.Vote_item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
@Mapper
public interface ManageViewMapper {
    List<Vote> findAllVote(); //查询所有投票信息
    Vote findVoteById(int vote_id); //根据id查询投票
    List<Vote_item> findItemById(int vote_id);//根据id查询投票项
    Vote findVotedItem(int vote_id,String voter_id);//根据用户id和投票id找该用户投票的项
    List<Pages> findPageByType(String type);//根据类别找出页面
    List<Notice> findNotice();//查找所有公告
    Notice findNoticeById(int id);//根据id查公告
}
