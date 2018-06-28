package com.organOld.service.contract;

public class HomeRequest {
    private int id;
    private int firType;
    private String search;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirType() {
        return firType;
    }

    public void setFirType(int firType) {
        this.firType = firType;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
