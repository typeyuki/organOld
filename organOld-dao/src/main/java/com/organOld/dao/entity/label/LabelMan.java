package com.organOld.dao.entity.label;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.oldman.Oldman;

/**
 * Created by netlab606 on 2018/7/8.
 */
public class LabelMan extends DBEntity {
    private int labelId;
    private int oldmanId;
    private int isImplement;

    private Oldman oldman;

    public int getIsImplement() {
        return isImplement;
    }

    public void setIsImplement(int isImplement) {
        this.isImplement = isImplement;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }
}
