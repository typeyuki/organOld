package com.organOld.dao.repository;


import com.organOld.dao.entity.home.HomeOldman;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface HomeOldmanDao extends BaseDao<HomeOldman,Integer>{
    void delByOid(int id);
}
