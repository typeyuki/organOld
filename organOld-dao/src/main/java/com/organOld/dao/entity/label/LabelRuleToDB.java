package com.organOld.dao.entity.label;

import java.util.Date;
import java.util.List;

//用于数据库 人员 筛选
public class LabelRuleToDB {
    private Date birStart;
    private Date birEnd;
    private List<String> districtIds;
    private int sex;
    private List<String> censuses;
    private List<String> politicalStatuses;
    private int isKey;
    private List<String> econmicIndexs;
    private List<String> familyIndexs;
    private List<String> intelligences;
    private List<String> eyesights;
    private List<String> isHealths;

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


    public List<String> getEconmicIndexs() {
        return econmicIndexs;
    }

    public void setEconmicIndexs(List<String> econmicIndexs) {
        this.econmicIndexs = econmicIndexs;
    }

    public List<String> getFamilyIndexs() {
        return familyIndexs;
    }

    public void setFamilyIndexs(List<String> familyIndexs) {
        this.familyIndexs = familyIndexs;
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
