/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.FollowDao;
import com.chuanmei.bishe.model.Follow;
import com.chuanmei.bishe.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    @Override
    public int yesterdayFollow(String coveraccount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();
        String startTime = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);
        String endTime = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(date);
        return followDao.yesterdayFollow(coveraccount,startTime,endTime);
    }
}
