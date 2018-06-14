package com.organOld.service.enumModel;

//政治面貌
public enum PoliticalStatusEnum {
    QZ("群众",1),DY("党员",2);

    private String name ;
    private int index ;

    PoliticalStatusEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (PoliticalStatusEnum d : PoliticalStatusEnum.values()) {
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
