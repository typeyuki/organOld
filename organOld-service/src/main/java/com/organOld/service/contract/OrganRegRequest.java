package com.organOld.service.contract;

import org.springframework.web.multipart.MultipartFile;

public class OrganRegRequest {
    private Integer organTypeId;
    private String name;
    private String intro;
    private String work;
    private String serviceTime;
    private String address;
    private String orgPhone;
    private String webUrl;
    private MultipartFile pic;
    private Integer num;
    private String districtId;//所属片区名称 如果有的话
    private String[] auth;

    private String phone;
    private String email;


    public String[] getAuth() {
        return auth;
    }

    public void setAuth(String[] auth) {
        this.auth = auth;
    }

    public Integer getOrganTypeId() {
        return organTypeId;
    }

    public void setOrganTypeId(Integer organTypeId) {
        this.organTypeId = organTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public MultipartFile getPic() {
        return pic;
    }

    public void setPic(MultipartFile pic) {
        this.pic = pic;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
