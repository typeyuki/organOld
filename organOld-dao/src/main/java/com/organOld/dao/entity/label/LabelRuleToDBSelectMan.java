package com.organOld.dao.entity.label;

import java.util.Date;
import java.util.List;

//用于数据库 人员 筛选
public class LabelRuleToDBSelectMan {
    private Date birStart;
    private Date birEnd;
    private List<String> districtIds;
    private List<String> jwIds;
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
    private List<String> zcs;
    private List<String> sqzws;

    public List<String> getZcs() {
        return zcs;
    }

    public void setZcs(List<String> zcs) {
        this.zcs = zcs;
    }

    public List<String> getSqzws() {
        return sqzws;
    }

    public void setSqzws(List<String> sqzws) {
        this.sqzws = sqzws;
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

    public List<String> getJwIds() {
        return jwIds;
    }

    public void setJwIds(List<String> jwIds) {
        this.jwIds = jwIds;
    }

    public Date getBirStart() {
        return birStart;
    }

    public void setBirStart(Date birStart) {
        this.birStart = birStart;
    }

    public Date getBirEnd() {
        return birEnd;
    }

    public void setBirEnd(Date birEnd) {
        this.birEnd = birEnd;
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

    public int getIsKey() {
        return isKey;
    }

    public void setIsKey(int isKey) {
        this.isKey = isKey;
    }
}
