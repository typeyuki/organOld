package com.organOld.dao.entity.home;

import com.organOld.dao.entity.DBEntity;

//家庭医生
public class Doctor extends DBEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
