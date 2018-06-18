package com.organOld.service.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Chx;
import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.label.LabelRule;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.enumModel.*;
import com.organOld.service.model.LabelModel;
import com.organOld.service.model.LabelAllRuleModel;
import com.organOld.service.model.LabelRuleModel;
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
        if(label.getOrgan()!=null)
        labelModel.setOrganName(label.getOrgan().getName());
        labelModel.setTime(Tool.dateToString(label.getTime(), TimeConstant.DATA_FORMAT_YMD));
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
        }

        return labelRuleModel;
    }


    public LabelRuleModel wrapSingleRule(LabelRule labelRule){
        LabelRuleModel labelRuleModel=new LabelRuleModel();
        labelRuleModel.setSex(labelRule.getSex());
        labelRuleModel.setAgeEnd(labelRule.getAgeEnd());
        labelRuleModel.setAgeStart(labelRule.getAgeStart());
        labelRuleModel.setIsKey(labelRule.getIsKey());

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
        if(labelRule.getEconmics()!=null && !labelRule.getEconmics().equals(""))
            labelRuleModel.setEconmics(Arrays.asList(labelRule.getEconmics().split("#")));
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
        labelRule.setId(labelRuleRequest.getLabelId());
        labelRule.setAgeEnd(labelRuleRequest.getAgeEnd());
        labelRule.setAgeStart(labelRuleRequest.getAgeStart());
        labelRule.setSex(labelRuleRequest.getSex());
        labelRule.setIsKey(labelRuleRequest.getIsKey());

        if(labelRuleRequest.getCensuse()!=null && labelRuleRequest.getCensuse().length>0)
            labelRule.setCensuses(String.join("#", labelRuleRequest.getCensuse()));
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
        if(labelRuleRequest.getEconmic()!=null && labelRuleRequest.getEconmic().length>0)
            labelRule.setEconmics(String.join("#", labelRuleRequest.getEconmic()));
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
}
