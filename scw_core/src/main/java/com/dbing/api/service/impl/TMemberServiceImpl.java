package com.dbing.api.service.impl;

import com.dbing.api.service.TMemberService;
import com.dbing.bean.TMember;
import com.dbing.bean.TMemberExample;
import com.dbing.constant.AuthEnum;
import com.dbing.repository.TMemberMapper;
import com.dbing.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:dbing
 */

@Service
public class TMemberServiceImpl implements TMemberService {


    @Autowired
    TMemberMapper memberMapper;

    @Override
    public boolean regist(TMember member) {
        member.setUsername(member.getLoginacct());
        member.setUserpswd(MD5Utils.digestPwd(member.getUserpswd()));
        member.setAuthstatus(AuthEnum.UNAUTH.getCode());
        member.setUsertype("1");
        int i = memberMapper.insertSelective(member);
        return i==1?true:false;
    }

    @Override
    public TMember login(TMember member) {
        TMemberExample example = new TMemberExample();
        example.createCriteria().
                andLoginacctEqualTo(member.getLoginacct()).
                andUserpswdEqualTo(MD5Utils.digestPwd(member.getUserpswd()));

        List<TMember> list = memberMapper.selectByExample(example);

        System.out.println("---"+list);
        return list.size()>0?list.get(0):null;
    }
}
