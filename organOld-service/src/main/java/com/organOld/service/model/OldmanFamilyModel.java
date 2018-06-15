package com.organOld.service.model;


public class OldmanFamilyModel extends Model{
    private int oldmanId;
    private String family;
    private String oldmanName;

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }


    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }


    public String getOldmanName() {
        return oldmanName;
    }

    public void setOldmanName(String oldmanName) {
        this.oldmanName = oldmanName;
    }
}
