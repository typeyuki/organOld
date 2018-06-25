package com.organOld.service.model;

import com.organOld.dao.entity.oldman.KeyRule;

import java.util.ArrayList;
import java.util.List;

public class KeyRuleTypeModel implements Comparable{
    private int type;
    private String typeDesc;
    private List<KeyRule> keyRuleList=new ArrayList<>();


    @Override
    public int compareTo(Object o) {
        KeyRuleTypeModel keyRuleTypeModel=(KeyRuleTypeModel) o;
        return getType()-keyRuleTypeModel.getType();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public List<KeyRule> getKeyRuleList() {
        return keyRuleList;
    }

    public void setKeyRuleList(List<KeyRule> keyRuleList) {
        this.keyRuleList = keyRuleList;
    }
}
