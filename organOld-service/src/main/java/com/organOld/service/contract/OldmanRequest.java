package com.organOld.service.contract;

import java.util.Date;

public class OldmanRequest {
    private int id;
    private String[] census;//户籍 1非 2户籍 3人户分离
    private String districtId;//片区索引
    private String ageStart;//年龄段-起
    private String ageEnd;//年龄段-止
    private String search;//模糊全文 匹配搜索  姓名、身份证、地址、电话
    private String jwId;//居委索引
    private String sex;//1女 2男
    private String politicalStatus;//政治面貌 1群众 2党员
    private String[] familyIndex;
    private String[] economicIndex;

    private String name;
    private String phone;
    private String address;
    private String pid;
    private Date birthday;

    public String[] getCensus() {
        return census;
    }

    public String getAgeStart() {
        return ageStart;
    }

    public String getAgeEnd() {
        return ageEnd;
    }

    public void setCensus(String[] census) {
        this.census = census;
    }

    public void setAgeStart(String ageStart) {
        this.ageStart = ageStart;
    }

    public void setAgeEnd(String ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String[] getFamilyIndex() {
        return familyIndex;
    }

    public void setFamilyIndex(String[] familyIndex) {
        this.familyIndex = familyIndex;
    }

    public String[] getEconomicIndex() {
        return economicIndex;
    }

    public void setEconomicIndex(String[] economicIndex) {
        this.economicIndex = economicIndex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getJwId() {
        return jwId;
    }

    public void setJwId(String jwId) {
        this.jwId = jwId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

}
