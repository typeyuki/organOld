package com.organOld.service.enumModel;


public enum AutoValueEnum {
    PQ(1),//片区
    XQ(2),//小区
    ZZMM(3),//政治面貌
    HJ(4),//户籍
    JJJG(5),//家庭结构
    JJTJ(6),//经济条件
    SZ(7),//失智
    SL(8),//视力
    YJBQ(9),//一级标签
    NL(10);//年龄分布
    private int index;

    AutoValueEnum(int index) {
        this.index=index;
    }

    public int getIndex(){
        return index;
    }
}
