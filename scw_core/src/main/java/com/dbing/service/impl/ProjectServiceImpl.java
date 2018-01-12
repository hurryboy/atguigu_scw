package com.dbing.service.impl;

import com.dbing.bean.*;
import com.dbing.repository.*;
import com.dbing.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author:dbing
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    TTypeMapper tTypeMapper;

    @Autowired
    TTagMapper tTagMapper;

    @Autowired
    TProjectTagMapper tProjectTagMapper;

    @Autowired
    TProjectTypeMapper tProjectTypeMapper;

    @Autowired
    TProjectMapper tProjectMapper;

    @Autowired
    TProjectOrganiserMapper tProjectOrganiserMapper;

    @Autowired
    TReturnMapper tReturnMapper;

    @Autowired
    TProjectResourcesMapper tProjectResourcesMapper;


    @Override
    public boolean saveImgs(String headerImg, String infoimg, Integer pid) {
        TProjectResourcesExample example = new TProjectResourcesExample();
        example.createCriteria().andPidEqualTo(pid);

        tProjectResourcesMapper.deleteByExample(example);

        TProjectResources tProjectResources = new TProjectResources();
        tProjectResources.setHeaderImg(headerImg);
        tProjectResources.setInfoImg(infoimg);
        tProjectResources.setPid(pid);
        int row = tProjectResourcesMapper.insertSelective(tProjectResources);

        return row==1;
    }

    @Override
    public boolean confirmCard(TProjectOrganiser organiser) {
        TProjectOrganiserExample example = new TProjectOrganiserExample();
        example.createCriteria().andIdEqualTo(organiser.getId());

        int row = tProjectOrganiserMapper.updateByExampleSelective(organiser,example);

        return row==1;
    }

    @Override
    public boolean saveTReturn(TReturn tReturn) {
        int row = tReturnMapper.insert(tReturn);
        return row==1;
    }

    @Override
    public boolean saveProBaseInfo(TProject tProject) {


        int f = tProjectMapper.updateByPrimaryKeySelective(tProject);

        return f==1;
    }

    @Override
    public boolean saveOrganiser(TProjectOrganiser tProjectOrganiser) {

        TProjectOrganiserExample example = new TProjectOrganiserExample();
        example.createCriteria().andIdEqualTo(tProjectOrganiser.getId());
        tProjectOrganiserMapper.deleteByExample(example);

        int row = tProjectOrganiserMapper.insertSelective(tProjectOrganiser);
        return row==1;
    }

    @Override
    public Integer createStartPro(Integer memberId) {

        System.out.println(memberId);

        TProject tProject = new TProject();
        tProject.setMemberid(memberId);
        System.out.println(tProject);
        tProjectMapper.insertSelective(tProject);

        return tProject.getId();
    }



    @Override
    public List<TType> getTypes() {
        return tTypeMapper.selectByExample(null);
    }

    @Override
    public List<TTag> getTags() {
        List<TTag> list = tTagMapper.selectByExample(null);
        return list;
    }

    @Override
    public boolean saveProTypes(Integer pid, Integer typeid) {
        //同理，先删除
        TProjectTypeExample example = new TProjectTypeExample();
        example.createCriteria().andProjectidEqualTo(pid);
        tProjectTypeMapper.deleteByExample(example);

        //再添加
        TProjectType tProjectType = new TProjectType();
        tProjectType.setProjectid(pid);
        tProjectType.setTypeid(typeid);

        int row = tProjectTypeMapper.insertSelective(tProjectType);
        return row==1;
    }

    @Override
    public List<TReturn> getTReturnsByPid(Integer pid) {

        TReturnExample example = new TReturnExample();
        example.createCriteria().andProjectidEqualTo(pid);

        return tReturnMapper.selectByExample(example);
    }

    @Override
    public boolean saveProTags(Integer pid, String tags) {
        //保存项目标签之前先删除当前项目的标签
        //防止重复提交
        TProjectTagExample example = new TProjectTagExample();
        example.createCriteria().andProjectidEqualTo(pid);
        tProjectTagMapper.deleteByExample(example);

        List<Integer> list = new ArrayList<>();
        String[] tagsarr = tags.split(",");

        for(String tag:tagsarr){
            try {
                Integer i = Integer.parseInt(tag);
                list.add(i);
            } catch (NumberFormatException e) {
            }
        }

        return tProjectTagMapper.saveTags(pid,list)>0?true:false;
    }

    @Override
    public boolean eidtReturn(TReturn tReturn) {
        int row = tReturnMapper.updateByPrimaryKeySelective(tReturn);
        return row==1;
    }

    @Override
    public boolean deleteReturnById(Integer rid) {
        int row = tReturnMapper.deleteByPrimaryKey(rid);
        return row==1;
    }

}
