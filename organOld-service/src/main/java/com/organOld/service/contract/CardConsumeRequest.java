package com.organOld.service.contract;

/**
 * 一卡通 消费
 * Created by netlab606 on 2018/6/25.
 */
public class CardConsumeRequest {
    private int oldmanId;
    private int organId;

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }

    public int getOrganId() {
        return organId;
    }

    public void setOrganId(int organId) {
        this.organId = organId;
    }
}
