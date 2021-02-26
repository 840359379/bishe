package com.chuanmei.bishe.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTool {

    private static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisTool.redisTemplate = redisTemplate;
    }

    public static int testing(String account,String task){
        int status;
        if(redisTemplate.opsForValue().get(account+task) == null ){
            status = 0;
        }else {
            status = (int) redisTemplate.opsForValue().get(account + task);
        }
        return status;
    }

    public static void addStatus(String account, String task, int status){
        if((redisTemplate.opsForValue().get(account+task) == null) || redisTemplate.opsForValue().get(account+task).equals(1)){
            redisTemplate.opsForValue().set(account + task,status,getSecondsNextEarlyMorning(), TimeUnit.SECONDS);
        }
    }

    public static Long getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        // 改成这样就好了
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }


}
