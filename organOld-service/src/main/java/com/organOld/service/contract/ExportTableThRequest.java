package com.organOld.service.contract;

import java.util.List;

public class ExportTableThRequest {
    private String type;
    private List<String> th;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTh() {
        return th;
    }

    public void setTh(List<String> th) {
        this.th = th;
    }
}
