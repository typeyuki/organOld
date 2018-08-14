package com.organOld.dao.repository;


import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.Oldman;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface HomeOldmanDao extends BaseDao<HomeOldman,Integer>{
    void delByOid(int id);

    void delByJwId(Integer jwId);

    void delAll();
}
