package com.dbing.api.service.impl;

import com.dbing.api.service.SystemService;
import com.dbing.bean.TMember;
import com.dbing.bean.TMemberExample;
import com.dbing.repository.TMemberMapper;
import com.dbing.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import java.util.UUID;

/**
 * author:dbing
 */

@Service
public class SystemServiceImpl implements SystemService,ServletContextAware {

    @Autowired
    JavaMailSender sender;
    @Autowired
    TMemberMapper memberMapper;

    private ServletContext context;


    @Override
    public String send(String type, String emailaddr) throws Exception {
        String code = UUID.randomUUID().toString().replace("_","").substring(0,5);

        if(type.equals("email")){
            //1.利用Spring 的邮件发送器
            //2.利用javaMailSender,创建一个有内容类型的邮件，MimeMessage,
            MimeMessage message = sender.createMimeMessage();

            //3.利用MimeMessageHelper定制邮件
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.addTo(emailaddr);
            helper.setFrom("www.dbing.com");
            helper.setSubject("找回密码");
            helper.setText("<h1>找回密码，你的验证码是："+code+"</h1>",true);


            sender.send(message);
            System.out.println("邮件发送成功");
        }

        return code;
    }

    @Override
    public boolean reset(TMember member) {

        member.setUserpswd(MD5Utils.digestPwd(member.getUserpswd()));
        TMemberExample example = new TMemberExample();
        example.createCriteria().andEmailEqualTo(member.getEmail());
        int i = memberMapper.updateByExampleSelective(member,example);

        return i>0?true:false;
    }

    @Override
    public String send(String email) throws Exception {


        //设置令牌
        String token  = UUID.randomUUID().toString();
        System.out.println(token);

        //利用JavaMailSender创建一封有类型的邮件
        MimeMessage message = sender.createMimeMessage();

        //利用MimeMessageHelper定制邮件
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("www.dbing.com");
        helper.setSubject("找回密码");
        helper.addTo(email);
        helper.setText("<h1>重置密码链接</h1><br><a href='http://localhost:8082/reset2.html?token="+token+"'>重置密码</a>",true);

        sender.send(message);

        context.setAttribute(token,email);
        return token;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        context = servletContext;
    }
}
