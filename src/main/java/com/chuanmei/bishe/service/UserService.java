package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.User;

public interface UserService {
    //登录
    public User record(String id, String pw);
    //注册
    public boolean register();
    //修改
    public void modify(String id,String column,String cover,String originalcover);
    //用户名
    public User chaname(String id);
}
