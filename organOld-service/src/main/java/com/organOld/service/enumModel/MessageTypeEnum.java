package com.organOld.service.enumModel;

//性别
public enum MessageTypeEnum {
    XT("系统消息",1),FWBT("服务平台反馈",2);

    private String name ;
    private int index ;

    MessageTypeEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (MessageTypeEnum d : MessageTypeEnum.values()) {
            if (d.getIndex() == index) {
                return d.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
