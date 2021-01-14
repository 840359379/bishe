package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodDao {
	//点赞
	public void addgood(String number,String account);
	//取消点赞
	public void deletegood(String number,String account);
	//根据用户查看点赞
	public List<Good> lookgoodat(String account);
	//根据帖子查看点赞
	public List<Good> lookgoodnr(String number);
}
