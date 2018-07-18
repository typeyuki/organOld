package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.label.LabelMan;
import com.organOld.dao.entity.organ.Organ;

import java.util.Date;
import java.util.List;

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
    private Integer isHandle;
    private Integer integral;
    private Integer oldStatus;
    /**
     * 搜索对象
     */
    private Integer organId;//居委ID 或者片区ID
    private Date birthdayStart;//出生年月-起
    private Date birthdayEnd;//出生年月-止
    private Integer goalStart;
    private Integer goalEnd;
    private Integer isActivity;


    private String censusArray[];//户籍 1非 2户籍 3人户分离
    private String district[];//片区索引
    private String search;//模糊全文 匹配搜索  姓名、身份证、地址、电话
    private String jw[];//居委索引
    private String politicalStatusArray[];//政治面貌 1群众 2党员
    private String family[];
    private String economic[];
    private String isHealth[];
    private String intelligence[];
    private String eyesight[];
    private String oldStatusArray[];


    private String future;//是否是查询未来的重点老人得分

    private Integer keyGoalBase;//重点老人分数基线

    /**
     * 关联对象
     * @return
     */
    private Xq xq;//小区
    private List<LabelMan> labelManList;
    private OldmanKeyHandle oldmanKeyHandle;
    private List<Organ> organList;
    private List<Home> homeList;


    public List<Home> getHomeList() {
        return homeList;
    }

    public void setHomeList(List<Home> homeList) {
        this.homeList = homeList;
    }

    public List<Organ> getOrganList() {
        return organList;
    }

    public void setOrganList(List<Organ> organList) {
        this.organList = organList;
    }

    public OldmanKeyHandle getOldmanKeyHandle() {
        return oldmanKeyHandle;
    }

    public void setOldmanKeyHandle(OldmanKeyHandle oldmanKeyHandle) {
        this.oldmanKeyHandle = oldmanKeyHandle;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(Integer isActivity) {
        this.isActivity = isActivity;
    }

    public Integer getGoalStart() {
        return goalStart;
    }

    public void setGoalStart(Integer goalStart) {
        this.goalStart = goalStart;
    }

    public Integer getGoalEnd() {
        return goalEnd;
    }

    public void setGoalEnd(Integer goalEnd) {
        this.goalEnd = goalEnd;
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    public Integer getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Integer oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String[] getOldStatusArray() {
        return oldStatusArray;
    }

    public void setOldStatusArray(String[] oldStatusArray) {
        this.oldStatusArray = oldStatusArray;
    }

    public List<LabelMan> getLabelManList() {
        return labelManList;
    }

    public void setLabelManList(List<LabelMan> labelManList) {
        this.labelManList = labelManList;
    }

    public String[] getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(String[] isHealth) {
        this.isHealth = isHealth;
    }

    public String[] getCensusArray() {
        return censusArray;
    }

    public void setCensusArray(String[] censusArray) {
        this.censusArray = censusArray;
    }

    public String[] getDistrict() {
        return district;
    }

    public void setDistrict(String[] district) {
        this.district = district;
    }


    public String[] getJw() {
        return jw;
    }

    public void setJw(String[] jw) {
        this.jw = jw;
    }

    public String[] getPoliticalStatusArray() {
        return politicalStatusArray;
    }

    public void setPoliticalStatusArray(String[] politicalStatusArray) {
        this.politicalStatusArray = politicalStatusArray;
    }

    public String[] getFamily() {
        return family;
    }

    public void setFamily(String[] family) {
        this.family = family;
    }

    public String[] getEconomic() {
        return economic;
    }

    public void setEconomic(String[] economic) {
        this.economic = economic;
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
