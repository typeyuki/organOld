package com.organOld.service.enumModel;


public enum KeyRuleTypeEnum {

    NL("年龄",1),
    JTJG("家庭结构",2),
    CHX("长护险",3),//药物反应
    SN("失能",4),
    ZL("智力",5),
    SL("视力",6),
    MB("慢病",7),
    JJTJ("经济条件",8),
    LOU("无电梯楼层",9),
    JYLY("是否主动申请进养老院",10);
    private String name ;
    private int index ;

    KeyRuleTypeEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }



    public static String getValue(int index) {
        for (KeyRuleTypeEnum d : KeyRuleTypeEnum.values()) {
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
