package com.organOld.service.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.oldman.*;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.util.bean.ExportOldman;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.enumModel.*;
import com.organOld.service.model.*;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.impl.AutoValueServiceImpl;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OldmanWrapper implements Wrapper<Oldman,OldmanModel,OldmanRequest> {

    @Autowired
    CommonService commonService;
    @Autowired
    AutoValueService autoValueService;

    /**
     * 用于填充 auto_value 的数据
     */
    List<String> method=new ArrayList<>();
    Map<Integer,String> map=new HashMap<>();

    List<String> methodInfo=new ArrayList<>();
    Map<Integer,String> mapInfo=new HashMap<>();


    @Override
    public OldmanModel wrap(Oldman oldman) {
        OldmanModel oldmanModel=new OldmanModel();
        oldmanModel.setId(oldman.getId()+"");
        oldmanModel.setName(oldman.getName());
        if(oldman.getBirthday()!=null)
            oldmanModel.setAge(CommonService.birthdayToAge(oldman.getBirthday()));
        oldmanModel.setSex(SexEnum.getValue(oldman.getSex()));
        if(oldman.getOldStatus()!=null && oldman.getOldStatus()!=0)
            oldmanModel.setOldStatus(OldStatusEnum.getValue(oldman.getOldStatus()));
//        if(oldman.getLabelManList()!=null && oldman.getLabelManList().size()>0)
//            oldmanModel.setLabelManInfoModelList(oldman.getLabelManList().stream().map(Wrappers.labelWrapper::wrapManInfo).collect(Collectors.toList()));
        Xq xq=autoValueService.getXqById(oldman.getXqId());
        if(xq!=null) {
            oldmanModel.setjName(xq.getJwName());
            oldmanModel.setxName(xq.getName());
            oldmanModel.setdName(xq.getDistrictName());
        }

        if(method.size()==0){
            method.add("Family");
            method.add("Economic");
            method.add("Census");
            method.add("PoliticalStatus");
        }
        if(map.size()==0){
            List<Integer> autoIds=commonService.getAutoValueTypes("oldman");
            List<AutoValue> autoValueList=autoValueService.getByTypeList(autoIds);
            autoValueList.forEach(s->map.put(s.getId(),s.getValue()));
        }
        commonService.fillAutoValue(oldman,oldmanModel,method,map);
        return oldmanModel;
    }



    @Override
    public Oldman unwrap(OldmanRequest oldmanRequest) {
        Oldman oldman=new Oldman();
        BeanUtils.copyProperties(oldmanRequest,oldman);
//        if(oldmanRequest.getSqzwArray()!=null && oldmanRequest.getSqzwArray().length>0){
//            for(String s:oldmanRequest.getSqzwArray()){
//                oldman.getSqzwArray().add("s"+s+"s");
//            }
//        }

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
            if (autoValue.getType()== AutoValueEnum.SQZW.getIndex()){
                oldmanAddInfoModel.getSqzw().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.ZC.getIndex()){
                oldmanAddInfoModel.getZc().add(autoValue);
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
            if (autoValue.getType()== AutoValueEnum.JTLB.getIndex()){
                oldmanAddInfoModel.getFamilyType().add(autoValue);
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

    public OldmanIntegral unwrapIntegral(OldmanIntegralRequest oldmanIntegralRequest) {
        OldmanIntegral oldmanIntegral=new OldmanIntegral();
        BeanUtils.copyProperties(oldmanIntegralRequest,oldmanIntegral);
        return oldmanIntegral;
    }

    public OldmanIntegralModel wrapIntegral(Oldman oldman) {
        OldmanIntegralModel oldmanIntegralModel=new OldmanIntegralModel();
        oldmanIntegralModel.setOldmanId(oldman.getId());
        oldmanIntegralModel.setIntegral(oldman.getIntegral());
        oldmanIntegralModel.setOldmanName(oldman.getName());
        return oldmanIntegralModel;
    }

    public ExportOldmanModel wrapAll(ExportOldman exportOldman){
        ExportOldmanModel exportOldmanModel=new ExportOldmanModel();
        BeanUtils.copyProperties(exportOldman,exportOldmanModel);
        exportOldmanModel.setId(exportOldman.getId()+"");
        if(exportOldman.getLinkman()!=null)
            exportOldmanModel.setLink(exportOldman.getLinkman().getName()+"-"+exportOldman.getLinkman().getPhone()+"-"+exportOldman.getLinkman().getRelation());
        exportOldmanModel.setSex(SexEnum.getValue(Integer.parseInt(exportOldman.getSex())));

        if(exportOldman.getHealthAdd()!=null &&exportOldman.getHealthAdd().size()>0){
            for(HealthAdd healthAdd:exportOldman.getHealthAdd()){
                if(healthAdd.getType()== HealthEnum.EXZL.getIndex()) {
                    exportOldman.setExzl(exportOldman.getExzl()+","+healthAdd.getDesc());
                }else if(healthAdd.getType()==HealthEnum.GZ.getIndex()){
                    exportOldman.setGz(exportOldman.getGz()+","+healthAdd.getDesc());
                }else{
                    exportOldman.setCj(exportOldman.getCj()+","+healthAdd.getDesc());
                }
            }
            if(exportOldman.getExzl().length()>0)
                exportOldmanModel.setExzl(exportOldman.getExzl().substring(1));
            if(exportOldman.getGz().length()>0)
                exportOldmanModel.setGz(exportOldman.getGz().substring(1));
            if(exportOldmanModel.getCj().length()>0)
                exportOldmanModel.setCj(exportOldman.getCj().substring(1));
        }
        if(exportOldman.getHealthSelect()!=null &&exportOldman.getHealthSelect().size()>0){
            for(HealthSelect healthSelect:exportOldman.getHealthSelect()){
                if(healthSelect.getFirType()== HealthEnum.MB.getIndex()) {
                    exportOldman.setMb(exportOldman.getExzl()+","+healthSelect.getSecTypeName());
                }else if(healthSelect.getFirType()==HealthEnum.SN.getIndex()){
                    exportOldman.setSn(exportOldman.getSn()+","+healthSelect.getSecTypeName());
                }else{
                    exportOldman.setYwfy(exportOldman.getYwfy()+","+healthSelect.getSecTypeName());
                }
            }
            if(exportOldman.getMb().length()>0)
                exportOldmanModel.setMb(exportOldman.getMb().substring(1));
            if(exportOldman.getSn().length()>0)
                exportOldmanModel.setSn(exportOldman.getSn().substring(1));
            if(exportOldman.getYwfy().length()>0)
                exportOldmanModel.setYwfy(exportOldman.getYwfy().substring(1));
        }

        Xq xq=autoValueService.getXqById(exportOldman.getXqId());
        if(xq!=null) {
            exportOldmanModel.setjName(xq.getJwName());
            exportOldmanModel.setpName(xq.getDistrictName());
            exportOldmanModel.setxName(xq.getName());
        }
        if(methodInfo.size()==0){
            methodInfo.add("Family");
            methodInfo.add("Economic");
            methodInfo.add("Census");
            methodInfo.add("Zc");
            methodInfo.add("Sqzw");
            methodInfo.add("FamilyType");
            methodInfo.add("PoliticalStatus");
        }
        if(mapInfo.size()==0){
            List<Integer> autoIds=commonService.getAutoValueTypes("oldmanInfo");
            List<AutoValue> autoValueList=autoValueService.getByTypeList(autoIds);
            autoValueList.forEach(s->mapInfo.put(s.getId(),s.getValue()));
        }
        commonService.fillAutoValue(exportOldman,exportOldmanModel,methodInfo,mapInfo);

        return  exportOldmanModel;
    }

    public Oldman unwrapAll(ExportTableThRequest exportTableThRequest) {
        Oldman oldman=new Oldman();
        BeanUtils.copyProperties(exportTableThRequest,oldman);
        return oldman;
    }

    public HealthSelectInfoModel wrapHealthSelectInfo(List<AutoValue> autoValueList, List<HealthSelect> healthSelectList) {
        HealthSelectInfoModel healthSelectInfoModel=new HealthSelectInfoModel();
        for(AutoValue autoValue:autoValueList){
            if (autoValue.getType()== AutoValueEnum.SZ.getIndex()){
                healthSelectInfoModel.getIntelligence().add(autoValue);
            }
            if (autoValue.getType()== AutoValueEnum.SL.getIndex()){
                healthSelectInfoModel.getEyesight().add(autoValue);
            }
        }

        for (HealthSelect healthSelect:healthSelectList){
            if (healthSelect.getFirType()== HealthEnum.MB.getIndex()){
                healthSelectInfoModel.getMb().add(healthSelect);
            }
            if (healthSelect.getFirType()== HealthEnum.SN.getIndex()){
                healthSelectInfoModel.getSn().add(healthSelect);
            }
            if (healthSelect.getFirType()== HealthEnum.YW.getIndex()){
                healthSelectInfoModel.getYwfy().add(healthSelect);
            }
        }
        return healthSelectInfoModel;
    }

    public OldmanModel wrapInfo(Oldman oldman) {
        OldmanModel oldmanModel=new OldmanModel();
        BeanUtils.copyProperties(oldman,oldmanModel);
        oldmanModel.setId(oldman.getId()+"");
        oldmanModel.setLouNum(oldman.getLouNum()+"");
        if(oldman.getBirthday()!=null)
            oldmanModel.setAge(CommonService.birthdayToAge(oldman.getBirthday()));
        oldmanModel.setSex(SexEnum.getValue(oldman.getSex()));
        if(oldman.getOldStatus()!=null && oldman.getOldStatus()!=0)
            oldmanModel.setOldStatus(OldStatusEnum.getValue(oldman.getOldStatus()));
        Xq xq=autoValueService.getXqById(oldman.getXqId());
        if(xq!=null) {
            oldmanModel.setxName(xq.getName());
            oldmanModel.setjName(xq.getJwName());
            oldmanModel.setdName(xq.getDistrictName());
        }

        if(methodInfo.size()==0){
            methodInfo.add("Family");
            methodInfo.add("Economic");
            methodInfo.add("Census");
            methodInfo.add("Zc");
            methodInfo.add("Sqzw");
            methodInfo.add("FamilyType");
            methodInfo.add("PoliticalStatus");
        }
        if(mapInfo.size()==0){
            List<Integer> autoIds=commonService.getAutoValueTypes("oldmanInfo");
            List<AutoValue> autoValueList=autoValueService.getByTypeList(autoIds);
            autoValueList.forEach(s->mapInfo.put(s.getId(),s.getValue()));
        }
        commonService.fillAutoValue(oldman,oldmanModel,methodInfo,mapInfo);
        return oldmanModel;
    }
}
