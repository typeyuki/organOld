package com.organOld.service.contract;

public class UserRequest {
    private Integer disable;
    private String search;
    private Integer role;

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
