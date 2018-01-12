package controller;

import bean.TMember;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pojo.ApiReturn;

import javax.servlet.http.HttpSession;

/**
 * author:dbing
 */

@RequestMapping("/front")
@Controller
public class SysfrontController {

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/resetpage")
    public String toResetPage(String code, String email, RedirectAttributes ra, HttpSession session){

        System.out.println("resetpage");

        //请求体
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        body.add("code",code);
        body.add("email",email);


        //创建请求
        HttpEntity entity = new HttpEntity(body,null);


        //响应
        //发送请求
        ResponseEntity<ApiReturn> responseEntity = restTemplate.postForEntity("http://localhost:8080/api/sys/validateCode",entity,ApiReturn.class);
        ApiReturn apiReturn = responseEntity.getBody();

        if(apiReturn.getCode()==1){
            //验证码错误
            ra.addFlashAttribute("msg","验证码错误");
            return "redirect:/forget.html";
        }else {
            //验证成功
            session.setAttribute("email",email);
            return "redirect:/reset.html";
        }
    }

    @PostMapping("/reset")
    public String reset(String npwd,HttpSession session){
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        body.add("userpswd",npwd);
        String email = (String) session.getAttribute("email");
        body.add("email",email);

        HttpEntity entity = new HttpEntity(body,null);
        ResponseEntity<ApiReturn> responseEntity = restTemplate.postForEntity("http://localhost:8080/api/sys/reset",entity,ApiReturn.class);

        ApiReturn apiReturn = responseEntity.getBody();

        if(apiReturn.getCode()==1){
            //重置密码失败
            session.setAttribute("msg",apiReturn.getMsg());
            return "redirect:/reset.html";
        }else {
            session.setAttribute("msg",apiReturn.getMsg());
            return "redirect:/login.html";
        }

    }

}
