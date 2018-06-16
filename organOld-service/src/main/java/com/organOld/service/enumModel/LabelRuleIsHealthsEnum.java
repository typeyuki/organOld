package com.organOld.service.enumModel;


public enum LabelRuleIsHealthsEnum {
    EXZL("恶性肿瘤史",1),//恶性肿瘤史
    GZ("骨折史",2),//骨折史
    CJQK("残疾情况",3),//残疾情况
    MB("慢病",4),//慢病
    SN("失能",5),//失能
    YW("药物反应",6);//药物反应
    private String name ;
    private int index ;

    LabelRuleIsHealthsEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (LabelRuleIsHealthsEnum d : LabelRuleIsHealthsEnum.values()) {
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
