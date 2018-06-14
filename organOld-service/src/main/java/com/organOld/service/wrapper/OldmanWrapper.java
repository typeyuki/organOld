package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.enumModel.CensusEnum;
import com.organOld.service.enumModel.DistrictEnum;
import com.organOld.service.enumModel.PoliticalStatusEnum;
import com.organOld.service.enumModel.SexEnum;
import com.organOld.service.model.OldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;

public class OldmanWrapper implements Wrapper<Oldman,OldmanModel,OldmanRequest> {

    @Override
    public OldmanModel wrap(Oldman oldman) {
        OldmanModel oldmanModel=new OldmanModel();
        oldmanModel.setId(oldman.getId());
        oldmanModel.setName(oldman.getName());
        oldmanModel.setLouNum(oldman.getLouNum());
        if(oldman.getBirthday()!=null)
            oldmanModel.setAge(CommonService.birthdayToAge(oldman.getBirthday()));
        oldmanModel.setSex(SexEnum.getValue(oldman.getSex()));
        oldmanModel.setCensus(oldman.getCensus());
        oldmanModel.setPoliticalStatus(oldman.getPoliticalStatus());
        if(oldman.getTime()!=null)
            oldmanModel.setTime(Tool.dateToString(oldman.getTime(), TimeConstant.DATA_FORMAT_YMD));
        oldmanModel.setPid(oldman.getPid());
        oldmanModel.setAddress(oldman.getAddress());
        oldmanModel.setPhone(oldman.getPhone());
        oldmanModel.setjName(oldman.getXq().getJwName());
        oldmanModel.setdName(oldman.getXq().getDistrictName());
        oldmanModel.setxName(oldman.getXq().getName());
        oldmanModel.setPoliticalStatus(oldman.getPoliticalStatus());
        return oldmanModel;
    }

    @Override
    public Oldman unwrap(OldmanRequest oldmanRequest) {
        Oldman oldman=new Oldman();
        BeanUtils.copyProperties(oldmanRequest,oldman);
        //TODO 转换 年龄段到出生年月
//        if(oldmanRequest.getSearch()!=null && !oldmanRequest.getSearch().equals("")){
//            if(CommonService.isPid(oldmanRequest.getSearch())){
//                //查找的是身份证
//                oldman.setPid(oldmanRequest.getSearch());
//            }else if(CommonService.isPhone(oldmanRequest.getSearch())){
//                //查找的是电话
//                oldman.setPhone(oldmanRequest.getSearch());
//            }else{
//                oldman.setName(oldmanRequest.getSearch());
//                oldman.setAddress(oldmanRequest.getSearch());
//            }
//        }
        return oldman;
    }


}
