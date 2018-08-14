package com.organOld.service.service;

import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.HomeOldmanRequest;
import com.organOld.service.contract.HomeRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.model.HomeOldmanAddInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface HomeService {
    String getByPage(HomeRequest homeRequest, BTableRequest bTableRequest);

    String getManByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest);

    Result importManExcel(MultipartFile file, String type) throws IOException;


    Result getById(int id, int firType);

    void addOrUpdate(Home home, String type);

    void delByIds(String[] ids, int type);

    String getManAllByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest);

    HomeOldman getOldmanById(Integer id);

    void delByOldmanIds(String[] ids);

    void updateOldman(HomeOldman homeOldman);

    void addOldman(HomeOldman homeOldman);

    HomeOldmanAddInfo getAddInfo();
}
