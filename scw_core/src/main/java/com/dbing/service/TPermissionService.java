package com.dbing.service;

import com.dbing.bean.TPermission;
import com.dbing.bean.TUser;

import java.util.List;

/**
 * author:dbing
 */
public interface TPermissionService {

    public List<TPermission> getMenus(TUser user);

    public List<TPermission> getAllPermissions();

    public List<TPermission> getRolesPermissions(Integer rid);

}
