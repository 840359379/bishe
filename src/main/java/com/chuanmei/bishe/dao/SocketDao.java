package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.Socket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SocketDao {

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

    /**
     * 改变已读状态
     * @param combination
     * @return
     */
    public boolean updateSocket(String combination,String account,int situation);

    /**
     * 根据id改变已读状态
     * @param id
     * @param situation
     * @return
     */
    public boolean updateIdSocket(int id,int situation);
}
