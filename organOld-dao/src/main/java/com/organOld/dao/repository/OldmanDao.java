package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanIntegral;
import com.organOld.dao.util.Page;
import com.organOld.dao.util.bean.ExportOldman;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanDao extends BaseDao<Oldman,Integer>{
    void updateKeyOldman(List<Oldman> oldmanList);

    long getMaxId();

    void updateKeyOldmanFuture(List<Oldman> updatedData);

    Integer getIdByPid(String pid);

    int setDisabled(@Param("list") List<Integer> existOldmanIds,@Param("xqIds") List<Integer> xqIds);

    Oldman getIntegralByOldmanId(int oldmanId);

    void updateOrganExceLImportByIds(List<Oldman> oldmanList);

    List<Oldman> getIntegralByPage(Page<OldmanIntegral> page);

    Long getIntegralSizeByPage(Page<OldmanIntegral> page);

    void addInregral(@Param("oldmanId") int oldmanId,@Param("integral") int integral);


    List<Oldman> getByJwId(Integer jwId);

    List<ExportOldman> getAll(Oldman oldman);

    List<Oldman> getOrganOldmans(@Param("xqIds") List<Integer> xqIds);

    void delVolunteerByXqIds(@Param("existOldmanIds") List<Integer> existOldmanIds,@Param("xqIds") List<Integer> xqIds);

    Oldman getOldStatusNum();

    @MapKey("pid")
    Map<String,Oldman> getAllOldman();

    List<Oldman> getBySearch(String search);
}
