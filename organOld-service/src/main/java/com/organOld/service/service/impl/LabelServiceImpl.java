package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.home.Chx;
import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.label.LabelRule;
import com.organOld.dao.entity.label.LabelRuleToDBSelectMan;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.repository.ChxDao;
import com.organOld.dao.repository.LabelDao;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.util.Page;
import com.organOld.service.model.LabelModel;
import com.organOld.service.model.LabelAllRuleModel;
import com.organOld.service.model.LabelRuleModel;
import com.organOld.service.model.OldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.LabelService;
import com.organOld.service.wrapper.Wrappers;
import com.organOld.service.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    public String getByPage(LabelRequest labelRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<Label> page=commonService.getPage(bTableRequest,"label");
        Label label= Wrappers.labelWrapper.unwrap(labelRequest);
        commonService.checkIsOrgan(label);
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
            LabelRuleToDBSelectMan labelRuleToDB=getLabelRuleToDB(labelRule);
            oldmanModelList = labelDao.getRuleManByPage(page, labelRuleToDB).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
            size=labelDao.getRuleManSizeByPage(page,labelRuleToDB);
        }
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanModelList);
    }

    private LabelRuleToDBSelectMan getLabelRuleToDB(LabelRule labelRule) {
        LabelRuleToDBSelectMan labelRuleToDB=new LabelRuleToDBSelectMan();
        labelRuleToDB.setBirStart(commonService.AgeTobirthday(labelRule.getAgeEnd()));
        labelRuleToDB.setBirEnd(commonService.AgeTobirthday(labelRule.getAgeStart()));
        if(!StringUtils.isEmpty(labelRule.getCensuses()))
            labelRuleToDB.setCensuses(Arrays.asList(labelRule.getCensuses().split("#")));
        if(!StringUtils.isEmpty(labelRule.getDistrictIds()))
            labelRuleToDB.setDistrictIds(Arrays.asList(labelRule.getDistrictIds().split("#")));
        if(!StringUtils.isEmpty(labelRule.getJwIds()))
            labelRuleToDB.setJwIds(Arrays.asList(labelRule.getJwIds().split("#")));
        if(!StringUtils.isEmpty(labelRule.getEyesights()))
            labelRuleToDB.setEyesights(Arrays.asList(labelRule.getEyesights().split("#")));
        if(!StringUtils.isEmpty(labelRule.getIntelligences()))
            labelRuleToDB.setIntelligences(Arrays.asList(labelRule.getIntelligences().split("#")));
        if(!StringUtils.isEmpty(labelRule.getPoliticalStatuses()))
            labelRuleToDB.setPoliticalStatuses(Arrays.asList(labelRule.getPoliticalStatuses().split("#")));
        if(!StringUtils.isEmpty(labelRule.getEconomics()))
            labelRuleToDB.setEconomics(Arrays.asList(labelRule.getEconomics().split("#")));
        if(!StringUtils.isEmpty(labelRule.getFamilies()))
            labelRuleToDB.setFamilies(Arrays.asList(labelRule.getFamilies().split("#")));
        if(!StringUtils.isEmpty(labelRule.getIsHealths()))
            labelRuleToDB.setIsHealths(Arrays.asList(labelRule.getIsHealths().split("#")));
        if(!StringUtils.isEmpty(labelRule.getOldStatuses()))
            labelRuleToDB.setOldStatuses(Arrays.asList(labelRule.getOldStatuses().split("#")));
        if(!StringUtils.isEmpty(labelRule.getChxs()))
            labelRuleToDB.setChxs(Arrays.asList(labelRule.getChxs().split("#")));
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
    public LabelAllRuleModel getLabelRule() {
        List<Integer> typeList=commonService.getAutoValueTypes("label");
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);

        List<Organ> jwList=organDao.getSimpleByType(2);

        List<Chx> chxList=chxDao.getSimple();

        LabelAllRuleModel labelRuleModel=Wrappers.labelWrapper.wrapLabelRule(autoValueList,jwList,chxList);

        return labelRuleModel;
    }

    @Override
    public LabelRuleModel getLabelRuleById(int labelId) {
        return Wrappers.labelWrapper.wrapSingleRule(labelDao.getLabelRuleByLid(labelId));
    }

    @Override
    public void save(LabelRuleRequest labelRuleRequest) {
        LabelRule labelRule=Wrappers.labelWrapper.unwrapLabelRule(labelRuleRequest);
        labelDao.saveLabelRule(labelRule);
    }

    @Override
    public Result getByOldmanId(int oldmanId) {
        List<String> labelNames=new ArrayList<>();
        //人员绑定标签
        labelDao.getManLabelByOldmanId(oldmanId).forEach(r->labelNames.add(r.getName()));

        //规则制定标签
        List<LabelRule> labelRuleList=labelDao.getLabelRules();
        for(LabelRule labelRule:labelRuleList){
            LabelRuleToDBSelectMan labelRuleToDB=getLabelRuleToDB(labelRule);
            List<Integer> oldmanIdList = labelDao.getRuleManIds(labelRuleToDB);
            if(oldmanIdList.contains(oldmanId)){
                labelNames.add(labelDao.getLabelNameByLabelRuleId(labelRule.getId()));
            }
        }

        return new Result(true,labelNames);
    }

    @Override
    @Transactional
    public void save(Label label, HttpSession session) {
        label.setOrganId(0);
        commonService.checkIsOrgan(label);
        labelDao.save(label);
        if(label.getType()==2){
            //规则制定
            labelDao.addLabelRule(label.getId());
        }
    }
}
