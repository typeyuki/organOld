package com.organOld.dao.entity.label;


import com.organOld.dao.entity.DBEntity;

//规则绑定标签
public class LabelRule extends DBEntity {
    private int ageStart;
    private int ageEnd;
    private String districtIds;
    private int sex;
    private String censuses;
    private String politicalStatuses;
    private int isKey;
    private String econmicIndexs;
    private String familyIndexs;
    private String intelligences;
    private String eyesights;
    private String isHealths;



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

    public String getDistrictIds() {
        return districtIds;
    }

    public void setDistrictIds(String districtIds) {
        this.districtIds = districtIds;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCensuses() {
        return censuses;
    }

    public void setCensuses(String censuses) {
        this.censuses = censuses;
    }

    public String getPoliticalStatuses() {
        return politicalStatuses;
    }

    public void setPoliticalStatuses(String politicalStatuses) {
        this.politicalStatuses = politicalStatuses;
    }

    public int getIsKey() {
        return isKey;
    }

    public void setIsKey(int isKey) {
        this.isKey = isKey;
    }

    public String getEconmicIndexs() {
        return econmicIndexs;
    }

    public void setEconmicIndexs(String econmicIndexs) {
        this.econmicIndexs = econmicIndexs;
    }

    public String getFamilyIndexs() {
        return familyIndexs;
    }

    public void setFamilyIndexs(String familyIndexs) {
        this.familyIndexs = familyIndexs;
    }

    public String getIntelligences() {
        return intelligences;
    }

    public void setIntelligences(String intelligences) {
        this.intelligences = intelligences;
    }

    public String getEyesights() {
        return eyesights;
    }

    public void setEyesights(String eyesights) {
        this.eyesights = eyesights;
    }

    public String getIsHealths() {
        return isHealths;
    }

    public void setIsHealths(String isHealths) {
        this.isHealths = isHealths;
    }
}
