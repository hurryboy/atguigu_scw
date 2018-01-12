package controller;

import bean.TMember;
import bean.TProject;
import bean.TProjectOrganiser;
import bean.TReturn;
import io.swagger.annotations.Api;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import pojo.ApiReturn;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * author:dbing
 */

@RequestMapping("/project")
@RestController
public class ProjectFrontController {

    //线程安全
    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/savePro")
    public ApiReturn<Object> savePro(
                                     @RequestParam(value = "id",required = false) Integer id,
                                     @RequestParam(value = "name",required = false) String name,
                                     @RequestParam(value = "money",required = false) Long money,
                                     @RequestParam(value = "remark",required = false) String remark,
                                     @RequestParam(value = "day",required = false) Integer day,
                                     @RequestParam(value = "headImg",required = false) MultipartFile headimg,
                                     @RequestParam(value = "infoImg",required = false) MultipartFile infoimg,
                                     @RequestParam(value = "type",required = false) Integer type,
                                     @RequestParam(value = "tags",required = false) String tags){

        System.out.println("进入");
        //保存项目基本信息
        HashMap<String,Object> proMap = new HashMap<>();
        proMap.put("id",id);
        proMap.put("remark",remark);
        proMap.put("day",day);
        proMap.put("money",money);
        proMap.put("name",name);
        //id,remark,desc,phone,servicephone
       ResponseEntity<ApiReturn> proResponseEntity = sendRequest("http://localhost:8081/api/project/saveProBaseInfo",proMap);
        ApiReturn<Object> proApi = proResponseEntity.getBody();
        if(proApi.getCode()==1){
            return ApiReturn.fail("网络异常，项目基本信息失败",null,null);
        }
        //保存项目类型
        Integer pid = id;/* project.getId();*/
        Integer typeid = type;
        HashMap<String,Object> typeMap = new HashMap<>();
        typeMap.put("pid",id);
        typeMap.put("typeid",typeid);
        ResponseEntity<ApiReturn> typeResponseEntity = sendRequest("http://localhost:8081/api/project/saveType",typeMap/*pid,typeid*/);
        ApiReturn<Object> typeApi = typeResponseEntity.getBody();
        if(typeApi.getCode()==1){
            return ApiReturn.fail("网络异常，保存项目类型失败",null,null);
        }

        //保存项目标签
        HashMap<String,Object> tagMap = new HashMap<>();
        tagMap.put("pid",id);
        tagMap.put("tags",tags);
        ResponseEntity<ApiReturn> tagResponseEntity = sendRequest("http://localhost:8081/api/project/savetag",tagMap/*tags,pid*/);
        ApiReturn<Object> tagApi = tagResponseEntity.getBody();
        if(typeApi.getCode()==1){
            return ApiReturn.fail("网络异常，保存项目标签失败",null,null);
        }


        //保存项目头图片  /api/sys/upload?file
        HashMap<String,MultipartFile> headMap = new HashMap<>();
        headMap.put("file",headimg);
        ResponseEntity<ApiReturn> headResponseEntity = sendRequestForFile("http://localhost:8081/api/sys/upload",headMap);
        ApiReturn<Object> headApi = headResponseEntity.getBody();
        if(headApi.getCode()==1){
            return ApiReturn.fail("网络异常，保存项目头图片失败",null,null);
        }
        //保存项目详情图片
        HashMap<String,MultipartFile> infoMap = new HashMap<>();
        infoMap.put("file",infoimg);
        ResponseEntity<ApiReturn> infoResponseEntity = sendRequestForFile("http://localhost:8081/api/sys/upload",infoMap);
        ApiReturn<Object> infoApi = infoResponseEntity.getBody();
        if(infoApi.getCode()==1){
            return ApiReturn.fail("网络异常，保存项目详情图片失败",null,null);
        }

        System.out.println("head:"+headApi.getExt());
        System.out.println("info:"+infoApi.getExt());

        //图片上传到本地服务器完成，向数据库中插入图片url记录
        String headerImg = (String)headApi.getExt();
        String infoImg = (String) infoApi.getExt();
        HashMap<String,Object> imgMap = new HashMap<>();
        imgMap.put("pid",id);
        imgMap.put("headerImg",headerImg);
        imgMap.put("infoImg",infoImg);
        ResponseEntity<ApiReturn> imgURLEntity = sendRequest("http://localhost:8081/api/project/saveImgs",imgMap);
        ApiReturn<Object> imgApi = imgURLEntity.getBody();
        if(imgApi.getCode()==1){
            return ApiReturn.fail("网络异常，保存图片失败",null,null);
        }

        return ApiReturn.success("项目保存信息保存成功",null,null);
    }


    @PostMapping("/saveOrga")
    public ApiReturn<Object> saveOrga(TProjectOrganiser organiser){
        System.out.println("保存发起人信息");


        //保存发起人信息
        Integer id = organiser.getId();
        String remark = organiser.getRemark();
        String desc = organiser.getDesc();
        Integer phone = organiser.getPhone();
        Integer servicephone = organiser.getServicephone();

        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("remark",remark);
        map.put("descs",desc);
        map.put("phone",phone);
        map.put("servicephone",servicephone);


        ResponseEntity<ApiReturn> responseEntity = sendRequest("http://localhost:8081/api/project/saveOrganiser",map);
        ApiReturn<Object> orApi = responseEntity.getBody();
        if(orApi.getCode()==1){
            return ApiReturn.fail("项目发起人信息保存失败",null,null);
        }
        return ApiReturn.success("项目发起人信息保存成功",null,null);
    }


    @PostMapping("/saveReturn")
    public ApiReturn saveReturn(@RequestParam("file")MultipartFile file, TReturn tReturn){
        //保存项目回报信息
        System.out.println("进入回报");
        System.out.println("---"+tReturn);
        System.out.println(file.getSize());

        //1.保存上传回报描述的图片，返回url地址
        ///api/sys//upload  file
        HashMap<String,MultipartFile> map = new HashMap<>();
        map.put("file",file);

        ResponseEntity<ApiReturn> responseEntity = sendRequestForFile("http://localhost:8081/api/sys//upload",map);
        ApiReturn<Object> apiImgReturn = responseEntity.getBody();
        if(apiImgReturn.getCode()==1){
            return ApiReturn.fail("回报说明图片保存失败",null,null);
        }
        String url = (String)apiImgReturn.getExt();

        //2.保存项目回报
        HashMap<String,Object> reMap = new HashMap<>();
        reMap.put("projectid",tReturn.getProjectid());
        reMap.put("type",tReturn.getType());
        reMap.put("supportmoney",tReturn.getSupportmoney());
        reMap.put("content",tReturn.getContent());
        reMap.put("count",tReturn.getCount());
        reMap.put("signalpurchase",tReturn.getSignalpurchase());
        reMap.put("purchase",tReturn.getPurchase());
        reMap.put("freight",tReturn.getFreight());
        reMap.put("invoice",tReturn.getInvoice());
        reMap.put("rtndate",tReturn.getRtndate());
        reMap.put("descimg",url);

        ResponseEntity<ApiReturn> responseEntity2 = sendRequest("http://localhost:8081/api/project/saveTReturn",reMap);
        ApiReturn<Object> returnApi = responseEntity2.getBody();
        if(returnApi.getCode()==1){
            return ApiReturn.fail("项目回报信息保存失败",null,null);
        }
        return ApiReturn.success("项目回报信息保存成功",null,null);
    }

    //抽取
    public ResponseEntity<ApiReturn> sendRequest(String url,HashMap<String,Object> map){
        //保存项目信息
        //使用RestTemplate远程调用
        //1.创建请求体
        MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();

        for (HashMap.Entry<String,Object> entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
            body.add(entry.getKey(),entry.getValue());
        }
        //2.创建请求
        HttpEntity entity = new HttpEntity(body,null);

        //3.发送请求，获取响应
        ResponseEntity<ApiReturn> responseEntity = restTemplate.postForEntity(url,entity,ApiReturn.class);

        return responseEntity;
    }

    //抽取
    public ResponseEntity<ApiReturn> sendRequestForFile(String url,HashMap<String,MultipartFile> map){
        MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();

        MultipartFile file = map.get("file");
        try {
            File file1 = new File(file.getOriginalFilename());
            file.transferTo(file1);
            body.add("file",new FileSystemResource(file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");
        //headers.set("Accept", "text/plain");
        HttpEntity entity = new HttpEntity(body,headers);

        //ResponseEntity<ApiReturn> responseEntity = restTemplate.postForEntity(url,entity,ApiReturn.class);
        ResponseEntity<ApiReturn> responseEntity = restTemplate.exchange(url, HttpMethod.POST,entity,ApiReturn.class);

        return responseEntity;
    }
}
