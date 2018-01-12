package com.dbing.service;

/**
 * author:dbing
 */
public interface TRolePermService {

    public void deleteAll();

    public void addRolePerms(Integer rid, Integer[] perms);

}
