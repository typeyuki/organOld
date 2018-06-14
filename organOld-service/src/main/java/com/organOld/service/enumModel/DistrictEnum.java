package com.organOld.service.enumModel;

//片区
public enum DistrictEnum {
    GM("古美",1),GL("古龙",2),DL("东兰",3),PN("平南",4),PY("平阳",5),PJ("平吉",6);

    private String name ;
    private int index ;

    DistrictEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (DistrictEnum d : DistrictEnum.values()) {
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
