package com.dbing.service;

import com.dbing.bean.TRole;

import java.util.List;

/**
 * author:dbing
 */
public interface RoleService {

    public List<TRole> getAllRoles(String condition);

    public void addRole(TRole tRole);

    public List<TRole> getUserRoles(Integer id);

    public List<TRole> getUsersUnRoles(Integer id);

    public void assingnRolesToUser(Integer id, List<Integer> list);

    //删除用户的角色【表-user_role】
    public void removeUserRoles(Integer id, List<Integer> list);

    public void deleteRoles(List<Integer> rids);

    public TRole getRoleById(Integer rid);

    public void editRole(TRole role);


}
