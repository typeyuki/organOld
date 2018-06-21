package com.organOld.service.service.impl;

import com.organOld.dao.entity.SysUser;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.OrganOldmanDao;
import com.organOld.dao.repository.UserDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OrganOldmanRequest;
import com.organOld.service.contract.OrganRequest;
import com.organOld.service.model.OrganModel;
import com.organOld.service.model.OrganOldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OrganService;
import com.organOld.service.service.UserService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganServiceImpl implements OrganService{

    @Autowired
    OrganDao organDao;
    @Autowired
    CommonService commonService;
    @Autowired
    OrganOldmanDao organOldmanDao;
    @Autowired
    UserService userService;


    @Override
    public String getByPage(OrganRequest organRequest, BTableRequest bTableRequest) {
        Page<Organ> page=commonService.getPage(bTableRequest,"organ");
        Organ organ= Wrappers.organWrapper.unwrap(organRequest);
        page.setEntity(organ);
        List<OrganModel> organModelList=organDao.getByPage(page).stream().map(Wrappers.organWrapper::wrap).collect(Collectors.toList());
        Long size=organDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organModelList);
    }

    @Override
    public String getManByPage(BTableRequest bTableRequest, OrganOldmanRequest organOrganManRequest) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"organ_man");
        OrganOldman organOldman= Wrappers.organOldmanWrapper.unwrap(organOrganManRequest);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public OrganModel getBySession(HttpSession httpSession) {
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username=userDetails.getUsername();
        OrganModel organModel=Wrappers.organWrapper.wrap(organDao.getByUsername(username));
        return organModel;
    }

    @Override
    public OrganModel getById(int organId) {
        return null;
    }


}
