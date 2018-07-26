package com.organOld.dao.repository;

import com.organOld.dao.entity.volunteer.Volunteer;

import java.util.List;

public interface VolunteerDao extends BaseDao<Volunteer,Number> {
    void delByOldmanId(List<Integer> existOldmanIds);

    void delByOrganId(Integer organId);
}
