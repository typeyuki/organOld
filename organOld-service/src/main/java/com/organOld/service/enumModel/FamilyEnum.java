package com.organOld.service.enumModel;

//家庭结构
public enum FamilyEnum {
    CL("纯老",1),DJ("独居",2),SD("失独",3),YLYYL("一老养一老",4),GL("孤老",5),SZ("三支人员",6),Other("其他",7);

    private String name ;
    private int index ;

    FamilyEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (FamilyEnum d : FamilyEnum.values()) {
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
