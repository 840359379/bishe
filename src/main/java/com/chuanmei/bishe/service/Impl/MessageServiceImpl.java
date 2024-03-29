/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.MessageDao;
import com.chuanmei.bishe.model.Message;
import com.chuanmei.bishe.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public boolean addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    @Override
    public boolean deleteMessage(int id) {
        return messageDao.deleteMessage(id);
    }

    @Override
    public List<Message> selectMessages(String coverAccount) {
        return messageDao.selectMessages(coverAccount);
    }
}
