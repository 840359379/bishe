package com.chuanmei.bishe.configure;

import java.util.UUID;

public class MyTool {

    /**
     * 生成一个UUID
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
