package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.GoodDao;
import com.chuanmei.bishe.model.Good;
import com.chuanmei.bishe.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public boolean addgood(String number, String account) {
        return goodDao.addgood(number,account);
    }

    @Override
    public boolean deletegood(String number, String account) {
        return goodDao.deletegood(number,account);
    }

    @Override
    public List<Good> lookgoodat(String account) {
        return goodDao.lookgoodat(account);
    }

    @Override
    public List<Good> lookgoodnr(String number) {
        return goodDao.lookgoodnr(number);
    }
}
