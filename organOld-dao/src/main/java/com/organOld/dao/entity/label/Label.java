package com.organOld.dao.entity.label;


import com.organOld.dao.entity.DBEntity;

/**
 * 三级标签实体
 * Created by netlab606 on 2018/6/7.
 */
public class Label extends DBEntity {

    private LabelSec labelSec;//二级标签
    private String name;
    private String content;//内容
    private String rule;//规则
    private int type;//类型  1 人员绑定标签 2规则指定标签


    public LabelSec getLabelSec() {
        return labelSec;
    }

    public void setLabelSec(LabelSec labelSec) {
        this.labelSec = labelSec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
