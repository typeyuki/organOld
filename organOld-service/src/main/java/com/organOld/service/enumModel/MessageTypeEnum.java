package com.organOld.service.enumModel;


public enum MessageTypeEnum {
    XT(1);//系统消息
    private int index;

    MessageTypeEnum(int index) {
        this.index=index;
    }

    public int getIndex(){
        return index;
    }
}
