package com.organOld.service.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.home.Chx;
import com.organOld.dao.entity.label.*;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.enumModel.*;
import com.organOld.service.model.*;
import com.organOld.service.service.CommonService;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class LabelWrapper implements Wrapper<Label,LabelModel,LabelRequest> {

    @Override
    public LabelModel wrap(Label label) {
        LabelModel labelModel=new LabelModel();
        labelModel.setContent(label.getContent());
        labelModel.setFir(label.getLabelSec().getFirName());
        labelModel.setSec(label.getLabelSec().getSecName());
        labelModel.setId(label.getId());
        labelModel.setName(label.getName());
        labelModel.setRule(label.getRule());
        labelModel.setWh(label.getWh());
        if(label.getOrgan()!=null)
        labelModel.setOrganName(label.getOrgan().getName());
        labelModel.setTime(Tool.dateToString(label.getTime(), TimeConstant.DATA_FORMAT_YMD));
        labelModel.setStart(Tool.dateToString(label.getStart(), TimeConstant.DATA_FORMAT_YMD));
        labelModel.setEnd(Tool.dateToString(label.getEnd(), TimeConstant.DATA_FORMAT_YMD));
        labelModel.setIsFeedback(label.getIsFeedback());
        return labelModel;
    }

    @Override
    public Label unwrap(LabelRequest labelRequest) {
        Label label=new Label();
        BeanUtils.copyProperties(labelRequest,label);
        return label;
    }

    public LabelAllRuleModel wrapLabelRule(List<AutoValue> autoValueList, List<Organ> organList, List<Chx> chxList){
        LabelAllRuleModel labelRuleModel=new LabelAllRuleModel();
        labelRuleModel.setOrgan(organList);
        labelRuleModel.setChx(chxList);

        Map<Integer,String> sexMap=new HashMap<>();
        sexMap.put(SexEnum.MAN.getIndex(),SexEnum.MAN.getName());
        sexMap.put(SexEnum.WOMAN.getIndex(),SexEnum.WOMAN.getName());
        labelRuleModel.setSex(sexMap);

        Map<Integer,String> isKey=new HashMap<>();
        isKey.put(IsEnum.NO.getIndex(),IsEnum.NO.getName());
        isKey.put(IsEnum.YES.getIndex(),IsEnum.YES.getName());
        labelRuleModel.setIsKey(isKey);

        Map<Integer,String> isHealth=new HashMap<>();
        isHealth.put(HealthEnum.CJQK.getIndex(),HealthEnum.CJQK.getName());
        isHealth.put(HealthEnum.GZ.getIndex(),HealthEnum.GZ.getName());
        isHealth.put(HealthEnum.EXZL.getIndex(),HealthEnum.EXZL.getName());
        isHealth.put(HealthEnum.SN.getIndex(),HealthEnum.SN.getName());
        isHealth.put(HealthEnum.YW.getIndex(),HealthEnum.YW.getName());
        isHealth.put(HealthEnum.MB.getIndex(),HealthEnum.MB.getName());
        labelRuleModel.setIsHealth(isHealth);

        Map<Integer,String> oldStatus=new HashMap<>();
        oldStatus.put(OldStatusEnum.SQ.getIndex(),OldStatusEnum.SQ.getName());
        oldStatus.put(OldStatusEnum.JG.getIndex(),OldStatusEnum.JG.getName());
        oldStatus.put(OldStatusEnum.JJ.getIndex(),OldStatusEnum.JJ.getName());
        oldStatus.put(OldStatusEnum.SJ.getIndex(),OldStatusEnum.SJ.getName());
        labelRuleModel.setOldStatus(oldStatus);

        for(AutoValue autoValue:autoValueList){
            if (autoValue.getType()== AutoValueEnum.HJ.getIndex()){
                labelRuleModel.getCensus().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.ZZMM.getIndex()){
                labelRuleModel.getPoliticalStatuses().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.SZ.getIndex()){
                labelRuleModel.getIntelligence().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.SL.getIndex()){
                labelRuleModel.getEyesight().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.JJJG.getIndex()){
                labelRuleModel.getFamily().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.JJTJ.getIndex()){
                labelRuleModel.getEconomic().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.PQ.getIndex()){
                labelRuleModel.getDistrict().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.ZC.getIndex()){
                labelRuleModel.getZc().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.SQZW.getIndex()){
                labelRuleModel.getSqzw().add(autoValue);
            }
        }

        return labelRuleModel;
    }


    public LabelRuleModel wrapSingleRule(LabelRule labelRule){
        LabelRuleModel labelRuleModel=new LabelRuleModel();
        labelRuleModel.setSex(labelRule.getSex());
        labelRuleModel.setAgeEnd(labelRule.getAgeEnd());
        labelRuleModel.setAgeStart(labelRule.getAgeStart());
        labelRuleModel.setIsKey(labelRule.getIsKey());

        if(labelRule.getZcs()!=null && !labelRule.getZcs().equals(""))
            labelRuleModel.setZcs(Arrays.asList(labelRule.getZcs().split("#")));
        if(labelRule.getSqzws()!=null && !labelRule.getSqzws().equals(""))
            labelRuleModel.setSqzws(Arrays.asList(labelRule.getSqzws().split("#")));
        if(labelRule.getCensuses()!=null && !labelRule.getCensuses().equals(""))
            labelRuleModel.setCensuses(Arrays.asList(labelRule.getCensuses().split("#")));
        if(labelRule.getPoliticalStatuses()!=null && !labelRule.getPoliticalStatuses().equals(""))
            labelRuleModel.setPoliticalStatuses(Arrays.asList(labelRule.getPoliticalStatuses().split("#")));
        if(labelRule.getDistrictIds()!=null && !labelRule.getDistrictIds().equals(""))
            labelRuleModel.setDistrictIds(Arrays.asList(labelRule.getDistrictIds().split("#")));
        if(labelRule.getIntelligences()!=null && !labelRule.getIntelligences().equals(""))
            labelRuleModel.setIntelligences(Arrays.asList(labelRule.getIntelligences().split("#")));
        if(labelRule.getEyesights()!=null && !labelRule.getEyesights().equals(""))
            labelRuleModel.setEyesights(Arrays.asList(labelRule.getEyesights().split("#")));
        if(labelRule.getIsHealths()!=null && !labelRule.getIsHealths().equals(""))
            labelRuleModel.setIsHealths(Arrays.asList(labelRule.getIsHealths().split("#")));
        if(labelRule.getEconomics()!=null && !labelRule.getEconomics().equals(""))
            labelRuleModel.setEconomics(Arrays.asList(labelRule.getEconomics().split("#")));
        if(labelRule.getFamilies()!=null && !labelRule.getFamilies().equals(""))
            labelRuleModel.setFamilies(Arrays.asList(labelRule.getFamilies().split("#")));
        if(labelRule.getChxs()!=null && !labelRule.getChxs().equals(""))
            labelRuleModel.setChxs(Arrays.asList(labelRule.getChxs().split("#")));
        if(labelRule.getOldStatuses()!=null && !labelRule.getOldStatuses().equals(""))
            labelRuleModel.setOldStatuses(Arrays.asList(labelRule.getOldStatuses().split("#")));
        if(labelRule.getJwIds()!=null && !labelRule.getJwIds().equals(""))
            labelRuleModel.setJwIds(Arrays.asList(labelRule.getJwIds().split("#")));

        return labelRuleModel;
    }

    public LabelRule unwrapLabelRule(LabelRuleRequest labelRuleRequest) {
        LabelRule labelRule=new LabelRule();
        labelRule.setLabelId(labelRuleRequest.getLabelId());
        if(labelRuleRequest.getAgeEnd()!=null && !labelRuleRequest.getAgeEnd().equals(""))
            labelRule.setAgeEnd(Integer.parseInt(labelRuleRequest.getAgeEnd()));
        if(labelRuleRequest.getAgeStart()!=null && !labelRuleRequest.getAgeStart().equals(""))
            labelRule.setAgeStart(Integer.parseInt(labelRuleRequest.getAgeStart()));
        if(labelRuleRequest.getSex()!=null && !labelRuleRequest.getSex().equals(""))
            labelRule.setSex(Integer.parseInt(labelRuleRequest.getSex()));
        if(labelRuleRequest.getIsKey()!=null && !labelRuleRequest.getIsKey().equals(""))
            labelRule.setIsKey(Integer.parseInt(labelRuleRequest.getIsKey()));


        if(labelRuleRequest.getZc()!=null && labelRuleRequest.getZc().length>0)
            labelRule.setZcs(String.join("#", labelRuleRequest.getZc()));
        if(labelRuleRequest.getSqzw()!=null && labelRuleRequest.getSqzw().length>0)
            labelRule.setSqzws(String.join("#", labelRuleRequest.getSqzw()));
        if(labelRuleRequest.getCensus()!=null && labelRuleRequest.getCensus().length>0)
            labelRule.setCensuses(String.join("#", labelRuleRequest.getCensus()));
        if(labelRuleRequest.getPoliticalStatus()!=null && labelRuleRequest.getPoliticalStatus().length>0)
            labelRule.setPoliticalStatuses(String.join("#", labelRuleRequest.getPoliticalStatus()));
        if(labelRuleRequest.getDistrict()!=null && labelRuleRequest.getDistrict().length>0)
            labelRule.setDistrictIds(String.join("#", labelRuleRequest.getDistrict()));
        if(labelRuleRequest.getIntelligence()!=null && labelRuleRequest.getIntelligence().length>0)
            labelRule.setIntelligences(String.join("#", labelRuleRequest.getIntelligence()));
        if(labelRuleRequest.getEyesight()!=null && labelRuleRequest.getEyesight().length>0)
            labelRule.setEyesights(String.join("#", labelRuleRequest.getEyesight()));
        if(labelRuleRequest.getIsHealth()!=null && labelRuleRequest.getIsHealth().length>0)
            labelRule.setIsHealths(String.join("#", labelRuleRequest.getIsHealth()));
        if(labelRuleRequest.getEconomic()!=null && labelRuleRequest.getEconomic().length>0)
            labelRule.setEconomics(String.join("#", labelRuleRequest.getEconomic()));
        if(labelRuleRequest.getFamily()!=null && labelRuleRequest.getFamily().length>0)
            labelRule.setFamilies(String.join("#", labelRuleRequest.getFamily()));
        if(labelRuleRequest.getChx()!=null && labelRuleRequest.getChx().length>0)
            labelRule.setChxs(String.join("#", labelRuleRequest.getChx()));
        if(labelRuleRequest.getOldStatus()!=null && labelRuleRequest.getOldStatus().length>0)
            labelRule.setOldStatuses(String.join("#", labelRuleRequest.getOldStatus()));
        if(labelRuleRequest.getOldStatus()!=null && labelRuleRequest.getOldStatus().length>0)
            labelRule.setOldStatuses(String.join("#", labelRuleRequest.getOldStatus()));
        if(labelRuleRequest.getOrgan()!=null && labelRuleRequest.getOrgan().length>0)
            labelRule.setJwIds(String.join("#", labelRuleRequest.getOrgan()));

        return labelRule;
    }

    public LabelManInfoModel wrapManInfo(LabelMan labelMan) {
        LabelManInfoModel labelManInfoModel=new LabelManInfoModel();
        labelManInfoModel.setLabelName(labelMan.getLabelName());
        labelManInfoModel.setIsImplement(labelMan.getIsImplement()==0?"未落实":"已落实");
        return labelManInfoModel;
    }

    public LabelFeedback unwrapFeedback(LabelFeedbackRequest labelFeedbackRequest) {
        LabelFeedback labelFeedback=new LabelFeedback();
        labelFeedback.setLabelId(labelFeedbackRequest.getLabelId());
        return labelFeedback;
    }

    public LabelFeedbackModel wrapFeedback(LabelFeedback labelFeedback) {
        LabelFeedbackModel labelFeedbackModel=new LabelFeedbackModel();
        if(labelFeedback.getOrgan()!=null){
            labelFeedbackModel.setDistrictName(labelFeedback.getOrgan().getDistrictName());
            labelFeedbackModel.setOrganId(labelFeedback.getOrgan().getId());
            labelFeedbackModel.setOrganName(labelFeedback.getOrgan().getName());
        }
        if(labelFeedback.getIsFinish()!=null)
        labelFeedbackModel.setIsFinish(labelFeedback.getIsFinish()==0?"未完成":"已完成");
        labelFeedbackModel.setRemark(labelFeedback.getRemark());
        return labelFeedbackModel;
    }

    public LabelFeedback unwrapFeedbackAdd(LabelFeedbackAddRequest labelFeedbackAddRequest) {
        LabelFeedback labelFeedback=new LabelFeedback();
        labelFeedback.setIsFinish(labelFeedbackAddRequest.getIsFinish());
        labelFeedback.setLabelId(labelFeedbackAddRequest.getLabelId());
        labelFeedback.setRemark(labelFeedbackAddRequest.getRemark());
        return labelFeedback;
    }

    public LabelFilterModel wrapFilterLabelRule(List<AutoValue> autoValueList, List<Organ> jwList, List<Chx> chxList, List<Organ> belongOrgan, List<LabelSec> labelSecList) {
        LabelFilterModel labelFilterModel=new LabelFilterModel();
        labelFilterModel.setOrgan(jwList);
        labelFilterModel.setChx(chxList);

        Map<Integer,String> sexMap=new HashMap<>();
        sexMap.put(SexEnum.MAN.getIndex(),SexEnum.MAN.getName());
        sexMap.put(SexEnum.WOMAN.getIndex(),SexEnum.WOMAN.getName());
        labelFilterModel.setSex(sexMap);

        Map<Integer,String> isKey=new HashMap<>();
        isKey.put(IsEnum.NO.getIndex(),IsEnum.NO.getName());
        isKey.put(IsEnum.YES.getIndex(),IsEnum.YES.getName());
        labelFilterModel.setIsKey(isKey);

        Map<Integer,String> isHealth=new HashMap<>();
        isHealth.put(HealthEnum.CJQK.getIndex(),HealthEnum.CJQK.getName());
        isHealth.put(HealthEnum.GZ.getIndex(),HealthEnum.GZ.getName());
        isHealth.put(HealthEnum.EXZL.getIndex(),HealthEnum.EXZL.getName());
        isHealth.put(HealthEnum.SN.getIndex(),HealthEnum.SN.getName());
        isHealth.put(HealthEnum.YW.getIndex(),HealthEnum.YW.getName());
        isHealth.put(HealthEnum.MB.getIndex(),HealthEnum.MB.getName());
        labelFilterModel.setIsHealth(isHealth);

        Map<Integer,String> oldStatus=new HashMap<>();
        oldStatus.put(OldStatusEnum.SQ.getIndex(),OldStatusEnum.SQ.getName());
        oldStatus.put(OldStatusEnum.JG.getIndex(),OldStatusEnum.JG.getName());
        oldStatus.put(OldStatusEnum.JJ.getIndex(),OldStatusEnum.JJ.getName());
        oldStatus.put(OldStatusEnum.SJ.getIndex(),OldStatusEnum.SJ.getName());
        labelFilterModel.setOldStatus(oldStatus);

        for(AutoValue autoValue:autoValueList){
            if (autoValue.getType()== AutoValueEnum.HJ.getIndex()){
                labelFilterModel.getCensus().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.ZZMM.getIndex()){
                labelFilterModel.getPoliticalStatuses().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.SZ.getIndex()){
                labelFilterModel.getIntelligence().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.SL.getIndex()){
                labelFilterModel.getEyesight().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.JJJG.getIndex()){
                labelFilterModel.getFamily().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.JJTJ.getIndex()){
                labelFilterModel.getEconomic().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.PQ.getIndex()){
                labelFilterModel.getDistrict().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.YJBQ.getIndex()){
                labelFilterModel.getFirLabel().add(autoValue);
            }
        }

        labelFilterModel.setBelongOrgan(belongOrgan);
        labelFilterModel.setSecLabel(labelSecList);

        return labelFilterModel;
    }

    public LabelSec unwrapType(LabelTypeRequest labelTypeRequest) {
        LabelSec labelSec=new LabelSec();
        BeanUtils.copyProperties(labelTypeRequest,labelSec);
        return labelSec;
    }

    public LabelSecModel wrapType(LabelSec labelSec) {
        LabelSecModel labelSecModel=new LabelSecModel();
        labelSecModel.setId(labelSec.getId());
        labelSecModel.setFirName(labelSec.getFirName());
        labelSecModel.setSecName(labelSec.getSecName());
        labelSecModel.setTime(Tool.dateToString(labelSec.getTime(),TimeConstant.DATA_FORMAT_YMD));
        return labelSecModel;
    }
}
