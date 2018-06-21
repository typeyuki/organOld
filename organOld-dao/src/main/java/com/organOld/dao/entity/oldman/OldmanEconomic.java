package com.organOld.dao.entity.oldman;
import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;

import java.util.Date;

/**
 * 经济条件
 * Created by netlab606 on 2018/4/2.
 */
public class OldmanEconomic extends DBEntity implements DBInterface {
    private String economic;
    private Oldman oldman;


    private Integer jwId;

    public Integer getJwId() {
        return jwId;
    }

    @Override
    public void setJwId(Integer jwId) {
        this.jwId = jwId;
    }

    public String getEconomic() {
        return economic;
    }

    public void setEconomic(String economic) {
        this.economic = economic;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }
}
