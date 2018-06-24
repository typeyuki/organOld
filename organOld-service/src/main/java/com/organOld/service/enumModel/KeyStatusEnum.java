package com.organOld.service.enumModel;


public enum KeyStatusEnum {
    NO(1),//上次这次都不是重点老人
    YES(2),//上次和这次都是重点老人
    DEL(3),//上次是这是不是  即去掉的
    ADD(4);//上次不是这次是即新增的
    private int index;

    KeyStatusEnum(int index) {
        this.index=index;
    }

    public int getIndex(){
        return index;
    }
}
