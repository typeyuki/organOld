package com.organOld.dao.entity.oldman;

import java.util.ArrayList;
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
    private Integer chxIndex;
    private List<HealthSelect> healthSelectIdsList;

    private Integer intelligence;
    private Integer eyesight;
    private Integer economicIndex;
    private Integer floor;
    private Integer isActivityOrgan;//是否主动申请进养老院  即机构人员表有  但是床位号为0



    private List<Integer> mbIds=new ArrayList<>();
    private List<Integer> snIds=new ArrayList<>();

    private Integer keyStatus;

    public Integer getKeyStatus() {
        return keyStatus;
    }

    public void setKeyStatus(Integer keyStatus) {
        this.keyStatus = keyStatus;
    }

    public Integer getIsActivityOrgan() {
        return isActivityOrgan;
    }

    public void setIsActivityOrgan(Integer isActivityOrgan) {
        this.isActivityOrgan = isActivityOrgan;
    }

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

    public Integer getChxIndex() {
        return chxIndex;
    }

    public void setChxIndex(Integer chxIndex) {
        this.chxIndex = chxIndex;
    }

    public List<Integer> getMbIds() {
        return mbIds;
    }

    public void setMbIds(List<Integer> mbIds) {
        this.mbIds = mbIds;
    }

    public List<Integer> getSnIds() {
        return snIds;
    }

    public void setSnIds(List<Integer> snIds) {
        this.snIds = snIds;
    }

    public List<HealthSelect> getHealthSelectIdsList() {
        return healthSelectIdsList;
    }

    public void setHealthSelectIdsList(List<HealthSelect> healthSelectIdsList) {
        this.healthSelectIdsList = healthSelectIdsList;
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
