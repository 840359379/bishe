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

    public static String combination(String x1,String x2){
        String count=null;
        if(x1.length() < x2.length()){
            count = x1 + x2;
        }else if(x1.length() > x2.length()){
            count = x2 + x1;
        }else {
            if(x1.compareTo(x2) > 0){
                count = x2 + x1;
            }else {
                count = x1 + x2;
            }
        }
        return count;
    }
}
