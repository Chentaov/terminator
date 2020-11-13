package com.aux.terminator.service;

import com.aux.terminator.dao.mapper.UserMapper;
import com.aux.terminator.pojo.Investigation;
import com.aux.terminator.pojo.User;
import com.aux.terminator.pojo.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService  {
    @Autowired
    UserMapper userMapper;
    public int addInvestation(Investigation investigation){return userMapper.addInvestation(investigation);} //问卷
    public User signin(User user){return userMapper.signin(user);} //登录
    public Voter voted(Voter voter){return userMapper.voted(voter);} //是在投票组否投票了
    public Voter itemed(Voter voter){return userMapper.itemed(voter);} //是否在选项投票了
    public int voteById(Voter voter){return userMapper.voteById(voter);} //根据id投票
    public int resetVote(Voter voter){return userMapper.resetVote(voter);}//重置投票情况
    public int itemNumPlus(int item_id){return userMapper.itemNumPlus(item_id);} //更新投票项数目
    public int itemNumSub(Voter voter){return userMapper.itemNumSub(voter);} //减少投票项数目
    public int findSubItemId(Voter voter){return userMapper.findSubItemId(voter);}//返回减少投票数目项的id
    public int findPlusItemId(int plusItemId){return userMapper.findPlusItemId(plusItemId);} //返回增加投票项数目项的id
    public int addUser(String id,String password){return userMapper.addUser(id,password);}
    public  int resetPass(User user){return userMapper.resetPass(user);}//重置密码
}
