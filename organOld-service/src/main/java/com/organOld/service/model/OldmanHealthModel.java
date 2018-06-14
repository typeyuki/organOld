package com.organOld.service.model;




import com.organOld.dao.entity.oldman.HealthAdd;
import com.organOld.dao.entity.oldman.HealthSelect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by netlab606 on 2018/5/28.
 */
public class OldmanHealthModel {
    private int id;
    private int oldmanId;
    private String bloodType;
    private String intelligence;//失智
    private String eyesight;//视力
    private List<HealthAdd> addExzl=new ArrayList<>();//恶性肿瘤史  id+内容
    private List<HealthAdd> addGz=new ArrayList<>();//骨折史
    private List<HealthAdd> addCj=new ArrayList<>();//残疾情况
    private List<HealthSelect> selectMb=new ArrayList<>();//慢病
    private List<HealthSelect> selectSn=new ArrayList<>();//失能
    private List<HealthSelect> selectYwfy=new ArrayList<>();//药物反应
    private String name;
    private String time;//更新日期

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getEyesight() {
        return eyesight;
    }

    public void setEyesight(String eyesight) {
        this.eyesight = eyesight;
    }

    public List<HealthAdd> getAddExzl() {
        return addExzl;
    }

    public void setAddExzl(List<HealthAdd> addExzl) {
        this.addExzl = addExzl;
    }

    public List<HealthAdd> getAddGz() {
        return addGz;
    }

    public void setAddGz(List<HealthAdd> addGz) {
        this.addGz = addGz;
    }

    public List<HealthAdd> getAddCj() {
        return addCj;
    }

    public void setAddCj(List<HealthAdd> addCj) {
        this.addCj = addCj;
    }

    public List<HealthSelect> getSelectMb() {
        return selectMb;
    }

    public void setSelectMb(List<HealthSelect> selectMb) {
        this.selectMb = selectMb;
    }

    public List<HealthSelect> getSelectSn() {
        return selectSn;
    }

    public void setSelectSn(List<HealthSelect> selectSn) {
        this.selectSn = selectSn;
    }

    public List<HealthSelect> getSelectYwfy() {
        return selectYwfy;
    }

    public void setSelectYwfy(List<HealthSelect> selectYwfy) {
        this.selectYwfy = selectYwfy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
