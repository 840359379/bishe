package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Socket;

import java.util.List;

public interface SocketService {

    /**
     * 查找所有未读的消息,和近期的联系人
     * @param account
     * @return
     */
    public List<Socket> selectUnreadList(String account);

    /**
     * 查看消息列表
     * @param combination
     * @return
     */
    public List<Socket> selectChatList(String combination);

    /**
     * 发送一条消息
     * @param socket
     * @return
     */
    public boolean addSocket(Socket socket);
}
