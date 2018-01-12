package com.dbing.service.impl;

import com.dbing.bean.TProjectResources;
import com.dbing.repository.TProjectResourcesMapper;
import com.dbing.service.TProjectResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:dbing
 */
@Service
public class TProjectResourcesServiceImpl implements TProjectResourcesService {

    @Autowired
    TProjectResourcesMapper mapper;

    @Override
    public boolean saveImg(TProjectResources resources) {
        int row = mapper.insertSelective(resources);
        return row==1;
    }
}
