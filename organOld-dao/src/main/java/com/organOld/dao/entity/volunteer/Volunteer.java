package com.organOld.dao.entity.volunteer;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;

public class Volunteer extends DBEntity implements DBInterface {
    private Integer oldmanId;


    private Integer organId;

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }
}
