package com.chuanmei.bishe.configure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 传给前端的一个封装
 * @param <T>
 */
public class CommonResult<T>{

    private Integer code;
    private String msg;
    private Integer count;
    private T data;

    public CommonResult(Integer code, String msg, Integer count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public CommonResult(Integer code, String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = 0;
    }

    public CommonResult(Integer code, String msg){
        this.code = code;
        this.msg = msg;
        this.data = null;
        this.count = 0;
    }

    public CommonResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}