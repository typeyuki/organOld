package com.organOld.service.enumModel;

//片区
public enum LabelEnum {
    SF("老人身份",1),SY("老有所养",2),SYI("老有所医",3),SW("老有所为",4),SL("老有所乐",5),SX("老有所学",6);

    private String name ;
    private int index ;

    LabelEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (LabelEnum d : LabelEnum.values()) {
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
