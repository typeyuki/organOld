package com.organOld.dao.entity;

/**
 * Created by netlab606 on 2018/6/16.
 */
public class AutoValue extends DBEntity {
    private String value;
    private int type;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
