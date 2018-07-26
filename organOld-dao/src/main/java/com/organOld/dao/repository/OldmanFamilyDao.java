package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.OldmanFamily;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanFamilyDao extends BaseDao<OldmanFamily,Integer>{
    void delByOid(int id);

    void updateByOldmanIds(List<OldmanFamily> familyList_update);

    OldmanFamily getByOldmanId(int oldmanId);
}
