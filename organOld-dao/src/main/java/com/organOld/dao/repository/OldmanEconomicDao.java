package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.OldmanEconomic;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanEconomicDao extends BaseDao<OldmanEconomic,Integer>{
    void delByOid(int id);

    void updateByOldmanIds(List<OldmanEconomic> economicList_update);
}
