package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Content;

import java.util.List;

public interface ContentService {

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
