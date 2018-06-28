package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.HomeRequest;

public interface HomeService {
    String getByPage(HomeRequest homeRequest, BTableRequest bTableRequest);
}
