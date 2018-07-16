package com.organOld.service.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.enumModel.*;
import com.organOld.service.model.LabelAllRuleModel;
import com.organOld.service.model.OldmanAddInfoModel;
import com.organOld.service.model.OldmanModel;
import com.organOld.service.model.OrganQueryIntegralModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OldmanWrapper implements Wrapper<Oldman,OldmanModel,OldmanRequest> {

    @Autowired
    CommonService commonService;

    @Override
    public OldmanModel wrap(Oldman oldman) {
        OldmanModel oldmanModel=new OldmanModel();
        oldmanModel.setId(oldman.getId());
        oldmanModel.setName(oldman.getName());
        if(oldman.getLouNum()==null || oldman.getLouNum()==0)
            oldmanModel.setLouNum("");
        else
            oldmanModel.setLouNum(oldman.getLouNum()+"");
        if(oldman.getBirthday()!=null)
            oldmanModel.setAge(CommonService.birthdayToAge(oldman.getBirthday()));
        oldmanModel.setSex(SexEnum.getValue(oldman.getSex()));
        oldmanModel.setCensus(oldman.getCensus()==null?"":oldman.getCensus());
        oldmanModel.setPoliticalStatus(oldman.getPoliticalStatus()==null?"":oldman.getPoliticalStatus());
        if(oldman.getTime()!=null)
            oldmanModel.setTime(Tool.dateToString(oldman.getTime(), TimeConstant.DATA_FORMAT_YMD));
        oldmanModel.setPid(oldman.getPid());
        oldmanModel.setAddress(oldman.getAddress()==null?"":oldman.getAddress());
        oldmanModel.setPhone(oldman.getPhone());
        oldmanModel.setjName(oldman.getXq().getJwName());
        oldmanModel.setdName(oldman.getXq().getDistrictName());
        oldmanModel.setxName(oldman.getXq().getName());
        oldmanModel.setPoliticalStatus(oldman.getPoliticalStatus());
        if(oldman.getOldStatus()!=null && oldman.getOldStatus()!=0)
            oldmanModel.setOldStatus(OldStatusEnum.getValue(oldman.getOldStatus()));

        oldmanModel.setLabelManInfoModelList(oldman.getLabelManList().stream().map(Wrappers.labelWrapper::wrapManInfo).collect(Collectors.toList()));
        return oldmanModel;
    }

    @Override
    public Oldman unwrap(OldmanRequest oldmanRequest) {
        Oldman oldman=new Oldman();
        BeanUtils.copyProperties(oldmanRequest,oldman);
        if(oldmanRequest.getAgeStart()!=null && !oldmanRequest.getAgeStart().equals(""))
            oldman.setBirthdayEnd(commonService.AgeTobirthday(Integer.parseInt(oldmanRequest.getAgeStart())));
        if(oldmanRequest.getAgeEnd()!=null && !oldmanRequest.getAgeEnd().equals(""))
            oldman.setBirthdayStart(commonService.AgeTobirthday(Integer.parseInt(oldmanRequest.getAgeEnd())));

        return oldman;
    }


    public OldmanAddInfoModel wrapAddInfo(List<AutoValue> autoValueList, List<Organ> jwList, List<HealthSelect> healthSelectList) {
        OldmanAddInfoModel oldmanAddInfoModel=new OldmanAddInfoModel();
        oldmanAddInfoModel.setOrgan(jwList);


        Map<Integer,String> sexMap=new HashMap<>();
        sexMap.put(SexEnum.MAN.getIndex(),SexEnum.MAN.getName());
        sexMap.put(SexEnum.WOMAN.getIndex(),SexEnum.WOMAN.getName());
        oldmanAddInfoModel.setSex(sexMap);

        Map<Integer,String> oldStatus=new HashMap<>();
        oldStatus.put(OldStatusEnum.SQ.getIndex(),OldStatusEnum.SQ.getName());
        oldStatus.put(OldStatusEnum.JG.getIndex(),OldStatusEnum.JG.getName());
        oldStatus.put(OldStatusEnum.JJ.getIndex(),OldStatusEnum.JJ.getName());
        oldStatus.put(OldStatusEnum.SJ.getIndex(),OldStatusEnum.SJ.getName());
        oldmanAddInfoModel.setOldStatus(oldStatus);

        for(AutoValue autoValue:autoValueList){
            if (autoValue.getType()== AutoValueEnum.HJ.getIndex()){
                oldmanAddInfoModel.getCensus().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.ZZMM.getIndex()){
                oldmanAddInfoModel.getPoliticalStatuses().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.SZ.getIndex()){
                oldmanAddInfoModel.getIntelligence().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.SL.getIndex()){
                oldmanAddInfoModel.getEyesight().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.JJJG.getIndex()){
                oldmanAddInfoModel.getFamily().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.JJTJ.getIndex()){
                oldmanAddInfoModel.getEconomic().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.PQ.getIndex()){
                oldmanAddInfoModel.getDistrict().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.XQ.getIndex()){
                oldmanAddInfoModel.getXq().add(autoValue);
            }
        }

        for (HealthSelect healthSelect:healthSelectList){
            if (healthSelect.getFirType()== HealthEnum.MB.getIndex()){
                oldmanAddInfoModel.getMb().add(healthSelect);
            }
            if (healthSelect.getFirType()== HealthEnum.SN.getIndex()){
                oldmanAddInfoModel.getSn().add(healthSelect);
            }
            if (healthSelect.getFirType()== HealthEnum.YW.getIndex()){
                oldmanAddInfoModel.getYwfy().add(healthSelect);
            }
        }

        return oldmanAddInfoModel;
    }

    public OrganQueryIntegralModel wrapInregral(Oldman oldman) {
        if(oldman!=null) {
            OrganQueryIntegralModel organQueryIntegralModel = new OrganQueryIntegralModel();
            organQueryIntegralModel.setIntegral(oldman.getIntegral());
            organQueryIntegralModel.setOldmanName(oldman.getName());
            return organQueryIntegralModel;
        }
        return null;
    }
}
