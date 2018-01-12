package com.dbing.api.service;

import com.dbing.bean.TMember;

/**
 * author:dbing
 */
public interface SystemService {

    public String send(String type,String emailaddr) throws Exception;

    public boolean reset(TMember member);

    public String send(String email) throws Exception ;


}
