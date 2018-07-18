package com.organOld.dao.repository;

import com.organOld.dao.entity.organ.Organ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/16.
 */
public interface OrganDao extends BaseDao<Organ,Integer>{
    List<Organ> getSimpleByType(@Param("type") Integer type,@Param("organId") Integer organId);

    Organ getByUsername(String username);

    Organ getAuthById(int organId);

    List<Organ> getRoleOrgan(@Param("type") int type, @Param("typeIndex") int typeIndex);

    List<Organ> getByType(int type);

    List<Organ> getByTypes(List<Integer> typeIds);

    List<Organ> getByIds(List<String> ids);

    List<Organ> getByFirType(int firType);
}
