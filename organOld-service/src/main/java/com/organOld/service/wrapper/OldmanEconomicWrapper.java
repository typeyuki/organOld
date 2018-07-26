package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.OldmanEconomic;
import com.organOld.service.model.OldmanEconomicModel;
import com.organOld.service.contract.*;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;


public class OldmanEconomicWrapper implements Wrapper<OldmanEconomic,OldmanEconomicModel,OldmanEconomicRequest> {

    @Override
    public OldmanEconomicModel wrap(OldmanEconomic economic) {
        OldmanEconomicModel economicModel=new OldmanEconomicModel();
        economicModel.setId(economic.getId());
        economicModel.setOldmanId(economic.getOldman().getId());
        economicModel.setEconomic(economic.getEconomic()==null?"":economic.getEconomic());
        economicModel.setOldmanName(economic.getOldman().getName());
        economicModel.setTime(Tool.dateToString(economic.getTime(),"yyyy-MM-dd"));
        return economicModel;
    }

    @Override
    public OldmanEconomic unwrap(OldmanEconomicRequest economicRequest) {
        OldmanEconomic economic=new OldmanEconomic();
        BeanUtils.copyProperties(economicRequest,economic);
        return economic;
    }


}
