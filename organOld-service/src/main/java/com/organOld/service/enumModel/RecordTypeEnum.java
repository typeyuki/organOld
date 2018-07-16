package com.organOld.service.enumModel;

//通用 是否
public enum RecordTypeEnum {
    CONSUME("消费记录",1),SIGN("签到记录",2),INFO("老人信息查询记录",3),IN("老人积分查询记录",4);

    private String name ;
    private int index ;

    RecordTypeEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (RecordTypeEnum d : RecordTypeEnum.values()) {
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