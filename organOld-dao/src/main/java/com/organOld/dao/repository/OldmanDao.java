package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Oldman;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanDao extends BaseDao<Oldman,Integer>{
    void updateKeyOldman(List<Oldman> oldmanList);

    long getMaxId();

    void updateKeyOldmanFuture(List<Oldman> updatedData);

    Integer getIdByPid(String pid);

    int setDisabled(@Param("list") List<Integer> existOldmanIds,@Param("organId") Integer organId);

    Oldman getIntegralByOldmanId(int oldmanId);
}
