package com.organOld.dao.entity.oldman;
import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;

import java.util.Date;

/**
 * 经济条件
 * Created by netlab606 on 2018/4/2.
 */
public class OldmanEconomic extends DBEntity implements DBInterface {
    private String economic;
    private Oldman oldman;
    private Integer oldmanId;

    private Integer economicIndex;

    private Integer organId;

    private String[] economicArray;

    private String search;


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String[] getEconomicArray() {
        return economicArray;
    }

    public void setEconomicArray(String[] economicArray) {
        this.economicArray = economicArray;
    }

    public Integer getEconomicIndex() {
        return economicIndex;
    }

    public void setEconomicIndex(Integer economicIndex) {
        this.economicIndex = economicIndex;
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

    public String getEconomic() {
        return economic;
    }

    public void setEconomic(String economic) {
        this.economic = economic;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }
}
