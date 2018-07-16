package com.organOld.dao.entity;

/**
 * 一卡通
 * Created by netlab606 on 2018/7/16.
 */
public class Card extends DBEntity{
    private int oldmanId;
    private String cid;
    private String password;

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
