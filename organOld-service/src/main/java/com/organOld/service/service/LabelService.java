package com.organOld.service.service;


import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.LabelRequest;
import com.organOld.service.contract.OldmanRequest;

/**
 * Created by netlab606 on 2018/6/7.
 */
public interface LabelService {
    String getByPage(LabelRequest labelRequest, BTableRequest bTableRequest);

    String getBindManByPage(OldmanRequest labelBindManRequest, BTableRequest bTableRequest, int labelId, String type);

    String getNoSelectManDataByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest, int labelId);
}
