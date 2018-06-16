package com.organOld.dao.entity.label;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.organ.Organ;

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
    private Organ organ;//发布的组织ID 主要是居委 0的话 表示针对所有


    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

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
