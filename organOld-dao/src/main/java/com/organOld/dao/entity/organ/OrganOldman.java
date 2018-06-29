package com.organOld.dao.entity.organ;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.oldman.Oldman;

import java.util.Date;

/**
 * 养老机构 中的老人
 * Created by netlab606 on 2018/4/2.
 */
public class OrganOldman extends DBEntity implements DBInterface {
    private Oldman oldman;
    private Organ organ;

    private Date timeIn;
    private Date timeOut;
    private int num;


    private Integer jwId;//居委ID


    /**
     * 搜素
     * @return
     */
    private Integer firType;


    public Integer getJwId() {
        return jwId;
    }

    @Override
    public void setJwId(Integer jwId) {
        this.jwId = jwId;
    }

    public Integer getFirType() {
        return firType;
    }

    public void setFirType(Integer firType) {
        this.firType = firType;
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

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }



}
