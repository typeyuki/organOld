package com.organOld.service.service;


import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.LabelRequest;
import com.organOld.service.contract.LabelRuleRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.model.LabelAllRuleModel;
import com.organOld.service.model.LabelRuleModel;

import javax.servlet.http.HttpSession;

/**
 * Created by netlab606 on 2018/6/7.
 */
public interface LabelService {
    String getByPage(LabelRequest labelRequest, BTableRequest bTableRequest, HttpSession session);

    String getBindManByPage(OldmanRequest labelBindManRequest, BTableRequest bTableRequest, int labelId, String type);

    String getNoSelectManDataByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest, int labelId);

    LabelAllRuleModel getLabelRule();

    LabelRuleModel getLabelRuleById(int labelId);

    void save(LabelRuleRequest labelRuleRequest);
}
