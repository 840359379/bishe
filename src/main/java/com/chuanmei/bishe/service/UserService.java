package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.User;

import java.util.List;

public interface UserService {
    //登录
    public User record(String id, String pw);
    //注册
    public boolean register(User user);
    //修改
    public boolean modify(User user);
    //用户名
    public List<User> chaname(String id);
    /**
     *增加硬币数量
     * @return
     */
    public boolean addCoin();

    /**
     * 投币
     * @param account
     * @param coverAccount
     * @param count
     * @param number
     * @return
     */
    public boolean operatedCoin(String account,String coverAccount,int count,int number);
}
