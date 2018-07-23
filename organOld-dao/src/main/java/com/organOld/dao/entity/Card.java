package com.organOld.dao.entity;

import com.organOld.dao.entity.oldman.Oldman;

/**
 * 一卡通
 * Created by netlab606 on 2018/7/16.
 */
public class Card extends DBEntity{
    private int oldmanId;
    private String cid;//身份证后六位
    private String password;
    private Double money;
    private Integer status;
    private Oldman oldman;


    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
