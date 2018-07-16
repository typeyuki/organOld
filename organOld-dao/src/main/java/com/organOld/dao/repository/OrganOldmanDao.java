package com.organOld.dao.repository;


import com.organOld.dao.entity.organ.OrganOldman;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OrganOldmanDao extends BaseDao<OrganOldman,Integer>{
    void delByOid(int id);

    void delByOrganId(int organId);
}
