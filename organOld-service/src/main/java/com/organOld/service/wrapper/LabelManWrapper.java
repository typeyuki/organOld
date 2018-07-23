package com.organOld.service.wrapper;

import com.organOld.dao.entity.label.LabelMan;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.LabelManRequest;
import com.organOld.service.enumModel.SexEnum;
import com.organOld.service.model.LabelManModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by netlab606 on 2018/7/8.
 */
public class LabelManWrapper implements Wrapper<LabelMan,LabelManModel,LabelManRequest> {

    @Autowired
    CommonService commonService;


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
        labelManModel.setRemark(labelMan.getRemark());
        return labelManModel;
    }

    @Override
    public LabelMan unwrap(LabelManRequest labelManRequest) {
        LabelMan labelMan=new LabelMan();
        Oldman oldman=new Oldman();
        BeanUtils.copyProperties(labelManRequest,oldman);
        if(labelManRequest.getAgeStart()!=null && !labelManRequest.getAgeStart().equals(""))
            oldman.setBirthdayEnd(commonService.AgeTobirthday(Integer.parseInt(labelManRequest.getAgeStart())));
        if(labelManRequest.getAgeEnd()!=null && !labelManRequest.getAgeEnd().equals(""))
            oldman.setBirthdayStart(commonService.AgeTobirthday(Integer.parseInt(labelManRequest.getAgeEnd())));
        labelMan.setLabelId(labelManRequest.getLabelId());
        labelMan.setOldman(oldman);
        return labelMan;
    }
}
