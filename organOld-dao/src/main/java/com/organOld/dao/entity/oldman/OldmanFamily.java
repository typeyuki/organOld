package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;

/**
 * 家庭结构
 * Created by netlab606 on 2018/4/2.
 */
public class OldmanFamily extends DBEntity implements DBInterface {
    private String family;
    private Oldman oldman;
    private Integer oldmanId;
    private Integer organId;

    private Integer familyIndex;


    @Override
    public String toString() {
        return "OldmanFamily{" +
                "family='" + family + '\'' +
                ", oldman=" + oldman +
                ", oldmanId=" + oldmanId +
                ", organId=" + organId +
                ", familyIndex=" + familyIndex +
                '}';
    }

    public Integer getFamilyIndex() {
        return familyIndex;
    }

    public void setFamilyIndex(Integer familyIndex) {
        this.familyIndex = familyIndex;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }
}
