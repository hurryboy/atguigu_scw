package com.dbing.service.impl;

import com.dbing.repository.TRolePermissionMapper;
import com.dbing.service.TRolePermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * author:dbing
 */

@Service
public class TRolePermsImpl implements TRolePermService {

    @Autowired
    TRolePermissionMapper rolePermissionMapper;

    @Override
    public void deleteAll() {
        rolePermissionMapper.deleteByExample(null);

    }

    @Override
    public void addRolePerms(Integer rid, Integer[] perms) {
        List<Integer> list = Arrays.asList(perms);
        rolePermissionMapper.addBatch(rid,list);
    }
}
