package com.organOld.service.model;


import java.util.List;

public class OldmanFamilyModel extends Model{
    private int oldmanId;
    private String family;
    private String oldmanName;
    private String familyTypeString;
    private List<String> familyType;

    public String getFamilyTypeString() {
        return familyTypeString;
    }

    public void setFamilyTypeString(String familyTypeString) {
        this.familyTypeString = familyTypeString;
    }

    public List<String> getFamilyType() {
        return familyType;
    }

    public void setFamilyType(List<String> familyType) {
        this.familyType = familyType;
    }

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
