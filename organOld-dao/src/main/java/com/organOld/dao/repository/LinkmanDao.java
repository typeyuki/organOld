package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Linkman;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface LinkmanDao extends BaseDao<Linkman,Integer>{
    void delByOid(int id);
}
