/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.configure.RedisTool;
import com.chuanmei.bishe.dao.WhimsyDao;
import com.chuanmei.bishe.model.User;
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

    @Override
    public List<Whimsy> seriesWhimsy(int series) {
        return whimsyDao.seriesWhimsy(series);
    }

    @Override
    public int test(int id) {
        User whimsy =  whimsyDao.test(id);
        int count = whimsy.getCoin();
        return count;
    }
}
