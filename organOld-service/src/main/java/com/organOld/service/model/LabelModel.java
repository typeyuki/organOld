package com.organOld.service.model;

/**
 * Created by netlab606 on 2018/6/7.
 */
public class LabelModel extends Model{
    private String fir;
    private String sec;
    private String name;
    private String rule;
    private String content;

    public String getFir() {
        return fir;
    }

    public void setFir(String fir) {
        this.fir = fir;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
