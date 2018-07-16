package com.organOld.service.model;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganType;

import java.util.List;

public class OrganModel {
    private Integer id;
    private Integer organTypeId;
    private String organType;
    private String name;
    private String intro;
    private String work;
    private String serviceTime;
    private String address;
    private String phone;
    private String webUrl;
    private String imgUrl;
    private Integer num;
    private String require;
    private String institution;
    private Integer numIn;
    private Integer numRemain;
    private String districtName;//所属片区名称 如果有的话
    private String time;
    private Integer authConsume;
    private Integer authProduct;
    private Integer authSign;
    private Integer authQueryInfo;
    private Integer authQueryIntegral;
    private Integer parent;

    private Integer organFirTypeId;

    private Organ organ;//主要记录 id和权限


    List<AutoValue> districtList;
    List<OrganType> organTypeList;
    List<Organ> parentOrganList;//主要是 片区

    private String statusDesc;


    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Integer getOrganFirTypeId() {
        return organFirTypeId;
    }

    public void setOrganFirTypeId(Integer organFirTypeId) {
        this.organFirTypeId = organFirTypeId;
    }

    public Integer getParent() {
        return parent;
    }


    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public List<Organ> getParentOrganList() {
        return parentOrganList;
    }

    public void setParentOrganList(List<Organ> parentOrganList) {
        this.parentOrganList = parentOrganList;
    }

    public List<AutoValue> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<AutoValue> districtList) {
        this.districtList = districtList;
    }

    public List<OrganType> getOrganTypeList() {
        return organTypeList;
    }

    public void setOrganTypeList(List<OrganType> organTypeList) {
        this.organTypeList = organTypeList;
    }

    public Integer getAuthConsume() {
        return authConsume;
    }

    public void setAuthConsume(Integer authConsume) {
        this.authConsume = authConsume;
    }

    public Integer getAuthProduct() {
        return authProduct;
    }

    public void setAuthProduct(Integer authProduct) {
        this.authProduct = authProduct;
    }

    public Integer getAuthSign() {
        return authSign;
    }

    public void setAuthSign(Integer authSign) {
        this.authSign = authSign;
    }

    public Integer getAuthQueryInfo() {
        return authQueryInfo;
    }

    public void setAuthQueryInfo(Integer authQueryInfo) {
        this.authQueryInfo = authQueryInfo;
    }

    public Integer getAuthQueryIntegral() {
        return authQueryIntegral;
    }

    public void setAuthQueryIntegral(Integer authQueryIntegral) {
        this.authQueryIntegral = authQueryIntegral;
    }

    public Integer getOrganTypeId() {
        return organTypeId;
    }

    public void setOrganTypeId(Integer organTypeId) {
        this.organTypeId = organTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getNumIn() {
        return numIn;
    }

    public void setNumIn(Integer numIn) {
        this.numIn = numIn;
    }

    public Integer getNumRemain() {
        return numRemain;
    }

    public void setNumRemain(Integer numRemain) {
        this.numRemain = numRemain;
    }


    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
