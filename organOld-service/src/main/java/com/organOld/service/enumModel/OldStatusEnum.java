package com.organOld.service.enumModel;

//养老状态
public enum OldStatusEnum {
    JG("机构养老",1),SQ("社区养老",2),JJ("居家养老",3);

    private String name ;
    private int index ;

    OldStatusEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (OldStatusEnum d : OldStatusEnum.values()) {
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
