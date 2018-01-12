package com.dbing.repository;

import com.dbing.bean.TProjectResources;
import com.dbing.bean.TProjectResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProjectResourcesMapper {
    long countByExample(TProjectResourcesExample example);

    int deleteByExample(TProjectResourcesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TProjectResources record);

    int insertSelective(TProjectResources record);

    List<TProjectResources> selectByExampleWithBLOBs(TProjectResourcesExample example);

    List<TProjectResources> selectByExample(TProjectResourcesExample example);

    TProjectResources selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProjectResources record, @Param("example") TProjectResourcesExample example);

    int updateByExampleWithBLOBs(@Param("record") TProjectResources record, @Param("example") TProjectResourcesExample example);

    int updateByExample(@Param("record") TProjectResources record, @Param("example") TProjectResourcesExample example);

    int updateByPrimaryKeySelective(TProjectResources record);

    int updateByPrimaryKeyWithBLOBs(TProjectResources record);

    int updateByPrimaryKey(TProjectResources record);
}