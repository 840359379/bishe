package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.configure.RedisTool;
import com.chuanmei.bishe.dao.WhimsyDao;
import com.chuanmei.bishe.model.Whimsy;
import com.chuanmei.bishe.service.WhimsyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhimsyServiceImpl implements WhimsyService {

    @Autowired
    private WhimsyDao whimsyDao;

    @Override
    public boolean addWhimsy(Whimsy whimsy) {
        RedisTool.addStatus(whimsy.getAccount(),"whimsy",1);
        return whimsyDao.addWhimsy(whimsy);
    }

    @Override
    public boolean deleteWhimsy(int id) {
        return whimsyDao.deleteWhimsy(id);
    }

    @Override
    public boolean updateWhimsy(Whimsy whimsy) {
        return whimsyDao.updateWhimsy(whimsy);
    }

    @Override
    public List<Whimsy> selectList(String account) {
        return whimsyDao.selectList(account);
    }
}
