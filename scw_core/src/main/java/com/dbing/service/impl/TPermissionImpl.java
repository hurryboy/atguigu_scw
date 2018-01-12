package com.dbing.service.impl;

import com.dbing.bean.TPermission;
import com.dbing.bean.TUser;
import com.dbing.repository.TPermissionMapper;
import com.dbing.service.TPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:dbing
 */

@Service
public class TPermissionImpl implements TPermissionService {

    @Autowired
    TPermissionMapper tPermissionMapper;

    @Override
    public List<TPermission> getMenus(TUser user) {
        return tPermissionMapper.getMenus(user.getId());
    }

    @Override
    public List<TPermission> getAllPermissions() {
        List<TPermission> list = tPermissionMapper.selectByExample(null);
        return list;
    }

    @Override
    public List<TPermission> getRolesPermissions(Integer rid) {
        List<TPermission> list = tPermissionMapper.getRolesPermissions(rid);
        return list;
    }
}
