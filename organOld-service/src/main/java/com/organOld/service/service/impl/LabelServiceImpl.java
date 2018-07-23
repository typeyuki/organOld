package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.home.Chx;
import com.organOld.dao.entity.label.*;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.model.*;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.LabelService;
import com.organOld.service.util.Tool;
import com.organOld.service.wrapper.Wrappers;
import com.organOld.service.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
    @Autowired
    LabelSecDao labelSecDao;

    @Override
    public String getByPage(LabelRequest labelRequest, BTableRequest bTableRequest) {
        Page<Label> page=commonService.getPage(bTableRequest,"label");
        Label label= Wrappers.labelWrapper.unwrap(labelRequest);
        commonService.checkIsOrgan(label);
        page.setEntity(label);
        List<LabelModel> labelList=labelDao.getByPage(page).stream().map(Wrappers.labelWrapper::wrap).collect(Collectors.toList());
        Long size=labelDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,labelList);
    }

    @Override
    public String getTypeByPage(int index, LabelTypeRequest labelTypeRequest, BTableRequest bTableRequest) {
        if(index==1){
            List<AutoValue> autoValueList=autoValueDao.getByType(AutoValueEnum.YJBQ.getIndex());
            autoValueList.forEach(s->s.setTimeFormat(Tool.dateToString(s.getTime(), TimeConstant.DATA_FORMAT_YMD)));
            Long size=(long)autoValueList.size();
            return commonService.tableReturn(bTableRequest.getsEcho(),size,autoValueList);
        }else{
            Page<LabelSec> page=commonService.getPage(bTableRequest,"label_type");
            LabelSec labelSec=Wrappers.labelWrapper.unwrapType(labelTypeRequest);
            page.setEntity(labelSec);
            List<LabelSecModel> labelList=labelSecDao.getByPage(page).stream().map(Wrappers.labelWrapper::wrapType).collect(Collectors.toList());
            Long size=labelSecDao.getSizeByPage(page);
            return commonService.tableReturn(bTableRequest.getsEcho(),size,labelList);
        }
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

        String content="您有新的规则制定标签："+label.getName()+"" +
                "<br>有效时间："+Tool.dateToString(label.getStart(),TimeConstant.DATA_FORMAT_YMD)+"-"+Tool.dateToString(label.getEnd(),TimeConstant.DATA_FORMAT_YMD)+"" +
                "<br><button class='btn btn-primary' onclick=newPageBefore("+label.getId()+","+label.getName()+",'/oldman/label/rule/"+label.getId()+"/man')>查看人员</button>";
        commonService.informJwAndPq(content);

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
            String content="您有新的人员绑定标签："+label.getName()+"" +
                    "<br>有效时间："+Tool.dateToString(label.getStart(),TimeConstant.DATA_FORMAT_YMD)+"-"+Tool.dateToString(label.getEnd(),TimeConstant.DATA_FORMAT_YMD)+"" +
                    "<br><button class='btn btn-primary' onclick=newPageBefore("+label.getId()+","+label.getName()+",'/oldman/label/bind/"+label.getId()+"/man')>查看人员</button>";
            commonService.informJwAndPq(content);
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
    public Result implement(LabelMan labelMan) {
        Result result;
        labelManDao.implement(labelMan);
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
        labelFeedbackModelList.forEach(s->addProcess(s,labelFeedback.getLabelId()));
        return commonService.tableReturn(bTableRequest.getsEcho(),size,labelFeedbackModelList);
    }

    private void addProcess(LabelFeedbackModel labelFeedbackModel,Integer labelId) {
        labelFeedbackModel.setLabelManImplNum(labelManDao.getLabelManImplNum(labelFeedbackModel.getOrganId(),labelId));

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
        }else if(organId==null || organId==0){
            return new Result(true);
        }
        return new Result(false);
    }


    @Override
    public Result getSecLabelByFirType(int firType) {
        List<LabelSec> labelSecList=labelSecDao.getByFirType(firType);
        return new Result(true,labelSecList);
    }

    //1 是 人员绑定  2是规则制定
    @Override
    public LabelFilterModel getFilterLabelRule(int i) {
        LabelFilterModel labelFilterModel;
        List<Integer> typeIds = new ArrayList<>();
        typeIds.add(33);
        typeIds.add(2);
        List<Organ> belongOrgan = organDao.getByTypes(typeIds);
        List<LabelSec> labelSecList = labelSecDao.getByFirType(0);
        if(i==2) {
            List<Integer> typeList = commonService.getAutoValueTypes("labelFilter");
            List<AutoValue> autoValueList = autoValueDao.getByTypeList(typeList);
            Integer organId = commonService.getIdBySession();
            List<Organ> jwList = organDao.getSimpleByType(2, organId);
            List<Chx> chxList = chxDao.getSimple();
            labelFilterModel = Wrappers.labelWrapper.wrapFilterLabelRule(autoValueList, jwList, chxList, belongOrgan, labelSecList);
        }else{
            labelFilterModel=new LabelFilterModel();
            labelFilterModel.setBelongOrgan(belongOrgan);
            labelFilterModel.setSecLabel(labelSecList);
            labelFilterModel.setFirLabel(autoValueDao.getByType(9));
        }
        return labelFilterModel;
    }

    @Override
    public void addOrUpdateFirType(AutoValue firType, String type) {
        if(type.equals("add"))
            autoValueDao.save(firType);
        else
            autoValueDao.updateById(firType);
    }


    @Override
    public void addOrUpdateSecType(LabelSec labelSec, String type) {
        if(type.equals("add"))
            labelSecDao.save(labelSec);
        else
            labelSecDao.updateById(labelSec);
    }

    @Override
    public Result getById(int id) {
        Label label=labelDao.getById(id);
        label.setStartTime(Tool.dateToString(label.getStart(), TimeConstant.DATA_FORMAT_YMD));
        label.setEndTime(Tool.dateToString(label.getEnd(), TimeConstant.DATA_FORMAT_YMD));
        return new Result(true,label);
    }

    @Override
    public void updateById(Label label) {
        label.setStart(Tool.stringToDate(label.getStartTime()));
        label.setEnd(Tool.stringToDate(label.getEndTime()));
        labelDao.updateById(label);
    }

    @Override
    @Transactional
    public void delByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        labelDao.delByIds(id);
        labelManDao.delByLabelIds(id);
        labelFeedbackDao.delByLabelIds(id);
    }

    @Override
    public void delManByOldmanIds(String[] ids, int labelId) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        labelManDao.delByOldmanIds(id,labelId);
    }
}
