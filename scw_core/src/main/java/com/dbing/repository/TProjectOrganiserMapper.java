package com.dbing.repository;

import com.dbing.bean.TProjectOrganiser;
import com.dbing.bean.TProjectOrganiserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProjectOrganiserMapper {
    long countByExample(TProjectOrganiserExample example);

    int deleteByExample(TProjectOrganiserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProjectOrganiser record);

    int insertSelective(TProjectOrganiser record);

    List<TProjectOrganiser> selectByExample(TProjectOrganiserExample example);

    TProjectOrganiser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProjectOrganiser record, @Param("example") TProjectOrganiserExample example);

    int updateByExample(@Param("record") TProjectOrganiser record, @Param("example") TProjectOrganiserExample example);

    int updateByPrimaryKeySelective(TProjectOrganiser record);

    int updateByPrimaryKey(TProjectOrganiser record);
}