package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.OldmanFamily;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanFamilyDao extends BaseDao<OldmanFamily,Integer>{
    void delByOid(int id);
}
