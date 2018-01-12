package com.dbing.api.controller;

import com.dbing.api.bean.ApiReturn;
import com.dbing.api.service.SystemService;
import com.dbing.bean.TMember;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * author:dbing
 */

@Api(tags = "系统操作",description = "发送邮件，重置密码，上传文件")
@Controller
@RequestMapping("/api/sys")
@ResponseBody
public class SysController {

    @Autowired
    SystemService systemService;



    @ApiOperation(value = "上传文件",httpMethod = "POST")
    @PostMapping("/upload")
    public ApiReturn<String> uploadFile(@ApiParam(value = "上传文件")@RequestParam("file") MultipartFile file, HttpSession session){
        System.out.println("-----");
        System.out.println("------->>>"+file);
        ServletContext context = session.getServletContext();
        String url = context.getRealPath("/imgs");
        String fileName = file.getOriginalFilename();
        File f = new File(url,fileName);

        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
           return ApiReturn.fail(fileName+"上传失败",null,url+"\\"+fileName);
        }
        return ApiReturn.success(fileName+"上传成功",null,url+"\\"+fileName);

    }

    /**
     * 找回密码，发送邮件
     * 可能有多种验证码的发送方式 ：手机、邮箱等
     */
    @ApiOperation(value = "发送验证码",notes = "向指定的邮箱发送随机验证码",httpMethod = "GET")
    @RequestMapping("/send/{type}/code")
    public ApiReturn<Object> sendredirct(@PathVariable("type") String type, String emailaddr, HttpSession session){
        System.out.println("----"+emailaddr);

        String code = null;
        try {
            code = systemService.send(type,emailaddr);
        } catch (Exception e) {
            e.printStackTrace();

            return ApiReturn.fail("网络异常，发送邮件失败",null,null);
        }
        ServletContext context = session.getServletContext();
        //保存服务器生成的验证码
        context.setAttribute(emailaddr,code);
        return ApiReturn.success("邮件发送成功",null,null);
    }


    @ApiOperation(value = "校验验证码",httpMethod = "GET")
    @RequestMapping("/validateCode")
    public ApiReturn<Object> validateCode(String email,String code,HttpSession session){
        ServletContext context = session.getServletContext();
        String validate = (String)context.getAttribute(email);

        context.removeAttribute(email);

        if(!code.equals(validate)){
            return new ApiReturn<Object>().fail("验证码错误",null,null);
        }else {
            return new ApiReturn<Object>().success("验证成功",null,null);
        }


    }
    @ApiOperation(value = "验证码重置密码",httpMethod = "GET")
    @RequestMapping("/reset")
    public ApiReturn<Object> reset(TMember member){
        boolean f = systemService.reset(member);

        if(f){
            return new ApiReturn<>().success("密码重置成功",null,null);
        }{
            return new ApiReturn<>().fail("网络异常，密码重置失败",null,null);
        }
    }




    //第二种发送一封重置密码的url链接
    @ApiOperation(value = "发送重置密码链接邮件",httpMethod = "GET")
    @RequestMapping("/url/sendUrlEmail")
    public ApiReturn<Object> sendUrlEmail(String emailaddr){
        System.out.println(emailaddr);

        try {
            String token = systemService.send(emailaddr);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiReturn<>().fail("网络异常，邮件发送失败",null,null);
        }

        return new ApiReturn<>().success("邮件发送成功",null,null);
    }

    @ApiOperation(value = "链接重置密码",httpMethod = "GET")
    @RequestMapping("/url/reset")
    public ApiReturn<Object> resetUrl(String token,String nwpsd,HttpSession session){
        TMember member = new TMember();
        member.setUserpswd(nwpsd);

        String email = (String) session.getServletContext().getAttribute(token);

        member.setEmail(email);
        boolean f = systemService.reset(member);

        if(f){
            return new ApiReturn<>().success("密码重置成功",null,null);
        }{
            return new ApiReturn<>().fail("网络异常，密码重置失败",null,null);
        }
    }
}
