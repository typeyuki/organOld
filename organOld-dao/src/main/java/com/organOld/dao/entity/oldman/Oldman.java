package com.organOld.dao.entity.oldman;



import com.organOld.dao.entity.Juwei;

import java.util.Date;

/**
 * 老人
 * Created by netlab606 on 2018/4/2.
 */
public class Oldman extends Man{
    private Integer sex;//1女 2男
    private Date birthday;//出生年月
    private String pid;//身份证号
    private String address;//户籍住址
    private Integer census;//户籍 1非 2户籍
    private Integer districtId;//片区索引
    private Linkman linkman;//应急联系人
    private Integer jwId;//居委索引
    private Integer politicalStatus;//政治面貌 1群众 2党员

    private int goal;//得分用于 重点老人

    /**
     * 搜索对象
     */
    private Date birthdayStart;//出生年月-起
    private Date birthdayEnd;//出生年月-止
    private String search;//模糊搜索
    /**
     * 关联对象
     */
    private Juwei jw;//所属居委会

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Linkman getLinkman() {
        return linkman;
    }

    public void setLinkman(Linkman linkman) {
        this.linkman = linkman;
    }

    public Juwei getJw() {
        return jw;
    }

    public void setJw(Juwei jw) {
        this.jw = jw;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(Integer politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public Date getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(Date birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public Date getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(Date birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
