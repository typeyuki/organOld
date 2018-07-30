package com.organOld.dao.entity.home;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import sun.dc.pr.PRError;

import java.util.Date;

public class HomeOldman extends DBEntity implements DBInterface{
    private int homeId;
    private Oldman oldman;
    private Date timeIn;
    private Date timeOut;
    private Integer isService;
    private Organ organ;
    private Integer oldmanId;
    private String[] type;
    private Home home;

    private Integer organId;//居委ID
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public Integer getIsService() {
        return isService;
    }

    public void setIsService(Integer isService) {
        this.isService = isService;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
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
