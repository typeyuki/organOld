package com.organOld.service.enumModel;

//失智
public enum EyesightEnum {
    SM("失明",1),YZA("有障碍",2),ZC("正常",3);

    private String name ;
    private int index ;

    EyesightEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (EyesightEnum d : EyesightEnum.values()) {
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
