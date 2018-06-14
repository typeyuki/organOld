package com.organOld.dao.entity.oldman;



import com.organOld.dao.entity.DBEntity;

import java.util.Date;

/**
 * 应急联系人
 * Created by netlab606 on 2018/4/2.
 */
public class Economic extends DBEntity {
    private int oldmanId;
    private int id;
    private int econmic_index;
    private Date time;

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getEconmic_index() {
        return econmic_index;
    }

    public void setEconmic_index(int econmic_index) {
        this.econmic_index = econmic_index;
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public void setTime(Date time) {
        this.time = time;
    }
}
