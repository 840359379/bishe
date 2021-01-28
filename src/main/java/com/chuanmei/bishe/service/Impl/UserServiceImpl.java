package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.UserDao;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User record(String id, String pw) {
        return userDao.record(id,pw);
    }

    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }

    @Override
    public boolean modify(User user) {
        return userDao.modify(user);
    }

    @Override
    public User chaname(String id) {
        return userDao.chaname(id);
    }
}
