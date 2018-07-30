package com.organOld.service.model;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.HealthSelect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by netlab606 on 2018/7/29.
 */
public class HealthSelectInfoModel {
    private List<HealthSelect> mb=new ArrayList<>();
    private List<HealthSelect> sn=new ArrayList<>();
    private List<HealthSelect> ywfy=new ArrayList<>();

    private List<AutoValue> intelligence=new ArrayList<>();
    private List<AutoValue> eyesight=new ArrayList<>();

    public List<HealthSelect> getMb() {
        return mb;
    }

    public void setMb(List<HealthSelect> mb) {
        this.mb = mb;
    }

    public List<HealthSelect> getSn() {
        return sn;
    }

    public void setSn(List<HealthSelect> sn) {
        this.sn = sn;
    }

    public List<HealthSelect> getYwfy() {
        return ywfy;
    }

    public void setYwfy(List<HealthSelect> ywfy) {
        this.ywfy = ywfy;
    }

    public List<AutoValue> getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(List<AutoValue> intelligence) {
        this.intelligence = intelligence;
    }

    public List<AutoValue> getEyesight() {
        return eyesight;
    }

    public void setEyesight(List<AutoValue> eyesight) {
        this.eyesight = eyesight;
    }
}
