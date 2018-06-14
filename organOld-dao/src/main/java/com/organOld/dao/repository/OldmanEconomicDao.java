package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Economic;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanEconomicDao extends BaseDao<Economic,Integer>{
    void delByOid(int id);
}
