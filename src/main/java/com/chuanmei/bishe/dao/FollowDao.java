/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.Follow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowDao {
	//添加关注
	public boolean addfollow(Follow follow);
	//删除关注
	public boolean deletefollow(String account,String coveraccount);
	//查看关注
	public List<Follow> lookfollow(String account);
	//查看粉丝
	public List<Follow> coverlookfollow(String account);
	//查看是否存在此关注
	public boolean selectFollow(Follow follow);
	//查看昨日新增粉丝
	public int yesterdayFollow(String coveraccount,String startTime,String endTime);
}
