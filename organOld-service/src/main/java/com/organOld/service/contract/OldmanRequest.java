package com.organOld.service.contract;

import java.util.Date;

public class OldmanRequest {
    private int id;
    private Integer census;//户籍 1非 2户籍 3人户分离
    private Integer districtId;//片区索引
    private Integer ageStart;//年龄段-起
    private Integer ageEnd;//年龄段-止
    private String search;//模糊全文 匹配搜索  姓名、身份证、地址、电话
    private Integer jwId;//居委索引
    private Integer sex;//1女 2男
    private Integer politicalStatus;//政治面貌 1群众 2党员


    private String name;
    private String phone;
    private String address;
    private String pid;
    private Date birthday;


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

    public Integer getCensus() {
        return census;
    }

    public void setCensus(Integer census) {
        this.census = census;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(Integer ageStart) {
        this.ageStart = ageStart;
    }

    public Integer getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(Integer ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getJwId() {
        return jwId;
    }

    public void setJwId(Integer jwId) {
        this.jwId = jwId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(Integer politicalStatus) {
        this.politicalStatus = politicalStatus;
    }
}
