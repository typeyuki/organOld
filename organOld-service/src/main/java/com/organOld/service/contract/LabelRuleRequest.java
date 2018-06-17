package com.organOld.service.contract;


public class LabelRuleRequest {
    private int labelId;
    private int ageStart;
    private int ageEnd;
    private String[] district;
    private String[] organ;
    private int sex;
    private String[] censuse;
    private String[] politicalStatus;
    private int isKey;
    private String[] econmic;
    private String[] family;
    private String[] intelligence;
    private String[] eyesight;
    private String[] isHealth;
    private String[] chx;
    private String[] oldStatus;


    public String[] getOrgan() {
        return organ;
    }

    public void setOrgan(String[] organ) {
        this.organ = organ;
    }

    public String[] getChx() {
        return chx;
    }

    public void setChx(String[] chx) {
        this.chx = chx;
    }

    public String[] getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String[] oldStatus) {
        this.oldStatus = oldStatus;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
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

    public String[] getDistrict() {
        return district;
    }

    public void setDistrict(String[] district) {
        this.district = district;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String[] getCensuse() {
        return censuse;
    }

    public void setCensuse(String[] censuse) {
        this.censuse = censuse;
    }

    public String[] getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String[] politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public int getIsKey() {
        return isKey;
    }

    public void setIsKey(int isKey) {
        this.isKey = isKey;
    }

    public String[] getEconmic() {
        return econmic;
    }

    public void setEconmic(String[] econmic) {
        this.econmic = econmic;
    }

    public String[] getFamily() {
        return family;
    }

    public void setFamily(String[] family) {
        this.family = family;
    }

    public String[] getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String[] intelligence) {
        this.intelligence = intelligence;
    }

    public String[] getEyesight() {
        return eyesight;
    }

    public void setEyesight(String[] eyesight) {
        this.eyesight = eyesight;
    }

    public String[] getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(String[] isHealth) {
        this.isHealth = isHealth;
    }
}
