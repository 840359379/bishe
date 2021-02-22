package com.chuanmei.bishe.dao;


import com.chuanmei.bishe.model.Uploads;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UploadsDao {
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
}
