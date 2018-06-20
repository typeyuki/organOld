package com.organOld.dao.repository;

import com.organOld.dao.entity.AutoValue;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/16.
 */
public interface AutoValueDao extends BaseDao<AutoValue,Integer>{
    List<AutoValue> getByTypeList(List<Integer> typeList);

    List<AutoValue> getByType(int type);
}
