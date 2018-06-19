package com.organOld.service.wrapper;

import com.organOld.dao.entity.organ.Organ;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.OrganRequest;
import com.organOld.service.enumModel.OrganFirEnum;
import com.organOld.service.model.OrganModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;

public class OrganWrapper implements Wrapper<Organ,OrganModel,OrganRequest> {

    @Override
    public OrganModel wrap(Organ organ) {
        OrganModel organModel=new OrganModel();
        BeanUtils.copyProperties(organ,organModel);
        organModel.setTime(Tool.dateToString(organ.getTime(), TimeConstant.DATA_FORMAT_YMD));
        return organModel;
    }

    @Override
    public Organ unwrap(OrganRequest organRequest) {
        Organ organ=new Organ();
        BeanUtils.copyProperties(organRequest,organ);
        switch (organRequest.getType()){
            case "oldmanOrgan":
                organ.setOrganFirTypeId(OrganFirEnum.JGYL.getIndex());
                break;
            case "oldmanCommunity":
                organ.setOrganFirTypeId(OrganFirEnum.SQYL.getIndex());
                break;
            case "government":
                organ.setOrganFirTypeId(OrganFirEnum.ZF.getIndex());
                break;
            case "society":
                organ.setOrganFirTypeId(OrganFirEnum.SH.getIndex());
                break;
        }
        return organ;
    }


}
