package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBEntity;

/**
 * 应急联系人
 * Created by netlab606 on 2018/4/2.
 */
public class Family extends DBEntity {
    private int oldmanId;
    private int familyIndex;



    private String oldmanName;

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }


    public int getFamilyIndex() {
        return familyIndex;
    }

    public void setFamilyIndex(int familyIndex) {
        this.familyIndex = familyIndex;
    }

    public String getOldmanName() {
        return oldmanName;
    }

    public void setOldmanName(String oldmanName) {
        this.oldmanName = oldmanName;
    }
}
