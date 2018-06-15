package com.organOld.dao.entity.oldman;
import com.organOld.dao.entity.DBEntity;

import java.util.Date;

/**
 * 应急联系人
 * Created by netlab606 on 2018/4/2.
 */
public class OldmanEconomic extends DBEntity {
    private String econmic;
    private Oldman oldman;

    public String getEconmic() {
        return econmic;
    }

    public void setEconmic(String econmic) {
        this.econmic = econmic;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }
}
