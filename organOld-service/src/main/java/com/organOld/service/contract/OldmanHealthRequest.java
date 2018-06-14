package com.organOld.service.contract;

public class OldmanHealthRequest {
    private int oldmanId;
    private String search;//模糊搜索

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }
}

