package com.organOld.dao.entity.label;


import com.organOld.dao.entity.DBEntity;

/**
 * 二级标签
 * Created by netlab606 on 2018/6/7.
 */
public class LabelSec extends DBEntity {
    private int fir;//一级索引
    private String name;//二级

    public int getFir() {
        return fir;
    }

    public void setFir(int fir) {
        this.fir = fir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
