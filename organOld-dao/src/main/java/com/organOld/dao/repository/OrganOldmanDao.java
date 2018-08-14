package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.util.Page;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OrganOldmanDao extends BaseDao<OrganOldman,Integer>{
    void delByOid(int id);

    void delByOrganId(int organId);

    List<Oldman> getByOrganId(Integer organId);

    int getNumByOldmanId(int oldmanId);

    List<OrganOldman> getManByPage(Page<OrganOldman> page);

    Long getManSizeByPage(Page<OrganOldman> page);


    List<OrganOldman> getDelOldmanIdsByOrganOldmanIds(Integer[] id);
}
