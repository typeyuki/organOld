package com.organOld.dao.entity.oldman;

import com.organOld.dao.entity.DBEntity;

/**
 * 重点老人 模型 规则
 * Created by netlab606 on 2018/6/21.
 */
public class KeyRule extends DBEntity{
    private Integer type;
    private Integer valueIndex;
    private Integer goal;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValueIndex() {
        return valueIndex;
    }

    public void setValueIndex(Integer valueIndex) {
        this.valueIndex = valueIndex;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = goal;
    }
}