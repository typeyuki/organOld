package com.organOld.service.enumModel;

//户籍
public enum CensusEnum{
    FHJ("非户籍",1),HJ("户籍",2),RHFL("人户分离",3);

    private String name ;
    private int index ;

    CensusEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (CensusEnum d : CensusEnum.values()) {
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
