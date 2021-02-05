package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.FollowDao;
import com.chuanmei.bishe.model.Follow;
import com.chuanmei.bishe.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowDao followDao;

    @Override
    public boolean addfollow(Follow follow) {
        return followDao.addfollow(follow);
    }

    @Override
    public boolean deletefollow(String account, String coveraccount) {
        return followDao.deletefollow(account,coveraccount);
    }

    @Override
    public List<Follow> lookfollow(String account) {
        return followDao.lookfollow(account);
    }

    @Override
    public List<Follow> coverlookfollow(String account) {
        return followDao.coverlookfollow(account);
    }

    @Override
    public boolean selectFollow(Follow follow) {
        return followDao.selectFollow(follow);
    }
}
