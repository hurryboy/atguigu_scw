package com.dbing.api.bean;

import com.google.common.hash.HashCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:dbing
 *
 *
 * 抽取公共的返回结果
 *
 */
public class ApiReturn<T> {

    private Integer code;//状态码，  0 成功  1  失败
    private String msgs;//信息提示
    private List<T> content;//返回给页面的数据
    private Object ext;//可拓展的数据


    //成功
    public static<E> ApiReturn<E> success(String msg,List<E> content,Object ext){
        ApiReturn<E> apiReturn = new ApiReturn<>();
        apiReturn.setCode(0);
        apiReturn.setContent(content);
        apiReturn.setMsgs(msg);
        apiReturn.setExt(ext);

        return apiReturn;
    }


    //失败
    public static<E> ApiReturn<E> fail(String msg,List<E> content,Object ext){
        ApiReturn<E> apiReturn = new ApiReturn<>();
        apiReturn.setCode(1);
        apiReturn.setContent(content);
        apiReturn.setMsgs(msg);
        apiReturn.setExt(ext);

        return apiReturn;
    }


    //额外消息ext拓展
    public ApiReturn<T> ext(String key,Object value){
        if(ext==null){
            ext = new HashMap<String,Object>();
        }
        if(ext instanceof Map){
            ((Map) ext).put(key,value);
        }
        return this;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsgs() {
        return msgs;
    }

    public void setMsgs(String msgs) {
        this.msgs = msgs;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }
}
