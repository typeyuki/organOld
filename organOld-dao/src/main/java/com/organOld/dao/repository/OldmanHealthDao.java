package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.OldmanHealth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanHealthDao extends BaseDao<OldmanHealth,Integer>{


    List<HealthSelect> getAllHealthSelect();

    Integer getSelectStringLikeIndex(@Param("str") String str, @Param("type") int index);
}
