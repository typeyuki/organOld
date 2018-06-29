package com.organOld.service.contract;

/**
 * 一卡通 消费
 * Created by netlab606 on 2018/6/25.
 */
public class CardConsumeRequest {
    private String oldmanId;
    private String organId;
    private String money;


    @Override
    public String toString() {
        return "CardConsumeRequest{" +
                "oldmanId='" + oldmanId + '\'' +
                ", organId='" + organId + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public String getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(String oldmanId) {
        this.oldmanId = oldmanId;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
