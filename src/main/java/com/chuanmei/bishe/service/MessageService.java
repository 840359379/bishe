/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Message;

import java.util.List;

public interface MessageService {

    /**
     * 添加一条留言
     * @param message
     * @return
     */
    public boolean addMessage(Message message);

    /**
     * 删除我的留言
     * @param id
     * @return
     */
    public boolean deleteMessage(int id);

    /**
     * 查看我的留言
     * @param coverAccount
     * @return
     */
    public List<Message> selectMessages(String coverAccount);
}
