package com.organOld.service.contract;

public class OldmanFamilyRequest {
    private Integer oldmanId;
    private String[] familyArray;
    private String[] familyTypeArray;
    private String search;

    public String[] getFamilyTypeArray() {
        return familyTypeArray;
    }

    public void setFamilyTypeArray(String[] familyTypeArray) {
        this.familyTypeArray = familyTypeArray;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public String[] getFamilyArray() {
        return familyArray;
    }

    public void setFamilyArray(String[] familyArray) {
        this.familyArray = familyArray;
    }
}
