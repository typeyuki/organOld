package com.organOld.service.contract;

public class OrganOldmanRequest {
    private int id;
    private int oldman_id;
    private int organ_id;
    private String search;//模糊全文 匹配搜索

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOldman_id() {
        return oldman_id;
    }

    public void setOldman_id(int oldman_id) {
        this.oldman_id = oldman_id;
    }

    public int getOrgan_id() {
        return organ_id;
    }

    public void setOrgan_id(int organ_id) {
        this.organ_id = organ_id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
