package com.organOld.service.model;

import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;

import java.util.List;

/**
 * 老人全部信息查看
 * Created by netlab606 on 2018/6/29.
 */
public class OldmanAllInfoModel {
    private OldmanModel oldman;
    private OldmanHealthModel health;
    private String family;
    private String economic;
    private LinkmanModel linkman;
    private OrganOldman organ;//机构养老
    private List<OrganOldman> community;//社区养老
    private List<HomeOldman> home;//居家养老
    private List<Label> labels;//所属标签
    private Oldman key;//重点老人参数

    public Oldman getKey() {
        return key;
    }

    public void setKey(Oldman key) {
        this.key = key;
    }

    public OldmanModel getOldman() {
        return oldman;
    }

    public void setOldman(OldmanModel oldman) {
        this.oldman = oldman;
    }

    public OldmanHealthModel getHealth() {
        return health;
    }

    public void setHealth(OldmanHealthModel health) {
        this.health = health;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getEconomic() {
        return economic;
    }

    public void setEconomic(String economic) {
        this.economic = economic;
    }

    public LinkmanModel getLinkman() {
        return linkman;
    }

    public void setLinkman(LinkmanModel linkman) {
        this.linkman = linkman;
    }

    public OrganOldman getOrgan() {
        return organ;
    }

    public void setOrgan(OrganOldman organ) {
        this.organ = organ;
    }

    public List<OrganOldman> getCommunity() {
        return community;
    }

    public void setCommunity(List<OrganOldman> community) {
        this.community = community;
    }

    public List<HomeOldman> getHome() {
        return home;
    }

    public void setHome(List<HomeOldman> home) {
        this.home = home;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
