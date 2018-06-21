package com.organOld.dao.entity.oldman;

import java.util.Date;
import java.util.List;

/**
 * 提取 重点老人  模型 需要计算的数据
 * Created by netlab606 on 2018/6/21.
 */
public class OldmanKey {
    private Integer oldmanId;
    private Date birthday;
    private Integer familyIndex;
    private Integer chxLevel;
    private List<HealthSelect> healthSelectList;
    private Integer intelligence;
    private Integer eyesight;
    private Integer economicIndex;
    private Integer floor;


    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getFamilyIndex() {
        return familyIndex;
    }

    public void setFamilyIndex(Integer familyIndex) {
        this.familyIndex = familyIndex;
    }

    public Integer getChxLevel() {
        return chxLevel;
    }

    public void setChxLevel(Integer chxLevel) {
        this.chxLevel = chxLevel;
    }

    public List<HealthSelect> getHealthSelectList() {
        return healthSelectList;
    }

    public void setHealthSelectList(List<HealthSelect> healthSelectList) {
        this.healthSelectList = healthSelectList;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getEyesight() {
        return eyesight;
    }

    public void setEyesight(Integer eyesight) {
        this.eyesight = eyesight;
    }

    public Integer getEconomicIndex() {
        return economicIndex;
    }

    public void setEconomicIndex(Integer economicIndex) {
        this.economicIndex = economicIndex;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
