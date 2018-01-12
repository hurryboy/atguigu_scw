package com.dbing.api.controller;

import com.dbing.api.bean.ApiReturn;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author:dbing
 */
@ResponseBody
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {Exception.class})
    public ApiReturn<Object> getException(Exception e){
       System.out.println(e.getMessage());
        System.out.println("-------------------数据库连接问题");
        return ApiReturn.fail("数据库连接异常",null,null);
    }

}
