package com.organOld.dao.repository;


import com.organOld.dao.entity.Chx;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/16.
 */
public interface ChxDao extends BaseDao<Chx,Integer>{
    List<Chx> getSimple();
}
