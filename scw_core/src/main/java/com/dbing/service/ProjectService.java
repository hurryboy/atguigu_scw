package com.dbing.service;

import com.dbing.bean.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:dbing
 */
@Service
public interface ProjectService {

    public boolean deleteReturnById(Integer rid);

    public boolean eidtReturn(TReturn tReturn);

    public List<TReturn> getTReturnsByPid(Integer pid);

    public boolean saveProTags(Integer pid,String tags);

    public List<TTag> getTags();

    public List<TType> getTypes();

    public boolean saveProTypes(Integer pid, Integer typeid);

    public Integer createStartPro(Integer memberId);

    public boolean saveProBaseInfo(TProject tProject);

    public boolean saveOrganiser(TProjectOrganiser tProjectOrganiser);

    public boolean saveTReturn(TReturn tReturn);

    public boolean confirmCard(TProjectOrganiser organiser);

    public boolean saveImgs(String headerImg,String infoimg,Integer pid);

}
