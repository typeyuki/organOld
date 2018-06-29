package com.organOld.dao.entity.home;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.oldman.Oldman;
import sun.dc.pr.PRError;

import java.util.Date;

public class HomeOldman extends DBEntity implements DBInterface{
    private int homeId;
    private Oldman oldman;
    private Date timeIn;
    private Date timeOut;

    private Home home;

    private Integer jwId;//居委ID


    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Integer getJwId() {
        return jwId;
    }

    @Override
    public void setJwId(Integer jwId) {
        this.jwId = jwId;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }
}
