package com.organOld.service.model;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganType;

import java.util.List;

public class OrganAddModel {
    private int organTypeId;
    List<AutoValue> districtList;
    List<OrganType> organTypeList;
    List<Organ> parentOrganList;//主要是 片区

    public int getOrganTypeId() {
        return organTypeId;
    }

    public void setOrganTypeId(int organTypeId) {
        this.organTypeId = organTypeId;
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

    public List<Organ> getParentOrganList() {
        return parentOrganList;
    }

    public void setParentOrganList(List<Organ> parentOrganList) {
        this.parentOrganList = parentOrganList;
    }
}
