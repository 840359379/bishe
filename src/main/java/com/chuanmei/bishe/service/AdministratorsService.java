package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Administrators;

public interface AdministratorsService {

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    Administrators selectAdministrators(String account, String password);
}
