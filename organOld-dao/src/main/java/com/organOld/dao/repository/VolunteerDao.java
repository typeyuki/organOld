package com.organOld.dao.repository;

import com.organOld.dao.entity.volunteer.Volunteer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VolunteerDao extends BaseDao<Volunteer,Number> {
    void delByOldmanId(List<Integer> existOldmanIds);

    void delByOrganId(@Param(value="organId")Integer organId);
}
