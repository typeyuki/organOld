package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Family;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanFamilyDao extends BaseDao<Family,Integer>{
    void delByOid(int id);
}
