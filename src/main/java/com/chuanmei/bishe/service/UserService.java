package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.User;

public interface UserService {
    //登录
    public User record(String id, String pw);
    //注册
    public boolean register(User user);
    //修改
    public boolean modify(User user);
    //用户名
    public User chaname(String id);
    /**
     *增加硬币数量
     * @return
     */
    public boolean addCoin();
}
