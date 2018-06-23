package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Oldman;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanDao extends BaseDao<Oldman,Integer>{
    void updateKeyOldman(List<Oldman> oldmanList);

    long getMaxId();
}
