package com.organOld.service.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.label.LabelMan;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.Xq;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.LabelManRequest;
import com.organOld.service.enumModel.SexEnum;
import com.organOld.service.model.LabelManModel;
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

/**
 * Created by netlab606 on 2018/7/8.
 */
@Service
public class LabelManWrapper implements Wrapper<LabelMan,LabelManModel,LabelManRequest> {

    @Autowired
    CommonService commonService;
    @Autowired
    AutoValueService autoValueService;

    List<String> method=new ArrayList<>();
    Map<Integer,String> map=new HashMap<>();

    @Override
    public LabelManModel wrap(LabelMan labelMan) {
        LabelManModel labelManModel=new LabelManModel();
        labelManModel.setId(labelMan.getId()+"");
        labelManModel.setIsImplement(labelMan.getIsImplement());
        labelManModel.setOldmanId(labelMan.getOldman().getId());
        labelManModel.setOldmanName(labelMan.getOldman().getName());
        labelManModel.setAge(CommonService.birthdayToAge(labelMan.getOldman().getBirthday()));
        labelManModel.setSex(SexEnum.getValue(labelMan.getOldman().getSex()));
        labelManModel.setTime(Tool.dateToString(labelMan.getOldman().getTime(), TimeConstant.DATA_FORMAT_YMD));
        labelManModel.setRemark(labelMan.getRemark());

        Xq xq=autoValueService.getXqById(labelMan.getOldman().getXqId());
        if(xq!=null) {
            labelManModel.setjName(xq.getJwName());
            labelManModel.setdName(xq.getDistrictName());
            labelManModel.setxName(xq.getName());
        }

        if(method.size()==0){
//            method.add("Family");
//            method.add("Economic");
            method.add("Census");
            method.add("PoliticalStatus");
        }
        if(map.size()==0){
            List<Integer> autoIds=commonService.getAutoValueTypes("oldman");
            List<AutoValue> autoValueList=autoValueService.getByTypeList(autoIds);
            autoValueList.forEach(s->map.put(s.getId(),s.getValue()));
        }
        commonService.fillAutoValue(labelMan.getOldman(),labelManModel,method,map);
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
