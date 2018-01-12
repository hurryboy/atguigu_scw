package com.dbing.api.controller;

import com.dbing.api.bean.ApiReturn;
import com.dbing.bean.*;
import com.dbing.service.ProjectService;
import com.dbing.service.TProjectResourcesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * author:dbing
 */
@Api(tags = "项目操作",description = "有关发起项目的基本操作")
@RestController//@Controller @ResponseBody
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    TProjectResourcesService tProjectResourcesService;



    @ApiOperation(value = "项目的类型",notes ="获取所有的项目类型",httpMethod = "GET")
    @RequestMapping("/types")
    public ApiReturn<TType> getTypes(){
        List<TType> list = projectService.getTypes();
        return new ApiReturn<TType>().success("获取所有的项目类型成功",list,null);
    }

    @ApiOperation(value = "项目标签",notes = "获取所有的项目标签",httpMethod = "GET")
    @RequestMapping("/tags")
    public ApiReturn<TTag> getTags(){
        List<TTag> lsit = projectService.getTags();
        return new ApiReturn<>().success("获取所有的项目标签成功",lsit,null);
    }

    @ApiOperation(value = "项目回报",notes = "获取当前项目的所有回报信息",httpMethod = "GET")
    @RequestMapping("/returns")
    public ApiReturn<TReturn> getTReturns(@ApiParam(value = "项目id",required = true)@RequestParam("pid") Integer pid){
        List<TReturn> list = projectService.getTReturnsByPid(pid);
        return new ApiReturn<>().success("获取当前项目所有回报成功",list,null);
    }

    @ApiOperation(value = "修改指定的项目回报",httpMethod = "POST")
    @RequestMapping("/editReturn")
    public ApiReturn editReturn(@ApiParam(value = "回报",required = true) TReturn tReturn){
        boolean f = false;
        try {
            f = projectService.eidtReturn(tReturn);
        } catch (Exception e) {
            e.printStackTrace();
            return result("修改指定的项目回报",false);
        }
        return result("修改指定的项目回报",f);
    }

    @ApiOperation(value = "删除指定的项目回报",httpMethod = "GET")
    @RequestMapping("/deleteReturnById")
    public ApiReturn deleteReturnById(@ApiParam(value = "回报id",required = true)@RequestParam("rid")Integer rid){
         boolean f;
        try {
           f = projectService.deleteReturnById(rid);
        } catch (Exception e) {
            e.printStackTrace();
            return result("删除指定的项目回报",false);
        }
        return result("删除指定的项目回报",f);
    }


    @ApiOperation(value = "创建初始空项目",httpMethod = "POST")
    @PostMapping("/startPro")
    public ApiReturn<Object> startPro(@ApiParam(value = "创建项目的会员ID",required = true)@RequestParam("memberId") Integer memberId){

        Integer pid = projectService.createStartPro(memberId);

        return new ApiReturn<>().ext("pid",pid);

    }

    @ApiOperation(value = "保存项目标签信息",httpMethod="POST")
    @PostMapping("/savetag")
    public ApiReturn<Object> saveTag(@ApiParam(value = "项目id",required = true) @RequestParam("pid") Integer pid,
                                     @ApiParam(value = "多个标签逗号分割的字符串",required = true)@RequestParam("tags") String tags){

        //保存项目标签
        boolean f = projectService.saveProTags(pid,tags);

        return result("保存项目标签信息",f);
    }

    @ApiOperation(value = "保存项目类型",httpMethod = "POST")
    @PostMapping("/saveType")
    public ApiReturn<Object> saveType(@ApiParam(value = "项目id",required = true)@RequestParam("pid") Integer pid,
                                      @ApiParam(value = "类型id",required = true)@RequestParam("typeid")Integer typeid){

        boolean f = false;
        try {
            f = projectService.saveProTypes(pid,typeid);
        } catch (Exception e) {
            return result("保存项目类型",false);
        }

        return result("保存项目类型",f);
    }


    @ApiOperation(value = "保存项目的基本信息",httpMethod = "POST")
    @PostMapping("/saveProBaseInfo")
    public ApiReturn<Object> saveProBaseInfo(@ApiParam(value = "项目的基础信息") TProject tProject){

        System.out.println(tProject);
        boolean f = projectService.saveProBaseInfo(tProject);

        return result("保存项目的基本信息",f);
    }


    @ApiOperation(value = "保存项目图片信息",httpMethod = "POST")
    @PostMapping("/saveImgs")
    public ApiReturn<Object> saveImgs(@ApiParam(value = "项目头部图片地址",required = true) @RequestParam("headerImg") String headerImg,
                                      @ApiParam(value = "项目详情图片地址",required = true)@RequestParam("infoImg") String infoImg,
                                      @ApiParam(value = "项目id",required = true)@RequestParam("pid") Integer pid){


        System.out.println("headerImg:"+headerImg);
        System.out.println("infoImg:"+infoImg);
        System.out.println("pid:"+pid);

        boolean f = projectService.saveImgs(headerImg,infoImg,pid);

        return result("保存项目图片信息",f);

    }


    @ApiOperation(value = "保存发起人基本信息",httpMethod = "POST")
    @PostMapping("/saveOrganiser")
    public ApiReturn<Object> saveOrganiser(@ApiParam(value = "发起人信息") TProjectOrganiser tProjectOrganiser){
        System.out.println("项目发起人："+tProjectOrganiser);
        boolean f = projectService.saveOrganiser(tProjectOrganiser);

        return result("保存发起人基本信息",f);

    }

    @ApiOperation(value = "添加项目回报",httpMethod = "POST")
    @PostMapping("/saveTReturn")
    public ApiReturn<Object> saveTReturn(@ApiParam(value = "回报") TReturn tReturn){

        boolean f = projectService.saveTReturn(tReturn);

        return result("添加项目回报",f);


    }

    @ApiOperation(value = "确认支付账号和法人身份账号",httpMethod = "POST")
    @PostMapping("/confirmCard")
    public ApiReturn<Object> confirmCard(@ApiParam(value = "支付账号",required = true) @RequestParam("payCard") Integer payCard,
                                         @ApiParam(value = "法人身份证账号",required = true) @RequestParam("legalidCard") Integer legalidCard,
                                         @ApiParam(value = "项目id",required = true) @RequestParam("pid") Integer pid){

        TProjectOrganiser organiser = new TProjectOrganiser();
        organiser.setId(pid);
        organiser.setLegalcard(legalidCard);
        organiser.setPaycard(payCard);

        boolean f = projectService.confirmCard(organiser);

        return result("确认支付账号和法人身份账号",f);
    }

    @ApiOperation(value = "保存上传图片的url",httpMethod = "POST")
    @PostMapping("/saveImgUrl")
    public ApiReturn<Object> saveImgUrl(@ApiParam(value = "项目id",required = true)@RequestParam("pid")Integer pid,
                                        @ApiParam(value = "项目头图url",required = true)@RequestParam("headerImg")String headerImg,
                                        @ApiParam(value = "项目详情图片",required = true)@RequestParam("infoImg")String infoImg){

        TProjectResources resources = new TProjectResources();
        resources.setPid(pid);
        resources.setHeaderImg(headerImg);
        resources.setInfoImg(infoImg);
        Boolean f = tProjectResourcesService.saveImg(resources);

        return result("保存上传图片的url",f);

    }


    public ApiReturn<Object> result(String msg,boolean f){
        if(f){
            return new ApiReturn<>().success(msg+"成功",null,null);
        }else {
            return new ApiReturn<>().fail(msg+"失败",null,null);
        }
    }









}
