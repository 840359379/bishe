/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.configure.RedisTool;
import com.chuanmei.bishe.dao.ContentDao;
import com.chuanmei.bishe.model.Content;
import com.chuanmei.bishe.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao contentDao;

    @Override
    public List<Content> selectList(int number) {
        return contentDao.selectList(number);
    }

    @Override
    public boolean deleteContent(int id) {
        return contentDao.deleteContent(id);
    }

    @Override
    public boolean addContent(Content content) {
        RedisTool.addStatus(content.getAccount(),"content",1);
        return contentDao.addContent(content);
    }

    @Override
    public Integer test(Integer id){
        List<Content> list = new ArrayList<>();
        Content content1 = new Content();
        content1.setId(13);
        content1.setContent("愚蠢呦");
        Content content2 = new Content();
        content2.setId(31);
        content2.setContent("好嗨哟");
        list.add(content1);
        list.add(content2);
        Integer r = contentDao.test(list);
        return r;
    }
}
