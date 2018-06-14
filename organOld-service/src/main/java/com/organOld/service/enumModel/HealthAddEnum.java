package com.organOld.service.enumModel;


public enum HealthAddEnum {
    EXZL(1),//恶性肿瘤史
    GZ(2),//骨折史
    CJQK(3);//残疾情况

    private int index;

    HealthAddEnum(int index) {
        this.index=index;
    }

    public int getIndex(){
        return index;
    }
}
