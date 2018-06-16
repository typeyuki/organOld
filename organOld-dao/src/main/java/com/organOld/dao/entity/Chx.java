package com.organOld.dao.entity;

/**
 * 长护险
 * Created by netlab606 on 2018/6/16.
 */
public class Chx extends DBEntity{

    private Integer level;//级别
    private Integer serviceTime;//服务时间

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }
}
