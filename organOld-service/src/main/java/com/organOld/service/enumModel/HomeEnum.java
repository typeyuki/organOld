package com.organOld.service.enumModel;

//居家养老
public enum HomeEnum {
    JTFW("家庭服务",1),CHX("长护险",2),ZNZD("智能终端",3),JTYS("家庭医生",4),JTBC("家庭病床",5);

    private String name ;
    private int index ;

    HomeEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (HomeEnum d : HomeEnum.values()) {
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
