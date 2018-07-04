package com.organOld.service.wrapper;


import com.organOld.dao.entity.oldman.HealthAdd;
import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.OldmanHealth;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.enumModel.HealthEnum;
import com.organOld.service.model.OldmanHealthModel;
import com.organOld.service.contract.*;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;

public class OldmanHealthWrapper implements Wrapper<OldmanHealth,OldmanHealthModel,OldmanHealthRequest> {

    @Override
    public OldmanHealthModel wrap(OldmanHealth oldmanHealth) {

        OldmanHealthModel oldmanHealthModel=new OldmanHealthModel();
        oldmanHealthModel.setId(oldmanHealth.getId());
        oldmanHealthModel.setOldmanId(oldmanHealth.getOldman().getId());
        oldmanHealthModel.setName(oldmanHealth.getOldman().getName());
        oldmanHealthModel.setBloodType(oldmanHealth.getBloodType());
        oldmanHealthModel.setIntelligence(oldmanHealth.getIntelligence()==null?"":oldmanHealth.getIntelligence());
        oldmanHealthModel.setEyesight(oldmanHealth.getEyesight()==null?"":oldmanHealth.getEyesight());
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

        return oldmanHealthModel;
    }

    @Override
    public OldmanHealth unwrap(OldmanHealthRequest oldmanHealthRequest) {
        OldmanHealth oldmanHealth=new OldmanHealth();
        BeanUtils.copyProperties(oldmanHealthRequest,oldmanHealth);//类型要一致  不能int 和Integer
        return oldmanHealth;
    }


}
