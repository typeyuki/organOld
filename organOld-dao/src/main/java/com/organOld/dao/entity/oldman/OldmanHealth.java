package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBEntity;

import java.util.List;

/**
 * 老人健康档案
 */
public class OldmanHealth extends DBEntity {

    private String bloodType;
    private String intelligence;//失智
    private String eyesight;//视力
    private List<HealthAdd> healthAdd;
    private List<HealthSelect> healthSelect;
    //TODO 选取所有表格中最新的一个时间  暂时还没实现
    private Oldman oldman;

    private String search;//模糊搜索


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getEyesight() {
        return eyesight;
    }

    public void setEyesight(String eyesight) {
        this.eyesight = eyesight;
    }

    public List<HealthAdd> getHealthAdd() {
        return healthAdd;
    }

    public void setHealthAdd(List<HealthAdd> healthAdd) {
        this.healthAdd = healthAdd;
    }

    public List<HealthSelect> getHealthSelect() {
        return healthSelect;
    }

    public void setHealthSelect(List<HealthSelect> healthSelect) {
        this.healthSelect = healthSelect;
    }
}
