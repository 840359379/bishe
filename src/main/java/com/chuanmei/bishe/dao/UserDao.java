package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
	//登录
	public User record(String id, String pw);
	//注册
	public boolean register(User user);
	//修改
	public void modify(User user);
	//用户名查找
	public User chaname(String id);
}
