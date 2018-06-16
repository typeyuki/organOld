package com.organOld.service.model;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Chx;
import com.organOld.dao.entity.organ.Organ;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 规则标签  所有可选规则
 * Created by netlab606 on 2018/6/16.
 */
public class LabelRuleModel {
    private Map<Integer,String> sex;
    private List<AutoValue> district=new ArrayList<>();
    private List<Organ> organ;//居委
    private List<AutoValue> census=new ArrayList<>();
    private List<AutoValue> politicalStatuses=new ArrayList<>();
    private Map<Integer,String> isKey;
    private List<AutoValue> economic=new ArrayList<>();
    private List<AutoValue> family=new ArrayList<>();
    private List<AutoValue> intelligence=new ArrayList<>();
    private List<AutoValue> eyesight=new ArrayList<>();
    private Map<Integer,String> isHealth;
    private List<Chx> chx;
    private Map<Integer,String> oldStatus;

    public Map<Integer, String> getSex() {
        return sex;
    }

    public void setSex(Map<Integer, String> sex) {
        this.sex = sex;
    }

    public List<AutoValue> getDistrict() {
        return district;
    }

    public void setDistrict(List<AutoValue> district) {
        this.district = district;
    }

    public List<Organ> getOrgan() {
        return organ;
    }

    public void setOrgan(List<Organ> organ) {
        this.organ = organ;
    }

    public List<AutoValue> getCensus() {
        return census;
    }

    public void setCensus(List<AutoValue> census) {
        this.census = census;
    }

    public List<AutoValue> getPoliticalStatuses() {
        return politicalStatuses;
    }

    public void setPoliticalStatuses(List<AutoValue> politicalStatuses) {
        this.politicalStatuses = politicalStatuses;
    }

    public Map<Integer, String> getIsKey() {
        return isKey;
    }

    public void setIsKey(Map<Integer, String> isKey) {
        this.isKey = isKey;
    }

    public List<AutoValue> getEconomic() {
        return economic;
    }

    public void setEconomic(List<AutoValue> economic) {
        this.economic = economic;
    }

    public List<AutoValue> getFamily() {
        return family;
    }

    public void setFamily(List<AutoValue> family) {
        this.family = family;
    }

    public List<AutoValue> getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(List<AutoValue> intelligence) {
        this.intelligence = intelligence;
    }

    public List<AutoValue> getEyesight() {
        return eyesight;
    }

    public void setEyesight(List<AutoValue> eyesight) {
        this.eyesight = eyesight;
    }

    public Map<Integer, String> getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(Map<Integer, String> isHealth) {
        this.isHealth = isHealth;
    }

    public List<Chx> getChx() {
        return chx;
    }

    public void setChx(List<Chx> chx) {
        this.chx = chx;
    }

    public Map<Integer, String> getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Map<Integer, String> oldStatus) {
        this.oldStatus = oldStatus;
    }
}
