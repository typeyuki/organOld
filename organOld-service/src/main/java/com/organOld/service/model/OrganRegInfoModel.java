package com.organOld.service.model;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.organ.OrganType;

import java.util.ArrayList;
import java.util.List;

public class OrganRegInfoModel {
    private List<AutoValue> district;
    private List<OrganType> organTypeList;

    public List<AutoValue> getDistrict() {
        return district;
    }

    public void setDistrict(List<AutoValue> district) {
        this.district = district;
    }

    public List<OrganType> getOrganTypeList() {
        return organTypeList;
    }

    public void setOrganTypeList(List<OrganType> organTypeList) {
        this.organTypeList = organTypeList;
    }
}
