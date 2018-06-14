package com.organOld.service.contract;

public class OldmanEconomicRequest {
    private int id;
    private int oldman_id;
    private int economic_index;
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

    public int getEconomic_index() {
        return economic_index;
    }

    public void setEconomic_index(int economic_index) {
        this.economic_index = economic_index;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
