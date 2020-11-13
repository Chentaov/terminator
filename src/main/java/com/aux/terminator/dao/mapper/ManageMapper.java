package com.aux.terminator.dao.mapper;

import com.aux.terminator.pojo.Notice;
import com.aux.terminator.pojo.Pages;
import com.aux.terminator.pojo.Vote;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository()
@Mapper
public interface ManageMapper {

    int NewVote(Vote vote); //新建投票
    int NewItem(String item_name,int vote_id);//新建投票项
    int NewPage(Pages pages);//添加页面
    int NewNotice(Notice notice); //添加公告
}


