package com.organOld.service.contract;


public class LabelRuleRequest {
    private int labelId;
    private String ageStart;  //要用string 去接受前端数据  不然int的话 传空值会400
    private String ageEnd;
    private String[] district;
    private String[] organ;
    private String sex;
    private String[] census;
    private String[] politicalStatus;
    private String isKey;
    private String[] economic;
    private String[] family;
    private String[] familyType;
    private String[] intelligence;
    private String[] eyesight;
    private String[] isHealth;
    private String[] chx;
    private String[] oldStatus;
    private String[] zc;
    private String[] sqzw;

    public String[] getFamilyType() {
        return familyType;
    }

    public void setFamilyType(String[] familyType) {
        this.familyType = familyType;
    }

    public String[] getZc() {
        return zc;
    }

    public void setZc(String[] zc) {
        this.zc = zc;
    }

    public String[] getSqzw() {
        return sqzw;
    }

    public void setSqzw(String[] sqzw) {
        this.sqzw = sqzw;
    }

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


    public String[] getCensus() {
        return census;
    }

    public void setCensus(String[] census) {
        this.census = census;
    }

    public String[] getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String[] politicalStatus) {
        this.politicalStatus = politicalStatus;
    }



    public String[] getEconomic() {
        return economic;
    }

    public void setEconomic(String[] economic) {
        this.economic = economic;
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

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public String getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(String ageStart) {
        this.ageStart = ageStart;
    }

    public String getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(String ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String[] getDistrict() {
        return district;
    }

    public void setDistrict(String[] district) {
        this.district = district;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIsKey() {
        return isKey;
    }

    public void setIsKey(String isKey) {
        this.isKey = isKey;
    }

    public String[] getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String[] oldStatus) {
        this.oldStatus = oldStatus;
    }
}
