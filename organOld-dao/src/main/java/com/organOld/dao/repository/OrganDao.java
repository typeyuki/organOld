package com.organOld.dao.repository;

import com.organOld.dao.entity.organ.Organ;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/16.
 */
public interface OrganDao extends BaseDao<Organ,Integer>{
    List<Organ> getSimpleByType(Integer type);
}
