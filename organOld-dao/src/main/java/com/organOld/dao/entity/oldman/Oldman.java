package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBInterface;

import java.util.Date;

/**
 * 老人
 * Created by netlab606 on 2018/4/2.
 */
public class Oldman extends Man implements DBInterface{
    private Integer sex;//1女 2男
    private Date birthday;//出生年月
    private String pid;//身份证号
    private String address;//户籍住址
    private String census;//户籍
    private String politicalStatus;//政治面貌
    private Integer louNum;//楼号
    private int goal;//得分用于 重点老人
    private Integer keyStatus;
    private Integer xqId;
    private Integer floor;

    /**
     * 搜索对象
     */
    private Date birthdayStart;//出生年月-起
    private Date birthdayEnd;//出生年月-止
    private String search;//模糊搜索
    private Integer organId;//居委ID
    private String future;//是否是查询未来的重点老人得分

    private Integer keyGoalBase;//重点老人分数基线
    /**
     * 关联对象
     * @return
     */
    private Xq xq;//小区

    @Override
    public String toString() {
        return "Oldman{" +
                "sex=" + sex +
                ", birthday=" + birthday +
                ", pid='" + pid + '\'' +
                ", address='" + address + '\'' +
                ", census='" + census + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", louNum=" + louNum +
                ", xqId=" + xqId +
                ", floor=" + floor +
                ", xq=" + xq +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getXqId() {
        return xqId;
    }

    public void setXqId(Integer xqId) {
        this.xqId = xqId;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public Integer getKeyStatus() {
        return keyStatus;
    }

    public void setKeyStatus(Integer keyStatus) {
        this.keyStatus = keyStatus;
    }

    public Integer getKeyGoalBase() {
        return keyGoalBase;
    }

    public void setKeyGoalBase(Integer keyGoalBase) {
        this.keyGoalBase = keyGoalBase;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
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


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getCensus() {
        return census;
    }

    public void setCensus(String census) {
        this.census = census;
    }

    public Xq getXq() {
        return xq;
    }

    public void setXq(Xq xq) {
        this.xq = xq;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public Integer getLouNum() {
        return louNum;
    }

    public void setLouNum(Integer louNum) {
        this.louNum = louNum;
    }
}
