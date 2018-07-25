package com.organOld.service.enumModel;


public enum AutoValueEnum {
    PQ("片区",1),//片区
    XQ("小区",2),//小区
    ZZMM("政治面貌",3),//政治面貌
    HJ("户籍",4),//户籍
    JJJG("家庭结构",5),//家庭结构
    JJTJ("经济条件",6),//经济条件
    SZ("失智",7),//失智
    SL("视力",8),//视力
    YJBQ("一级标签",9),//一级标签
    NL("年龄分布",10);//年龄分布
    private String name ;
    private int index ;

    AutoValueEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (AutoValueEnum d : AutoValueEnum.values()) {
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
