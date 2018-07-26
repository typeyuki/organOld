package com.organOld.service.enumModel;

//通用 是否
public enum CardStatusEnum {
    ZC("正常",1),GS("挂失",2),NO("不可用",3);

    private String name ;
    private int index ;

    CardStatusEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (CardStatusEnum d : CardStatusEnum.values()) {
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
