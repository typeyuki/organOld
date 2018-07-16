package com.organOld.service.service;


import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.label.LabelSec;
import com.organOld.service.contract.*;
import com.organOld.service.model.LabelAllRuleModel;
import com.organOld.service.model.LabelFilterModel;
import com.organOld.service.model.LabelRuleModel;

import javax.servlet.http.HttpSession;

/**
 * Created by netlab606 on 2018/6/7.
 */
public interface LabelService {
    String getByPage(LabelRequest labelRequest, BTableRequest bTableRequest);

    String getBindManByPage(LabelManRequest labelManRequest, BTableRequest bTableRequest);

    String getNoSelectManDataByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest, int labelId);

    LabelAllRuleModel getLabelRule();

    LabelRuleModel getLabelRuleById(int labelId);

    void saveRule(LabelRuleRequest labelRuleRequest);

    Result getByOldmanId(int oldmanId);

    void save(Label label);

    Result saveLabelMan(int labelId, int[] oldmanIds);

    Result implement(int id);

    String getFeedbackByPage(LabelFeedbackRequest labelFeedbackRequest, BTableRequest bTableRequest);

    void feedbackAdd(LabelFeedbackAddRequest labelFeedbackAddRequest);

    Result getFeedbackByLabelId(int labelId);

    Result checkCanChange(int labelId);

    Result getSecLabelByFirType(int firType);
    LabelFilterModel getFilterLabelRule(int i);

    String getTypeByPage(int index, LabelTypeRequest labelTypeRequest, BTableRequest bTableRequest);

    void addOrUpdateFirType(AutoValue firType, String type);

    void addOrUpdateSecType(LabelSec labelSec, String type);
}
