package com.organOld.service.contract;

public class OldmanEconomicRequest {
    private int id;
    private Integer oldmanId;
    private String search;//模糊全文 匹配搜索

    private String[] economicArray;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public String[] getEconomicArray() {
        return economicArray;
    }

    public void setEconomicArray(String[] economicArray) {
        this.economicArray = economicArray;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
