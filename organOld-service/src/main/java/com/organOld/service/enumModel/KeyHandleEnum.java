package com.organOld.service.enumModel;

//通用 是否
public enum KeyHandleEnum {
    NO("未处理",0),YES("已处理",1),APPLY("已安排",2);

    private String name ;
    private int index ;

    KeyHandleEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (KeyHandleEnum d : KeyHandleEnum.values()) {
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
