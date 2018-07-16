package com.organOld.service.wrapper;

import com.organOld.dao.entity.label.LabelMan;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.LabelManRequest;
import com.organOld.service.enumModel.SexEnum;
import com.organOld.service.model.LabelManModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.util.Tool;

/**
 * Created by netlab606 on 2018/7/8.
 */
public class LabelManWrapper implements Wrapper<LabelMan,LabelManModel,LabelManRequest> {

    @Override
    public LabelManModel wrap(LabelMan labelMan) {
        LabelManModel labelManModel=new LabelManModel();
        labelManModel.setId(labelMan.getId());
        labelManModel.setIsImplement(labelMan.getIsImplement());
        labelManModel.setOldmanId(labelMan.getOldman().getId());
        labelManModel.setOldmanName(labelMan.getOldman().getName());
        labelManModel.setAge(CommonService.birthdayToAge(labelMan.getOldman().getBirthday()));
        labelManModel.setCensus(labelMan.getOldman().getCensus());
        labelManModel.setPoliticalStatus(labelMan.getOldman().getPoliticalStatus());
        labelManModel.setSex(SexEnum.getValue(labelMan.getOldman().getSex()));
        labelManModel.setdName(labelMan.getOldman().getXq().getDistrictName());
        labelManModel.setjName(labelMan.getOldman().getXq().getJwName());
        labelManModel.setxName(labelMan.getOldman().getXq().getName());
        labelManModel.setTime(Tool.dateToString(labelMan.getOldman().getTime(), TimeConstant.DATA_FORMAT_YMD));

        return labelManModel;
    }

    @Override
    public LabelMan unwrap(LabelManRequest labelManRequest) {
        LabelMan labelMan=new LabelMan();
        labelMan.setLabelId(labelManRequest.getLabelId());
        return labelMan;
    }
}
