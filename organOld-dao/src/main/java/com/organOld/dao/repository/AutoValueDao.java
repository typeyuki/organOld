package com.organOld.dao.repository;

import com.organOld.dao.entity.AutoValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/16.
 */
public interface AutoValueDao extends BaseDao<AutoValue,Integer>{
    List<AutoValue> getByTypeList(List<Integer> typeList);

    List<AutoValue> getByType(int type);

    //type mysql  equals 表示用=  like 表示用like
    Integer getStringLikeIndex(@Param("str") String str, @Param("index") int index,@Param("type") String type);

    List<AutoValue> getByIds(String[] sq);
}
