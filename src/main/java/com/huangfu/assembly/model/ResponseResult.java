package com.huangfu.assembly.model;

import java.io.Serializable;

/**
 * 返回结果
 *
 * @author huangfu
 * @date 2021年2月20日13:29:39
 */
public class ResponseResult implements Serializable {

    private final String code;
    private final String msg;
    private Object data;

    public ResponseResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResponseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseResult success(Object data){
        return new ResponseResult("000000","成功",data);
    }


    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public static ResponseResult error(){


        return new ResponseResult("500000","失败");
    }
}
