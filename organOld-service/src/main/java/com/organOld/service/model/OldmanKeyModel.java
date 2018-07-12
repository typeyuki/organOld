package com.organOld.service.model;

public class OldmanKeyModel {
    private Integer oldmanId;
    private String oldmanNameKeyStatus;//以# 分割
    private Integer goal;
    private Integer isHandle;


    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
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
