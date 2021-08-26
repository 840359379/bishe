/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Collection;

import java.util.List;

public interface CollectionService {
    /**
     * 查找我的收藏列表
     * @param account
     * @return
     */
    public List<Collection> lookCollections(String account);

    /**
     * 是否存在一个收藏
     * @param number 贴子编号
     * @param account   用户id
     * @return
     */
    public boolean seletCollection(String number,String account);

    /**
     * 添加一个收藏
     * @param number
     * @param account
     * @return
     */
    public boolean addCollection(String number,String account);

    /**
     * 取消收藏
     * @param number
     * @param account
     * @return
     */
    public boolean deleteCollection(String number,String account);

    /**
     * 我的第一个贴子的时间
     * @param account
     * @return
     */
    public String selectTime(String account);
}
