package com.organOld.service.model;

import java.util.List;

public class OldmanKeyHandleModel {
    private int id;
    private List<String> organIds;
    private List<String> homeFirTypes;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getOrganIds() {
        return organIds;
    }

    public void setOrganIds(List<String> organIds) {
        this.organIds = organIds;
    }

    public List<String> getHomeFirTypes() {
        return homeFirTypes;
    }

    public void setHomeFirTypes(List<String> homeFirTypes) {
        this.homeFirTypes = homeFirTypes;
    }
}
