package com.organOld.service.contract;

/**
 * Created by netlab606 on 2018/6/25.
 */
public class KeyRuleRequest {
    private String[] goal;
    private String[] id;
    private int baseGoal;

    public int getBaseGoal() {
        return baseGoal;
    }

    public void setBaseGoal(int baseGoal) {
        this.baseGoal = baseGoal;
    }

    public String[] getGoal() {
        return goal;
    }

    public void setGoal(String[] goal) {
        this.goal = goal;
    }

    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }
}
