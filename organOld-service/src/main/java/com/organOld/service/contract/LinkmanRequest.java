package com.organOld.service.contract;

public class LinkmanRequest {
    private int id;
    private int oldman_id;
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

    public void setOldman_id(int id) {
        this.oldman_id = oldman_id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

}
