package com.dbing.service.impl;

import com.dbing.bean.TRole;
import com.dbing.bean.TRoleExample;
import com.dbing.bean.TUserRoleExample;
import com.dbing.repository.TRoleMapper;
import com.dbing.repository.TUserRoleMapper;
import com.dbing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:dbing
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    TRoleMapper roleMapper;
    @Autowired
    TUserRoleMapper tUserRoleMapper;

    @Override
    public List<TRole> getAllRoles(String condition) {
        TRoleExample example  = new TRoleExample();
        example.createCriteria().andNameLike(condition);
        return roleMapper.selectByExample(example);
    }


    @Override
    public void addRole(TRole tRole) {
        roleMapper.insertSelective(tRole);
    }

    @Override
    public List<TRole> getUserRoles(Integer id) {
        return roleMapper.getUserRoles(id);
    }

    @Override
    public List<TRole> getUsersUnRoles(Integer id) {
        return roleMapper.getUserUnRoles(id);
    }

    @Override
    public void assingnRolesToUser(Integer id, List<Integer> list) {
        tUserRoleMapper.assingnRolesToUser(id, list);
    }

    @Override
    public void removeUserRoles(Integer id, List<Integer> list) {
        TUserRoleExample example = new TUserRoleExample();
        example.createCriteria().andUseridEqualTo(id).andRoleidIn(list);
        tUserRoleMapper.deleteByExample(example);
    }

    @Override
    public void deleteRoles(List<Integer> rids) {
        TRoleExample example = new TRoleExample();
        example.createCriteria().andIdIn(rids);
        roleMapper.deleteByExample(example);
    }

    @Override
    public TRole getRoleById(Integer rid) {
        return roleMapper.selectByPrimaryKey(rid);
    }

    @Override
    public void editRole(TRole role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

}
