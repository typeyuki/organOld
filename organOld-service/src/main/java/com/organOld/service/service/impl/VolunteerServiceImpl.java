package com.organOld.service.service.impl;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.volunteer.Volunteer;
import com.organOld.dao.repository.VolunteerDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.VolunteerRequest;
import com.organOld.service.model.OldmanModel;
import com.organOld.service.model.VolunteerModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.VolunteerService;
import com.organOld.service.wrapper.VolunteerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolunteerServiceImpl implements VolunteerService{

    @Autowired
    CommonService commonService;
    @Autowired
    VolunteerDao volunteerDao;
    @Autowired
    VolunteerWrapper volunteerWrapper;

    @Override
    public String getByPage(VolunteerRequest volunteerRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<Volunteer> page=commonService.getPage(bTableRequest,"volunteer");
        Volunteer volunteer= volunteerWrapper.unwrap(volunteerRequest);
        commonService.checkIsOrgan(volunteer);
        page.setEntity(volunteer);
        List<VolunteerModel> volunteerModelList=volunteerDao.getByPage(page).stream().map(volunteerWrapper::wrap).collect(Collectors.toList());
        Long size=volunteerDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,volunteerModelList);
    }
}
