package com.dbing.service.impl;

import com.dbing.bean.TUser;
import com.dbing.bean.TUserExample;
import com.dbing.repository.TUserMapper;
import com.dbing.service.TUserService;
import com.dbing.utils.DateTimeUtils;
import com.dbing.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:dbing
 */
@Service
public class TUserServiceImpl implements TUserService {
    @Autowired
    TUserMapper tUserMapper;

    public TUser login(TUser tUser){
        TUserExample example = new TUserExample();
        example.createCriteria().andLoginacctEqualTo(tUser.getLoginacct())
                .andUserpswdEqualTo(MD5Utils.digestPwd(tUser.getUserpswd()));
        List<TUser> list = tUserMapper.selectByExample(example);
        return list.size()>0?list.get(0):null;
    }

    public boolean reg(TUser tUser){
        tUser.setCreatetime(DateTimeUtils.getFormatCurrentTime());
        tUser.setUserpswd(MD5Utils.digestPwd(tUser.getUserpswd()));
        tUser.setUsername(tUser.getLoginacct());

        int row = tUserMapper.insertSelective(tUser);

        return row==1;
    }

    @Override
    public List<TUser> getAllUsers(String condition) {

        TUserExample example = new TUserExample();
        example.createCriteria().andUsernameLike(condition);
        example.or(example.createCriteria().andEmailLike(condition));
        example.or(example.createCriteria().andLoginacctLike(condition));

        return tUserMapper.selectByExample(example);
    }

    @Override
    public void batchDelete(List<Integer> list) {
       TUserExample example = new TUserExample();
       example.createCriteria().andIdIn(list);
       tUserMapper.deleteByExample(example);
    }

    @Override
    public TUser getUserByid(Integer id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(TUser user) {
        tUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void addUser(TUser user) {
        tUserMapper.insertSelective(user);
    }
}
