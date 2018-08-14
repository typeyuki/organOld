package com.organOld.service.model;

import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.organ.Organ;

import java.util.List;

/**
 * Created by netlab606 on 2018/8/14.
 */
public class HomeOldmanAddInfo {
    private List<Organ> organList;
    private List<Home> homeList;

    public List<Organ> getOrganList() {
        return organList;
    }

    public void setOrganList(List<Organ> organList) {
        this.organList = organList;
    }

    public List<Home> getHomeList() {
        return homeList;
    }

    public void setHomeList(List<Home> homeList) {
        this.homeList = homeList;
    }
}
