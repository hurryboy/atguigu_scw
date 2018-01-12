package com.dbing.service;

import com.dbing.bean.TUser;

import java.util.List;

/**
 * author:dbing
 */

public interface TUserService {

    public TUser login(TUser user);

    public boolean reg(TUser user);

    public List<TUser> getAllUsers(String condition);

    public void batchDelete(List<Integer> list);

    public void addUser(TUser user);

    public void updateUser(TUser user);

    public TUser getUserByid(Integer id);

}
