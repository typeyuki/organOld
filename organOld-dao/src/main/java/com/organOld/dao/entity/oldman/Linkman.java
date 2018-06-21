package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBInterface;

import java.util.Date;

/**
 * 应急联系人
 * Created by netlab606 on 2018/4/2.
 */
public class Linkman extends Man implements DBInterface{
    private Oldman oldman;
    private String relation;

    private Integer jwId;//居委ID


    public Integer getJwId() {
        return jwId;
    }

    @Override
    public void setJwId(Integer jwId) {
        this.jwId = jwId;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }


}
