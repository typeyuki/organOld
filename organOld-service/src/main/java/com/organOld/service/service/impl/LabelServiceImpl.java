package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Message;
import com.organOld.dao.entity.home.Chx;
import com.organOld.dao.entity.label.*;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.service.enumModel.MessageTypeEnum;
import com.organOld.service.model.*;
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
    @Autowired
    LabelManDao labelManDao;
    @Autowired
    LabelFeedbackDao labelFeedbackDao;
    @Autowired
    UserDao userDao;
    @Autowired
    MessageDao messageDao;


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
    public String getBindManByPage(LabelManRequest labelManRequest, BTableRequest bTableRequest) {
        Page<LabelMan> page=commonService.getPage(bTableRequest,"label_man");
        LabelMan labelMan=Wrappers.labelManWrapper.unwrap(labelManRequest);
        commonService.checkIsOrgan(labelMan);
        page.setEntity(labelMan);
        List<LabelManModel> labelManModelList= labelDao.getBindManByPage(page).stream().map(Wrappers.labelManWrapper::wrap).collect(Collectors.toList());
        Long size=labelDao.getBindManSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,labelManModelList);
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
        commonService.checkIsOrgan(oldman);
        page.setEntity(oldman);
        List<OldmanModel> oldmanModelList=labelDao.getNoSelectManDataByPage(page,labelId).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
        Long size=labelDao.getNoSelectManDataSizeByPage(page,labelId);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanModelList);
    }

    @Override
    public LabelAllRuleModel getLabelRule() {
        List<Integer> typeList=commonService.getAutoValueTypes("label");
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);
        Integer organId=commonService.getIdBySession();
        List<Organ> jwList=organDao.getSimpleByType(2, organId);

        List<Chx> chxList=chxDao.getSimple();

        LabelAllRuleModel labelRuleModel=Wrappers.labelWrapper.wrapLabelRule(autoValueList,jwList,chxList);

        return labelRuleModel;
    }

    @Override
    public LabelRuleModel getLabelRuleById(int labelId) {
        return Wrappers.labelWrapper.wrapSingleRule(labelDao.getLabelRuleByLid(labelId));
    }

    @Override
    @Transactional
    public void saveRule(LabelRuleRequest labelRuleRequest) {
        LabelRule labelRule=Wrappers.labelWrapper.unwrapLabelRule(labelRuleRequest);
        labelDao.saveLabelRule(labelRule);
//        LabelRule labelRule=labelDao.getLabelRuleByLid(labelId);
        labelDao.deleteLableManByLabelId(labelRule.getLabelId());
        LabelRuleToDBSelectMan labelRuleToDB=getLabelRuleToDB(labelRule);
        List<LabelMan> labelManList= labelDao.getRuleManIds(labelRuleToDB);
        labelManList.stream().forEach(r->r.setLabelId(labelRule.getLabelId()));
        labelManDao.saveAll(labelManList);

        labelFeedbackDao.deleteByLabelId(labelRule.getLabelId());

        //通知 居委
        Label label=labelDao.getById(labelRule.getLabelId());
        commonService.informJwAndPq("您有新的人员绑定标签："+label.getName());

    }



    @Override
    public Result getByOldmanId(int oldmanId) {
        List<LabelManInfoModel> labels=labelDao.getManLabelByOldmanId(oldmanId).stream().map(Wrappers.labelWrapper::wrapManInfo).collect(Collectors.toList());

        //规则制定标签
//        List<LabelRule> labelRuleList=labelDao.getLabelRules();
//        for(LabelRule labelRule:labelRuleList){
//            LabelRuleToDBSelectMan labelRuleToDB=getLabelRuleToDB(labelRule);
//            List<Integer> oldmanIdList = labelDao.getRuleManIds(labelRuleToDB);
//            if(oldmanIdList.contains(oldmanId)){
//                labelNames.add(labelDao.getLabelNameByLabelRuleId(labelRule.getId()));
//            }
//        }

        return new Result(true,labels);
    }

    /**
     * 如果是人员绑定标签 则直接通知  居委会
     * 如果是规则制定标签  则提交规则时再通知 居委会
     * @param label
     */
    @Override
    @Transactional
    public void save(Label label) {
        label.setOrganId(0);
        commonService.checkIsOrgan(label);
        labelDao.save(label);
        if(label.getType()==2){
            //规则制定
            labelDao.addLabelRule(label.getId());
        }else{
            //人员绑定
            commonService.informJwAndPq("您有新的人员绑定标签："+label.getName());
        }
    }

    @Override
    public Result saveLabelMan(int labelId, int[] oldmanIds) {
        Result result;
        labelDao.saveLabelMan(labelId,oldmanIds);
        result=new Result(true);
        return result;
    }

    @Override
    public Result implement(int id) {
        Result result;
        labelDao.implement(id);
        result=new Result(true);
        return result;
    }

    @Override
    public String getFeedbackByPage(LabelFeedbackRequest labelFeedbackRequest, BTableRequest bTableRequest) {
        Page<LabelFeedback> page=commonService.getPage(bTableRequest,"label_feedback");
        LabelFeedback labelFeedback= Wrappers.labelWrapper.unwrapFeedback(labelFeedbackRequest);
        commonService.checkIsOrgan(labelFeedback);
        Label label=labelDao.getById(labelFeedback.getLabelId());
        labelFeedback.setLabelOrganId(label.getOrganId());
        page.setEntity(labelFeedback);
        List<LabelFeedbackModel> labelFeedbackModelList=labelFeedbackDao.getByPage(page).stream().map(Wrappers.labelWrapper::wrapFeedback).collect(Collectors.toList());
        Long size=labelFeedbackDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,labelFeedbackModelList);
    }

    @Override
    public void feedbackAdd(LabelFeedbackAddRequest labelFeedbackAddRequest) {
        LabelFeedback labelFeedback=Wrappers.labelWrapper.unwrapFeedbackAdd(labelFeedbackAddRequest);
        labelFeedback.setOrganId(commonService.getIdBySession());
        labelFeedbackDao.save(labelFeedback);
    }

    @Override
    public Result getFeedbackByLabelId(int labelId) {
        Integer organId=commonService.getIdBySession();
        return new Result(true,Wrappers.labelWrapper.wrapFeedback(labelFeedbackDao.getByLabelIdOrganId(labelId,organId)));
    }


    @Override
    public Result checkCanChange(int labelId) {
        Label label=labelDao.getById(labelId);
        Integer organId=commonService.getIdBySession();
        if(organId==label.getOrganId()){
            return new Result(true);
        }
        return new Result(false);
    }
}
