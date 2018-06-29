package com.organOld.service.service.impl;

import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.repository.HomeDao;
import com.organOld.dao.repository.HomeOldmanDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.HomeOldmanRequest;
import com.organOld.service.contract.HomeRequest;
import com.organOld.service.model.HomeModel;
import com.organOld.service.model.HomeOldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.HomeService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService{

    @Autowired
    CommonService commonService;
    @Autowired
    HomeDao homeDao;
    @Autowired
    HomeOldmanDao homeOldmanDao;

    @Override
    public String getByPage(HomeRequest homeRequest, BTableRequest bTableRequest) {
        Page<Home> page=commonService.getPage(bTableRequest,"home");
        Home home= Wrappers.homeWrapper.unwrap(homeRequest);
        page.setEntity(home);
        List<HomeModel> homeModelList=homeDao.getByPage(page).stream().map(Wrappers.homeWrapper::wrap).collect(Collectors.toList());
        Long size=homeDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,homeModelList);
    }

    @Override
    public String getManByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"home_man");
        HomeOldman homeOldman= Wrappers.homeOldmanWrapper.unwrap(homeOldmanRequest);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getByPage(page).stream().map(Wrappers.homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

}
