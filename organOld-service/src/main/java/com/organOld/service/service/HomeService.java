package com.organOld.service.service;

import com.organOld.dao.entity.home.Home;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.HomeOldmanRequest;
import com.organOld.service.contract.HomeRequest;
import com.organOld.service.contract.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface HomeService {
    String getByPage(HomeRequest homeRequest, BTableRequest bTableRequest);

    String getManByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest);

    Result importManExcel(MultipartFile file) throws IOException;

    void add(Home home);
}
