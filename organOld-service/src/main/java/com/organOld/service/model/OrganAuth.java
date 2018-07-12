package com.organOld.service.model;

//机构的权限
public class OrganAuth {
    private int organId;
    private int authConsume;
    private int authSign;
    private int authQueryInfo;
    private int authQueryIntegral;


    public int getOrganId() {
        return organId;
    }

    public void setOrganId(int organId) {
        this.organId = organId;
    }

    public int getAuthConsume() {
        return authConsume;
    }

    public void setAuthConsume(int authConsume) {
        this.authConsume = authConsume;
    }

    public int getAuthSign() {
        return authSign;
    }

    public void setAuthSign(int authSign) {
        this.authSign = authSign;
    }

    public int getAuthQueryInfo() {
        return authQueryInfo;
    }

    public void setAuthQueryInfo(int authQueryInfo) {
        this.authQueryInfo = authQueryInfo;
    }

    public int getAuthQueryIntegral() {
        return authQueryIntegral;
    }

    public void setAuthQueryIntegral(int authQueryIntegral) {
        this.authQueryIntegral = authQueryIntegral;
    }
}
