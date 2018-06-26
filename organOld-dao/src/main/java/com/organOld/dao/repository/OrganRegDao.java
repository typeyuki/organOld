package com.organOld.dao.repository;

import com.organOld.dao.entity.organ.OrganReg;

public interface OrganRegDao {
    OrganReg getByOrganId(int organId);
}
