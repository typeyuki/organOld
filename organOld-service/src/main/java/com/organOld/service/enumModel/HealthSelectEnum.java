package com.organOld.service.enumModel;


public enum HealthSelectEnum {
    MB(1),//慢病
    SN(2),//失能
    YW(3);//药物反应

    private int index;

    HealthSelectEnum(int index) {
        this.index=index;
    }

    public int getIndex(){
        return index;
    }
}
