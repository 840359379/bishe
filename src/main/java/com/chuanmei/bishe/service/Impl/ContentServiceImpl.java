package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.configure.RedisTool;
import com.chuanmei.bishe.dao.ContentDao;
import com.chuanmei.bishe.model.Content;
import com.chuanmei.bishe.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
