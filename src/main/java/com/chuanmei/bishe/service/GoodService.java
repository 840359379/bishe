package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Good;

import java.util.List;

public interface GoodService {
    //点赞
    public boolean addgood(Good good);
    //取消点赞
    public boolean updategood(Good good);
    //根据用户查看点赞
    public List<Good> lookgoodat(String account);
    //根据帖子查看点赞
    public List<Good> lookgoodnr(String number);

    public Good selectGood(int number,String account);

    /**
     * 昨天获得的点赞
     * @param account
     * @return
     */
    public int yesterdayGood(String account);

}
