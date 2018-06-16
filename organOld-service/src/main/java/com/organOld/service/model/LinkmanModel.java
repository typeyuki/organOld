package com.organOld.service.model;


public class LinkmanModel extends ManModel{
    private String relation;
    private String oldman;

    public String getOldman() {
        return oldman;
    }

    public void setOldman(String oldman) {
        this.oldman = oldman;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
