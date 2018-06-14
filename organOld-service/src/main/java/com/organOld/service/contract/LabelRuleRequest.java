package com.organOld.service.contract;

import java.util.List;

public class LabelRuleRequest {
    private int ageStart;
    private int ageEnd;
    private List<String> districtIds;
    private int sex;
    private List<String> censuses;
    private List<String> politicalStatuses;
    private int is_key;
    private List<String> econmic_indexs;
    private List<String> family_indexs;
    private List<String> intelligences;
    private List<String> eyesights;
    private List<String> is_healths;

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

    public int getIs_key() {
        return is_key;
    }

    public void setIs_key(int is_key) {
        this.is_key = is_key;
    }

    public List<String> getEconmic_indexs() {
        return econmic_indexs;
    }

    public void setEconmic_indexs(List<String> econmic_indexs) {
        this.econmic_indexs = econmic_indexs;
    }

    public List<String> getFamily_indexs() {
        return family_indexs;
    }

    public void setFamily_indexs(List<String> family_indexs) {
        this.family_indexs = family_indexs;
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

    public List<String> getIs_healths() {
        return is_healths;
    }

    public void setIs_healths(List<String> is_healths) {
        this.is_healths = is_healths;
    }
}
