package com.organOld.service.model;

import com.organOld.dao.entity.oldman.KeyRule;

import java.util.List;

public class KeyRulelModel {
    private int baseGoal;
    private List<KeyRuleTypeModel> keyRuleList;

    public int getBaseGoal() {
        return baseGoal;
    }

    public void setBaseGoal(int baseGoal) {
        this.baseGoal = baseGoal;
    }

    public List<KeyRuleTypeModel> getKeyRuleList() {
        return keyRuleList;
    }

    public void setKeyRuleList(List<KeyRuleTypeModel> keyRuleList) {
        this.keyRuleList = keyRuleList;
    }
}
