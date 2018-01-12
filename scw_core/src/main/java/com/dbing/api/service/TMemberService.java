package com.dbing.api.service;

import com.dbing.bean.TMember;

/**
 * author:dbing
 */
public interface TMemberService {

    public boolean regist(TMember member);

    public TMember login(TMember member);

}
