package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.Invitation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InvitationDao {
	//发帖子
	public void publishinvitation(String number,String account,String time,String title,String subtitle,String text);
	//删帖子
	public void deleteinvitation();
	//查看帖子
	public Invitation lookinvitation(String number);
	//查看我的帖子
	public List<Invitation> lookmyinvitations(String account);
	//找帖子
	public List<Invitation> seekinvitations(String name);
	//展示所有帖子
	public List<Invitation> lookinvitations();
}
