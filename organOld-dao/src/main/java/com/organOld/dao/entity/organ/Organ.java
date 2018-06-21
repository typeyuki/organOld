package com.organOld.dao.entity.organ;

import com.organOld.dao.entity.DBEntity;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/16.
 */
public class Organ extends DBEntity {
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
    private String insitution;
    private Integer numIn;
    private Integer numRemain;
    private String districtName;//所属片区名称 如果有的话
    private String status;


    /**
     * 搜索
     * @return
     */
    private Integer organFirTypeId;//一级类型ID
    private String search;//模糊搜索

    public Integer getOrganTypeId() {
        return organTypeId;
    }

    public void setOrganTypeId(Integer organTypeId) {
        this.organTypeId = organTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrganFirTypeId() {
        return organFirTypeId;
    }

    public void setOrganFirTypeId(Integer organFirTypeId) {
        this.organFirTypeId = organFirTypeId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
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

    public String getInsitution() {
        return insitution;
    }

    public void setInsitution(String insitution) {
        this.insitution = insitution;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
