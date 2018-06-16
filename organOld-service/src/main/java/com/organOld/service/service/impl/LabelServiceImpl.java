package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Chx;
import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.label.LabelRule;
import com.organOld.dao.entity.label.LabelRuleToDB;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.repository.ChxDao;
import com.organOld.dao.repository.LabelDao;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.util.Page;
import com.organOld.service.model.LabelModel;
import com.organOld.service.model.LabelRuleModel;
import com.organOld.service.model.OldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.LabelService;
import com.organOld.service.wrapper.Wrappers;
import com.organOld.service.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * Created by netlab606 on 2018/6/7.
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    CommonService commonService;
    @Autowired
    LabelDao labelDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    OrganDao organDao;
    @Autowired
    ChxDao chxDao;

    @Override
    public String getByPage(LabelRequest labelRequest, BTableRequest bTableRequest) {
        Page<Label> page=commonService.getPage(bTableRequest,"label");
        Label label= Wrappers.labelWrapper.unwrap(labelRequest);
        page.setEntity(label);
        List<LabelModel> labelList=labelDao.getByPage(page).stream().map(Wrappers.labelWrapper::wrap).collect(Collectors.toList());
        Long size=labelDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,labelList);
    }

    @Override
    public String getBindManByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest, int labelId, String type) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= Wrappers.oldmanWrapper.unwrap(oldmanRequest);
        page.setEntity(oldman);
        List<OldmanModel> oldmanModelList;
        Long size;
        if(type.equals("bind")) {
            oldmanModelList = labelDao.getBindManByPage(page, labelId).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
            size=labelDao.getBindManSizeByPage(page,labelId);
        }else{
            LabelRule labelRule=labelDao.getLabelRuleByLid(labelId);
            LabelRuleToDB labelRuleToDB=getLabelRuleToDB(labelRule);
            oldmanModelList = labelDao.getRuleManByPage(page, labelRuleToDB).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
            size=labelDao.getRuleManSizeByPage(page,labelRuleToDB);
        }
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanModelList);
    }

    private LabelRuleToDB getLabelRuleToDB(LabelRule labelRule) {
        LabelRuleToDB labelRuleToDB=new LabelRuleToDB();
        labelRuleToDB.setBirStart(commonService.AgeTobirthday(labelRule.getAgeEnd()));
        labelRuleToDB.setBirEnd(commonService.AgeTobirthday(labelRule.getAgeStart()));
        if(!StringUtils.isEmpty(labelRule.getCensuses()))
            labelRuleToDB.setCensuses(Arrays.asList(labelRule.getCensuses().split("#")));
        if(!StringUtils.isEmpty(labelRule.getDistrictIds()))
            labelRuleToDB.setDistrictIds(Arrays.asList(labelRule.getDistrictIds().split("#")));
        if(!StringUtils.isEmpty(labelRule.getEyesights()))
            labelRuleToDB.setEyesights(Arrays.asList(labelRule.getEyesights().split("#")));
        if(!StringUtils.isEmpty(labelRule.getIntelligences()))
            labelRuleToDB.setIntelligences(Arrays.asList(labelRule.getIntelligences().split("#")));
        if(!StringUtils.isEmpty(labelRule.getPoliticalStatuses()))
            labelRuleToDB.setPoliticalStatuses(Arrays.asList(labelRule.getPoliticalStatuses().split("#")));
        if(!StringUtils.isEmpty(labelRule.getEconmicIndexs()))
            labelRuleToDB.setEconmicIndexs(Arrays.asList(labelRule.getEconmicIndexs().split("#")));
        if(!StringUtils.isEmpty(labelRule.getFamilyIndexs()))
            labelRuleToDB.setFamilyIndexs(Arrays.asList(labelRule.getFamilyIndexs().split("#")));
        if(!StringUtils.isEmpty(labelRule.getIsHealths()))
            labelRuleToDB.setIsHealths(Arrays.asList(labelRule.getIsHealths().split("#")));
        labelRuleToDB.setSex(labelRule.getSex());
        labelRuleToDB.setIsKey(labelRule.getIsKey());
        return labelRuleToDB;
    }

    @Override
    public String getNoSelectManDataByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest, int labelId) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= Wrappers.oldmanWrapper.unwrap(oldmanRequest);
        page.setEntity(oldman);
        List<OldmanModel> oldmanModelList=labelDao.getNoSelectManDataByPage(page,labelId).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
        Long size=labelDao.getNoSelectManDataSizeByPage(page,labelId);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanModelList);
    }

    @Override
    public LabelRuleModel getLabelRule() {
        List<Integer> typeList=commonService.getAutoValueTypes("label");
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);

        List<Organ> jwList=organDao.getSimpleByType(2);

        List<Chx> chxList=chxDao.getSimple();

        LabelRuleModel labelRuleModel=Wrappers.labelWrapper.wrapLabelRule(autoValueList,jwList,chxList);

        return labelRuleModel;
    }
}
