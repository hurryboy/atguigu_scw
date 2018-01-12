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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * author:dbing
 */
@Controller
public class MemberFrontController {

    //它是线程安全的，所以可以定义为全局变量
    RestTemplate restTemplate = new RestTemplate();


    @PostMapping("/member/login")
    public String login(TMember member, RedirectAttributes ra, HttpSession session){
        System.out.println("登录sss");
        //使用Spring的REST Template向api 发起登录请求
        //自定义请求头  HttpHeaders headers = new HttpHeaders();  headers.add("","");
        HttpHeaders headers = new HttpHeaders();
        //请求体，使用LinkedMultiValueMap<>()
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        body.add("loginacct",member.getLoginacct());
        body.add("userpswd",member.getUserpswd());

        //创建Http请求
        HttpEntity entity = new HttpEntity(body,headers);
        //定义响应体
        ResponseEntity<ApiReturn<TMember>> responseEntity = null;

        try{
            responseEntity = restTemplate.exchange("http://localhost:8081/api/memeber/login", HttpMethod.POST,entity,new ParameterizedTypeReference<ApiReturn<TMember>>(){});
        }catch (Exception e){
        }



        ApiReturn<TMember> apiReturn = responseEntity.getBody();
        if(apiReturn.getCode()==1){
            ra.addFlashAttribute("msg","登陆失败");
            return "redirect:/login.html";
        }

        TMember login = apiReturn.getContent().get(0);

        //登陆成功将用户保存到session中
        session.setAttribute("login", login);
        return "redirect:/index.jsp";
    }


    @RequestMapping("/member/logout")
    public String logout(HttpServletRequest request){
        System.out.println("1223123");
        HttpSession session = request.getSession();
        session.removeAttribute("login");
        return "redirect:/login.html";
    }
}
