package com.organOld.dao.repository;

import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/16.
 */
public interface OrganDao extends BaseDao<Organ,Integer>{
    List<Organ> getSimpleByType(Integer type);

    Organ getByUsername(String username);

    Organ getAuthById(int organId);

    List<Organ> getRoleOrgan(@Param("type") int type, @Param("typeIndex") int typeIndex);
}
