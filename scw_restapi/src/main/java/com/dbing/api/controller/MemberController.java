package com.dbing.api.controller;

import com.dbing.api.bean.ApiReturn;
import com.dbing.api.service.TMemberService;
import com.dbing.bean.TMember;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * author:dbing
 *
 *
 */

@Api(tags = "会员操作",description = "会员登陆注册")
@Controller
@ResponseBody
@RequestMapping("/api/memeber")
public class MemberController {

    @Autowired
    TMemberService memberService;

    @ApiOperation(value = "会员注册",httpMethod = "GET")
    @RequestMapping("/regist")
    public ApiReturn<Object> regist(@ApiParam(value = "会员注册信息",required = true) TMember member){
        System.out.println("进入zhuce");
        boolean flag = false;
        try {
            flag = memberService.regist(member);
        }catch (Exception e){}

        ApiReturn<Object> apiReturn = new ApiReturn<Object>();

        if(flag){
            return ApiReturn.success("注册成功", null, null);
        }else {
            Map<String,Object> map = new HashMap<>();
            map.put("err", "用户名或是邮箱已被占用");
            return ApiReturn.fail("注册失败", null, map);
        }
    }


    @ApiOperation(value = "会员登陆",httpMethod = "post")
    @PostMapping("/login")
    public ApiReturn<TMember> login(@ApiParam(value = "会员登陆信息",required = true) TMember member){
        System.out.println("进入登录");
        TMember member1 = memberService.login(member);
        ApiReturn<TMember> apiReturn = new ApiReturn<>();



        if(member1!=null){
            System.out.println("登陆成功");
            return ApiReturn.success("登陆成功", Arrays.asList(member1), null);
        }else{
            System.out.println("登陆失败");
            return ApiReturn.fail("登陆失败", null, null);
        }

    }

}

