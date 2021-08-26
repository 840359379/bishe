/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe;

import com.chuanmei.bishe.configure.RedisTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest()
class DemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
//    RedisTool.addStatus("840359379","任务",0);
    redisTemplate.opsForValue().set("我爱你","可爱",RedisTool.getSecondsNextEarlyMorning(), TimeUnit.SECONDS);
    System.out.println(redisTemplate.getExpire("我爱你"));
    System.out.println(redisTemplate.opsForValue().get("我爱你"));
//    redisTemplate.opsForHash().put("840359379","任务","4");
//    System.out.println((redisTemplate.opsForHash().get("das","sdad") == null) ||redisTemplate.opsForHash().get("840359379","签到").equals(0));
//    System.out.println(RedisTool.testing("840359379","任务"));
    }

    @Test
    void test1(){
        System.out.println(RedisTool.getSecondsNextEarlyMorning());
    }

}
