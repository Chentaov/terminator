package com.aux.terminator.dao.mapper;

import com.aux.terminator.pojo.Investigation;
import com.aux.terminator.pojo.User;
import com.aux.terminator.pojo.Voter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository()
@Mapper
public interface UserMapper {
    int addInvestation(Investigation investigation);
    User signin(User user);//登录
    Voter voted(Voter voter); //是否在投票组投票了
    Voter itemed(Voter voter);//是否在选项投票了
    int voteById(Voter voter); //根据id投票
    int resetVote(Voter voter); //重新投票重置投票情况
    int itemNumPlus(int item_id);//增加该投票项数目
    int itemNumSub(Voter voter);//减少投票项数目
    int findSubItemId(Voter voter); //返回减少投票数目的项id
    int findPlusItemId(int plusItemId);//返回增加投票数目的项id
    int addUser(String id,String password);
    int resetPass(User user);//重置密码
}
