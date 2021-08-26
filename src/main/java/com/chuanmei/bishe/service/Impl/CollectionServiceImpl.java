/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.CollectionDao;
import com.chuanmei.bishe.model.Collection;
import com.chuanmei.bishe.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionDao collectionDao;

    @Override
    public List<Collection> lookCollections(String account) {
        return collectionDao.lookCollections(account);
    }

    @Override
    public boolean seletCollection(String number, String account) {
        return collectionDao.seletCollection(number,account);
    }

    @Override
    public boolean addCollection(String number, String account) {
        return collectionDao.addCollection(number,account);
    }

    @Override
    public boolean deleteCollection(String number, String account) {
        return collectionDao.deleteCollection(number,account);
    }

    @Override
    public String selectTime(String account) {
        return collectionDao.selectTime(account);
    }
}
