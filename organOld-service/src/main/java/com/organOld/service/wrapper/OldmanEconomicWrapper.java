package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.Economic;
import com.organOld.service.model.EconomicModel;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;


public class OldmanEconomicWrapper implements Wrapper<Economic,EconomicModel,OldmanEconomicRequest> {

    @Override
    public EconomicModel wrap(Economic economic) {
        EconomicModel economicModel=new EconomicModel();
//        economicModel.setId(economic.getId());
        economicModel.setOldmanId(economic.getOldmanId());
        economicModel.setEconmic_index(economic.getEconmic_index());
//        economicModel.setTime(Tool.dateToString(economic.getTime(),"yyyy-MM-dd"));

        return economicModel;
    }

    @Override
    public Economic unwrap(OldmanEconomicRequest economicRequest) {
        Economic economic=new Economic();
        BeanUtils.copyProperties(economicRequest,economic);
        return economic;
    }


}
