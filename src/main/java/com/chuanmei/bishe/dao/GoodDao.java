/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodDao {
	//点赞
	public boolean addGood(Good good);
	//取消点赞
	public boolean updataGood(Good good);
	//根据用户查看点赞
	public List<Good> lookGoodat(String account);
	//根据帖子查看点赞
	public List<Good> lookGoodnr(String number);
	//寻找一个赞是否存在
	public Good selectGood(int number,String account);

	/**
	 * 昨天获得的点赞
	 * @param account
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public int yesterdayGood(String account,String startTime,String endTime);
}
