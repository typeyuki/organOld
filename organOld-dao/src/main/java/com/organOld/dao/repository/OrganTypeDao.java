package com.organOld.dao.repository;

import com.organOld.dao.entity.organ.OrganType;

import java.util.List;

public interface OrganTypeDao extends BaseDao<OrganType,Number> {

    List<OrganType> getByFirType(int firType);

    List<OrganType> getAllOldmanType();
}
