package com.organOld.service.model;


import com.organOld.dao.entity.DBEntity;

import java.util.List;

//规则绑定标签
public class LabelRuleModel{
    private int ageStart;
    private int ageEnd;
    private List<String> districtIds;
    private List<String> jwIds;//居委
    private int sex;
    private List<String> censuses;
    private List<String> politicalStatuses;
    private int isKey;
    private List<String> economics;
    private List<String> families;
    private List<String> intelligences;
    private List<String> eyesights;
    private List<String> isHealths;
    private List<String> chxs;
    private List<String> oldStatuses;


    public List<String> getJwIds() {
        return jwIds;
    }

    public void setJwIds(List<String> jwIds) {
        this.jwIds = jwIds;
    }

    public List<String> getChxs() {
        return chxs;
    }

    public void setChxs(List<String> chxs) {
        this.chxs = chxs;
    }

    public List<String> getOldStatuses() {
        return oldStatuses;
    }

    public void setOldStatuses(List<String> oldStatuses) {
        this.oldStatuses = oldStatuses;
    }

    public int getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(int ageStart) {
        this.ageStart = ageStart;
    }

    public int getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(int ageEnd) {
        this.ageEnd = ageEnd;
    }

    public List<String> getDistrictIds() {
        return districtIds;
    }

    public void setDistrictIds(List<String> districtIds) {
        this.districtIds = districtIds;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public List<String> getCensuses() {
        return censuses;
    }

    public void setCensuses(List<String> censuses) {
        this.censuses = censuses;
    }

    public List<String> getPoliticalStatuses() {
        return politicalStatuses;
    }

    public void setPoliticalStatuses(List<String> politicalStatuses) {
        this.politicalStatuses = politicalStatuses;
    }

    public int getIsKey() {
        return isKey;
    }

    public void setIsKey(int isKey) {
        this.isKey = isKey;
    }

    public List<String> getEconomics() {
        return economics;
    }

    public void setEconomics(List<String> economics) {
        this.economics = economics;
    }

    public List<String> getFamilies() {
        return families;
    }

    public void setFamilies(List<String> families) {
        this.families = families;
    }

    public List<String> getIntelligences() {
        return intelligences;
    }

    public void setIntelligences(List<String> intelligences) {
        this.intelligences = intelligences;
    }

    public List<String> getEyesights() {
        return eyesights;
    }

    public void setEyesights(List<String> eyesights) {
        this.eyesights = eyesights;
    }

    public List<String> getIsHealths() {
        return isHealths;
    }

    public void setIsHealths(List<String> isHealths) {
        this.isHealths = isHealths;
    }
}
