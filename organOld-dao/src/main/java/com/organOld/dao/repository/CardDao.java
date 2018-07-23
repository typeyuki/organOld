package com.organOld.dao.repository;

import com.organOld.dao.entity.Card;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/25.
 */
public interface CardDao extends BaseDao<Card,Number>{
    void delByOldmanIds(List<Integer> existOldmanIds);
}
