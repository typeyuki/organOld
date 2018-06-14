package com.organOld.service.contract;


import com.organOld.dao.entity.oldman.Linkman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanHealth;

/**
 * 老人 添加 请求
 */
public class OldmanAddRequest {
    private Oldman oldman;
    private Linkman linkman;
    private OldmanHealth oldmanHealth;


    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public Linkman getLinkman() {
        return linkman;
    }

    public void setLinkman(Linkman linkman) {
        this.linkman = linkman;
    }

    public OldmanHealth getOldmanHealth() {
        return oldmanHealth;
    }

    public void setOldmanHealth(OldmanHealth oldmanHealth) {
        this.oldmanHealth = oldmanHealth;
    }
}
