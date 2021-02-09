package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Follow;

import java.util.List;

public interface FollowService {
    //添加关注
    public boolean addfollow(Follow follow);
    //删除关注
    public boolean deletefollow(String account,String coveraccount);
    //查看关注
    public List<Follow> lookfollow(String account);
    //查看粉丝
    public List<Follow> coverlookfollow(String account);
    //查看是否存在此关注
    public boolean selectFollow(Follow follow);
    //查看昨日新增粉丝
    public int yesterdayFollow(String coveraccount);
}
