package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.UploadsDao;
import com.chuanmei.bishe.model.Uploads;
import com.chuanmei.bishe.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadsDao uploadsDao;


    @Override
    public boolean addUploads(Uploads uploads) {
        return uploadsDao.addUploads(uploads);
    }

    @Override
    public boolean deleteUploads(String id) {
        return uploadsDao.deleteUploads(id);
    }

    @Override
    public List<Uploads> selectList(String account) {
        return uploadsDao.selectList(account);
    }

    @Override
    public Uploads selectUploads(String account, String name) {
        return uploadsDao.selectUploads(account,name);
    }
}
