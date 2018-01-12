package com.dbing.constant;

/**
 * author:dbing
 */
public enum AuthEnum {

    UNAUTH("0","未认证"),AUTHING("1","审核中"),AUTHED("2","已认证");


    private String msg;
    private String code;
    private AuthEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }



}
