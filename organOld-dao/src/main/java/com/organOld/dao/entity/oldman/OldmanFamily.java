package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBEntity;

/**
 * 家庭结构
 * Created by netlab606 on 2018/4/2.
 */
public class OldmanFamily extends DBEntity {
    private String family;
    private Oldman oldman;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }
}
