/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Uploads;

import java.util.List;

public interface UploadService {

    /**
     * 添加一个文件
     * @param uploads
     * @return
     */
    public boolean addUploads(Uploads uploads);

    /**
     * 删除一个文件
     * @param id
     * @return
     */
    public boolean deleteUploads(String id);

    /**
     * 查看所有文件
     * @param account
     * @return
     */
    public List<Uploads> selectList(String account);

    /**
     * 是否存在一个文件
     * @param account
     * @param name
     * @return
     */
    public Uploads selectUploads(String account,String name);

    /**
     * 查看一个所属的文件
     * @param geared
     * @return
     */
    public List<Uploads> selectGeared(int geared);
}
