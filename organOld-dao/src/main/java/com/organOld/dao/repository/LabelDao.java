package com.organOld.dao.repository;


import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.label.LabelRule;
import com.organOld.dao.entity.label.LabelRuleToDB;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by netlab606 on 2018/6/7.
 */
public interface LabelDao extends BaseDao<Label,Integer> {
    List<Oldman> getBindManByPage(@Param("page") Page<Oldman> page, @Param("labelId") int labelId);

    Long getBindManSizeByPage(@Param("page") Page<Oldman> page, @Param("labelId") int labelId);

    List<Oldman>getNoSelectManDataByPage(@Param("page") Page<Oldman> page, @Param("labelId") int labelId);

    Long getNoSelectManDataSizeByPage(@Param("page") Page<Oldman> page, @Param("labelId") int labelId);

    LabelRule getLabelRuleByLid(int labelId);

    List<Oldman> getRuleManByPage(@Param("page") Page<Oldman> page, @Param("rule") LabelRuleToDB labelRuleToDB);

    Long getRuleManSizeByPage(@Param("page") Page<Oldman> page, @Param("rule") LabelRuleToDB labelRuleToDB);
}
