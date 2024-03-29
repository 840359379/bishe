/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.Content;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentDao {
    /**
     * 查看帖子的所有评论
     * @param number
     * @return
     */
    public List<Content> selectList(int number);

    /**
     * 删除一个评论
     * @return
     */
    public boolean deleteContent(int id);

    /**
     * 评论一个
     * @param content
     * @return
     */
    public boolean addContent(Content content);

    public Integer test(List<Content> list);
}
