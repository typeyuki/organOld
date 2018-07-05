package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.VolunteerRequest;

import javax.servlet.http.HttpSession;

public interface VolunteerService {
    String getByPage(VolunteerRequest volunteerRequest, BTableRequest bTableRequest, HttpSession session);
}
