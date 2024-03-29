/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.SocketDao;
import com.chuanmei.bishe.model.Socket;
import com.chuanmei.bishe.service.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocketServiceImpl implements SocketService {

    @Autowired
    private SocketDao socketDao;

    @Override
    public List<Socket> selectUnreadList(String account) {
        return socketDao.selectUnreadList(account);
    }

    @Override
    public List<Socket> selectChatList(String combination) {
        return socketDao.selectChatList(combination);
    }

    @Override
    public boolean addSocket(Socket socket) {
        return socketDao.addSocket(socket);
    }

    @Override
    public boolean updateSocket(String combination, String account,int situation) {
        return socketDao.updateSocket(combination,account,situation);
    }

    @Override
    public boolean updateIdSocket(int id, int situation) {
        return socketDao.updateIdSocket(id, situation);
    }
}
