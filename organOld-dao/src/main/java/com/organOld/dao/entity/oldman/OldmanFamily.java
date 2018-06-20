package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;

/**
 * 家庭结构
 * Created by netlab606 on 2018/4/2.
 */
public class OldmanFamily extends DBEntity implements DBInterface {
    private String family;
    private Oldman oldman;

    private Integer jwId;

    public Integer getJwId() {
        return jwId;
    }

    @Override
    public void setJwId(Integer jwId) {
        this.jwId = jwId;
    }

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
