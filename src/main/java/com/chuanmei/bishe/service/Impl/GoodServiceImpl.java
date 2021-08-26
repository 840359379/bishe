/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.configure.RedisTool;
import com.chuanmei.bishe.dao.GoodDao;
import com.chuanmei.bishe.model.Good;
import com.chuanmei.bishe.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public boolean addgood(Good good) {
        if(good.getSituation()==1){
            RedisTool.addStatus(good.getAccount(),"good",1);
        }
        return goodDao.addGood(good);
    }

    @Override
    public boolean updategood(Good good) {
        if(good.getSituation()==1){
            RedisTool.addStatus(good.getAccount(),"good",1);
        }
        return goodDao.updataGood(good);
    }

    @Override
    public List<Good> lookgoodat(String account) {
        return goodDao.lookGoodat(account);
    }

    @Override
    public List<Good> lookgoodnr(String number) {
        return goodDao.lookGoodnr(number);
    }

    @Override
    public Good selectGood(int number, String account) {
        return goodDao.selectGood(number,account);
    }

    @Override
    public int yesterdayGood(String account) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();
        String startTime = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);
        String endTime = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(date);
        return goodDao.yesterdayGood(account,startTime,endTime);
    }
}
