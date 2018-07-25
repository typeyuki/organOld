package com.organOld.dao.repository;

import com.organOld.dao.entity.home.Home;
import org.apache.ibatis.annotations.Param;

public interface HomeDao extends BaseDao<Home,Number>{
    int getIdBySecType(@Param("name") String name,@Param("firType") int index);

    Object getByIdAndFirType(@Param("id") int id,@Param("firType") int firType);
}
