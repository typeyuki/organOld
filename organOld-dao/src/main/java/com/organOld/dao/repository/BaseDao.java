package com.organOld.dao.repository;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.util.Page;

import java.util.List;

public interface BaseDao<T extends DBEntity,ID extends Number> {
    T saveAndReturn(T entity);
    void save(T entity);
    void saveAll(List<T> list);
    void delById(ID id);
    List<T> getByPage(Page page);
    Long getSizeByPage(Page page);
    void updateById(T entity);
}
