package com.chuanmei.bishe;

import com.chuanmei.bishe.configure.RedisTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest()
class DemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    RedisTool.addStatus("840359379","任务",0);
    redisTemplate.opsForHash();
//    redisTemplate.opsForHash().put("840359379","任务","4");
//    System.out.println((redisTemplate.opsForHash().get("das","sdad") == null) ||redisTemplate.opsForHash().get("840359379","签到").equals(0));
    System.out.println(RedisTool.testing("840359379","任务"));
    }

    @Test
    void test1(){
        System.out.println(RedisTool.getSecondsNextEarlyMorning());
    }

}
