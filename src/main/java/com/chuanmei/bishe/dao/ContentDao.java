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
}
