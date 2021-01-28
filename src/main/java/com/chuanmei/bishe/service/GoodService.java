package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Good;

import java.util.List;

public interface GoodService {
    //点赞
    public boolean addgood(String number,String account);
    //取消点赞
    public boolean deletegood(String number,String account);
    //根据用户查看点赞
    public List<Good> lookgoodat(String account);
    //根据帖子查看点赞
    public List<Good> lookgoodnr(String number);
}
