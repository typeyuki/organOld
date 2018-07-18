package com.organOld.service.model;

import com.organOld.dao.entity.organ.Organ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OldmanKeyModel {
    private Integer oldmanId;
    private String oldmanNameKeyStatus;//以# 分割
    private Integer goal;
    private String status;//状态  已安排  已处理  未处理
    private List<Organ> organActivity=new ArrayList<>();//主动申请的机构
    private String oldStatus;//已安排的养老状态
    private Map<String,String> organAndHome=new HashMap<>();//已安排的机构

    private OldmanKeyHandleModel oldmanKeyHandleModel;//处理


    public OldmanKeyHandleModel getOldmanKeyHandleModel() {
        return oldmanKeyHandleModel;
    }

    public void setOldmanKeyHandleModel(OldmanKeyHandleModel oldmanKeyHandleModel) {
        this.oldmanKeyHandleModel = oldmanKeyHandleModel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    public List<Organ> getOrganActivity() {
        return organActivity;
    }

    public void setOrganActivity(List<Organ> organActivity) {
        this.organActivity = organActivity;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Map<String, String> getOrganAndHome() {
        return organAndHome;
    }

    public void setOrganAndHome(Map<String, String> organAndHome) {
        this.organAndHome = organAndHome;
    }



    public String getOldmanNameKeyStatus() {
        return oldmanNameKeyStatus;
    }

    public void setOldmanNameKeyStatus(String oldmanNameKeyStatus) {
        this.oldmanNameKeyStatus = oldmanNameKeyStatus;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }


    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = goal;
    }
}
