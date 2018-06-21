package com.organOld.service.contract;

public class OrganOldmanRequest {
    private int organId;
    private int oldmanId;
    private String firType;//用于养老状态  organ机构养老 community 社区养老

    public String getFirType() {
        return firType;
    }

    public void setFirType(String firType) {
        this.firType = firType;
    }

    public int getOrganId() {
        return this.organId;
    }

    public void setOrganId(int organId) {
        this.organId = organId;
    }

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }
}
