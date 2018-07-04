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
    private Integer oldmanId;
    private Integer organId;//居委ID


    @Override
    public String toString() {
        return "Linkman{" +
                "oldman=" + oldman +
                ", relation='" + relation + '\'' +
                ", oldmanId=" + oldmanId +
                ", organId=" + organId +
                '}';
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
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
