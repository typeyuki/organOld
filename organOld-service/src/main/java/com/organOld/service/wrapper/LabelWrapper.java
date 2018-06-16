package com.organOld.service.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Chx;
import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.enumModel.*;
import com.organOld.service.model.LabelModel;
import com.organOld.service.model.LabelRuleModel;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public LabelRuleModel wrapLabelRule(List<AutoValue> autoValueList, List<Organ> organList, List<Chx> chxList){
        LabelRuleModel labelRuleModel=new LabelRuleModel();
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
        isHealth.put(LabelRuleIsHealthsEnum.CJQK.getIndex(),LabelRuleIsHealthsEnum.CJQK.getName());
        isHealth.put(LabelRuleIsHealthsEnum.GZ.getIndex(),LabelRuleIsHealthsEnum.GZ.getName());
        isHealth.put(LabelRuleIsHealthsEnum.EXZL.getIndex(),LabelRuleIsHealthsEnum.EXZL.getName());
        isHealth.put(LabelRuleIsHealthsEnum.SN.getIndex(),LabelRuleIsHealthsEnum.SN.getName());
        isHealth.put(LabelRuleIsHealthsEnum.YW.getIndex(),LabelRuleIsHealthsEnum.YW.getName());
        isHealth.put(LabelRuleIsHealthsEnum.MB.getIndex(),LabelRuleIsHealthsEnum.MB.getName());
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

}
