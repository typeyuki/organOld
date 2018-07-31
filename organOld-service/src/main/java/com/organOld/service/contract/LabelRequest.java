package com.organOld.service.contract;

/**
 * Created by netlab606 on 2018/6/7.
 */
public class LabelRequest {
    private int id;
    private int oldmanId;
    private int type;
    private String[] censusArray;//户籍
    private String[] district;//片区索引
    private Integer ageStart;//年龄段-起
    private Integer ageEnd;//年龄段-止
    private String search;//模糊全文 匹配搜索  姓名、身份证、地址、电话
    private String[] jw;//居委索引
    private Integer sex;//1女 2男
    private Integer isKey;
    private String wh;
    private Integer belongOrgan;
    private Integer firType;
    private Integer secType;
    private String[] politicalStatusArray;//政治面貌
    private String[] family;
    private String[] familyType;
    private String[] economic;
    private String[] isHealth;
    private String[] intelligence;
    private String[] eyesight;
    private String[] oldStatusArray;
    private String[] zcArray;
    private String[] sqzwArray;

    public String[] getFamilyType() {
        return familyType;
    }

    public void setFamilyType(String[] familyType) {
        this.familyType = familyType;
    }

    public String[] getZcArray() {
        return zcArray;
    }

    public void setZcArray(String[] zcArray) {
        this.zcArray = zcArray;
    }

    public String[] getSqzwArray() {
        return sqzwArray;
    }

    public void setSqzwArray(String[] sqzwArray) {
        this.sqzwArray = sqzwArray;
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

    public String[] getJw() {
        return jw;
    }

    public void setJw(String[] jw) {
        this.jw = jw;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIsKey() {
        return isKey;
    }

    public void setIsKey(Integer isKey) {
        this.isKey = isKey;
    }

    public String getWh() {
        return wh;
    }

    public void setWh(String wh) {
        this.wh = wh;
    }

    public Integer getBelongOrgan() {
        return belongOrgan;
    }

    public void setBelongOrgan(Integer belongOrgan) {
        this.belongOrgan = belongOrgan;
    }

    public Integer getFirType() {
        return firType;
    }

    public void setFirType(Integer firType) {
        this.firType = firType;
    }

    public Integer getSecType() {
        return secType;
    }

    public void setSecType(Integer secType) {
        this.secType = secType;
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

    public String[] getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(String[] isHealth) {
        this.isHealth = isHealth;
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

    public String[] getOldStatusArray() {
        return oldStatusArray;
    }

    public void setOldStatusArray(String[] oldStatusArray) {
        this.oldStatusArray = oldStatusArray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
