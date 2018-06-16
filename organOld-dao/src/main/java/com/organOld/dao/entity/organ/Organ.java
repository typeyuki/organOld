package com.organOld.dao.entity.organ;

import com.organOld.dao.entity.DBEntity;

/**
 * Created by netlab606 on 2018/6/16.
 */
public class Organ extends DBEntity {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
