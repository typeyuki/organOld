package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.OldmanHealth;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanHealthDao extends BaseDao<OldmanHealth,Integer>{


    List<HealthSelect> getAllHealthSelect();
}
