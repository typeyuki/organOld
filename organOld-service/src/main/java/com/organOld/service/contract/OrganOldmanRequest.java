package com.organOld.service.contract;

public class OrganOldmanRequest {
    private int organId;
    private Integer oldmanId;
    private String firType;//用于养老状态  organ机构养老 community 社区养老
    private Integer isPd;
    private String search;


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getIsPd() {
        return isPd;
    }

    public void setIsPd(Integer isPd) {
        this.isPd = isPd;
    }

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

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }
}
