package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.Invitation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InvitationDao {
	//发帖子
	public int publishinvitation(Invitation invitation);
	//删帖子
	public boolean deleteinvitation(int number);
	//查看帖子
	public Invitation lookinvitation(int number);
	//查看我的帖子
	public List<Invitation> lookmyinvitations(String account);
	//找帖子
	public List<Invitation> seekinvitations(String name);
	//展示所有帖子
	public List<Invitation> lookinvitations();
	//插入文章存入地点
	public void updataText(String text,int number);
}
