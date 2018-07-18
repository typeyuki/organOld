package com.organOld.service.model;

import com.organOld.dao.entity.organ.Organ;

import java.util.ArrayList;
import java.util.List;

public class OldmanKeyHandleModel {
    private int id;
    private List<Organ> organ=new ArrayList<>();
    private List<String> organdIds;
    private List<String> homeFirTypes=new ArrayList<>();
    private String type;

    public List<String> getOrgandIds() {
        return organdIds;
    }

    public void setOrgandIds(List<String> organdIds) {
        this.organdIds = organdIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Organ> getOrgan() {
        return organ;
    }

    public void setOrgan(List<Organ> organ) {
        this.organ = organ;
    }

    public List<String> getHomeFirTypes() {
        return homeFirTypes;
    }

    public void setHomeFirTypes(List<String> homeFirTypes) {
        this.homeFirTypes = homeFirTypes;
    }
}
