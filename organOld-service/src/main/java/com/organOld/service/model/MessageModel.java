package com.organOld.service.model;

import com.organOld.dao.entity.organ.Organ;

public class MessageModel {
    private String idAndIsRead;
    private String typeName;
    private String content;
    private Organ organ;
    private String time;

    public String getIdAndIsRead() {
        return idAndIsRead;
    }

    public void setIdAndIsRead(String idAndIsRead) {
        this.idAndIsRead = idAndIsRead;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }
}
