package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.Administrators;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministratorsDao {
    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    Administrators selectAdministrators(String account,String password);
}
