package com.organOld.service.wrapper;


import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.HealthAdd;
import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanHealth;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.enumModel.HealthEnum;
import com.organOld.service.model.HealthSelectModel;
import com.organOld.service.model.OldmanHealthModel;
import com.organOld.service.contract.*;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.CommonService;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OldmanHealthWrapper implements Wrapper<OldmanHealth,OldmanHealthModel,OldmanHealthRequest> {

    @Autowired
    CommonService commonService;
    @Autowired
    AutoValueService autoValueService;

    /**
     * 用于填充 auto_value 的数据
     */
    List<String> method=new ArrayList<>();
    Map<Integer,String> map=new HashMap<>();

    @Override
    public OldmanHealthModel wrap(OldmanHealth oldmanHealth) {

        OldmanHealthModel oldmanHealthModel=new OldmanHealthModel();
        oldmanHealthModel.setId(oldmanHealth.getId()+"");
        if(oldmanHealth.getOldman()!=null) {
            oldmanHealthModel.setOldmanId(oldmanHealth.getOldman().getId());
            oldmanHealthModel.setName(oldmanHealth.getOldman().getName());
        }
        oldmanHealthModel.setBloodType(oldmanHealth.getBloodType());
        //TODO  选取所有表格中最新的一个时间  暂时还没实现
        oldmanHealthModel.setTime(Tool.dateToString(oldmanHealth.getTime(), TimeConstant.DATA_FORMAT_YMD));

        if(oldmanHealth.getHealthAdd()!=null && oldmanHealth.getHealthAdd().size()>0){
            for(HealthAdd healthAdd:oldmanHealth.getHealthAdd()){
                HealthAdd add=new HealthAdd();
                add.setId(healthAdd.getId());
                add.setDesc(healthAdd.getDesc());
                if(healthAdd.getType()== HealthEnum.EXZL.getIndex()) {
                    oldmanHealthModel.getAddExzl().add(add);
                }else if(healthAdd.getType()==HealthEnum.GZ.getIndex()){
                    oldmanHealthModel.getAddGz().add(add);
                }else{
                    oldmanHealthModel.getAddCj().add(add);
                }
            }
        }
        if(oldmanHealth.getHealthSelect()!=null && oldmanHealth.getHealthSelect().size()>0){
            for(HealthSelect healthSelect:oldmanHealth.getHealthSelect()){
                HealthSelect select=new HealthSelect();
                select.setId(healthSelect.getId());
                select.setSecTypeName(healthSelect.getSecTypeName());
                if(healthSelect.getFirType()== HealthEnum.MB.getIndex()) {
                    oldmanHealthModel.getSelectMb().add(select);
                }else if(healthSelect.getFirType()==HealthEnum.SN.getIndex()){
                    oldmanHealthModel.getSelectSn().add(select);
                }else{
                    oldmanHealthModel.getSelectYwfy().add(select);
                }
            }
        }

        if(method.size()==0){
            method.add("Eyesight");
            method.add("Intelligence");
        }
        if(map.size()==0){
            List<Integer> autoIds=commonService.getAutoValueTypes("health_add");
            List<AutoValue> autoValueList=autoValueService.getByTypeList(autoIds);
            autoValueList.forEach(s->map.put(s.getId(),s.getValue()));
        }
        commonService.fillAutoValue(oldmanHealth,oldmanHealthModel,method,map);
        return oldmanHealthModel;
    }

    @Override
    public OldmanHealth unwrap(OldmanHealthRequest oldmanHealthRequest) {
        OldmanHealth oldmanHealth=new OldmanHealth();
        Oldman oldman=new Oldman();
        oldman.setId(oldmanHealthRequest.getOldmanId());
        oldmanHealth.setOldman(oldman);
        BeanUtils.copyProperties(oldmanHealthRequest,oldmanHealth);//类型要一致  不能int 和Integer
        return oldmanHealth;
    }


    public HealthSelect unwrapHealthSelect(HealthSelectRequest healthSelectRequest) {
        HealthSelect healthSelect=new HealthSelect();
        BeanUtils.copyProperties(healthSelectRequest,healthSelect);
        return healthSelect;
    }

    public HealthSelectModel wrapHealthSelect(HealthSelect healthSelect) {
        HealthSelectModel healthSelectModel=new HealthSelectModel();
        healthSelectModel.setId(healthSelect.getId());
        healthSelectModel.setSecName(healthSelect.getSecTypeName());
        healthSelectModel.setTime(Tool.dateToString(healthSelect.getTime(),TimeConstant.DATA_FORMAT_YMD));
        healthSelectModel.setFirName(HealthEnum.getValue(healthSelect.getFirType()));
        return healthSelectModel;
    }
}
