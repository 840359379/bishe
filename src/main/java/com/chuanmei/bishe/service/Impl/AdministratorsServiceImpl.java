package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.AdministratorsDao;
import com.chuanmei.bishe.model.Administrators;
import com.chuanmei.bishe.service.AdministratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorsServiceImpl implements AdministratorsService {

    @Autowired
    private AdministratorsDao administratorsDao;

    @Override
    public Administrators selectAdministrators(String account, String password) {
        return administratorsDao.selectAdministrators(account, password);
    }
}
