/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
	//登录
	public User record(String id, String pw);
	//注册
	public boolean register(User user);
	//修改
	public boolean modify(User user);
	//用户名查找
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
