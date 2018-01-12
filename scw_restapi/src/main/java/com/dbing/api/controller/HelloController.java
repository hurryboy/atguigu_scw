package com.dbing.api.controller;

import com.dbing.bean.TUser;
import com.dbing.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

/**
 * author:dbing
 */

@Api(tags = "测试Controller")
@Controller
public class HelloController {

    @Autowired
    TUserService userService;

    @ApiOperation(value = "helloWorld-Controlle",notes = "测试helloController",httpMethod = "GET")
    @ResponseBody
    @RequestMapping("/api/hello")
    public /*Map<String,Object>*/ String hello(){
        HashMap<String,Object> map = new HashMap();
        map.put("time",new Date());
        TUser u = userService.getUserByid(39);
        map.put("user",u);


        return "success('hello')";
    }

}
