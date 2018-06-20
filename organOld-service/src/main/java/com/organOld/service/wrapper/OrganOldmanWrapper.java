package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.service.enumModel.OrganFirEnum;
import com.organOld.service.model.OrganOldmanModel;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.util.StringUtils;


public class OrganOldmanWrapper implements Wrapper<OrganOldman,OrganOldmanModel,OrganOldmanRequest> {

    @Override
    public OrganOldmanModel wrap(OrganOldman organOldman) {
        OrganOldmanModel organOldmanModel=new OrganOldmanModel();
        organOldmanModel.setId(organOldman.getId());
        organOldmanModel.setOrganId(organOldman.getOrgan().getId());
        organOldmanModel.setOrganName(organOldman.getOrgan().getName());
        organOldmanModel.setOldmanId(organOldman.getOldman().getId());
        organOldmanModel.setOldmanName(organOldman.getOldman().getName());
        organOldmanModel.setNum(organOldman.getNum());
        organOldmanModel.setTimeIn(Tool.dateToString(organOldman.getTimeIn(),"yyyy-MM-dd"));
        organOldmanModel.setTimeOut(Tool.dateToString(organOldman.getTimeOut(),"yyyy-MM-dd"));
        organOldmanModel.setTime(Tool.dateToString(organOldman.getTime(),"yyyy-MM-dd"));

        return organOldmanModel;
    }

    @Override
    public OrganOldman unwrap(OrganOldmanRequest organOldmanRequest) {
        OrganOldman organOldman=new OrganOldman();
        Organ organ=new Organ();
        organ.setId(organOldmanRequest.getOrganId());
        Oldman oldman=new Oldman();
        oldman.setId(organOldmanRequest.getOldmanId());
        organOldman.setOrgan(organ);
        organOldman.setOldman(oldman);

        if(!StringUtils.isEmpty(organOldmanRequest.getFirType())){
            if(organOldmanRequest.getFirType().equals("organ")){
                organOldman.setFirType(OrganFirEnum.JGYL.getIndex());
            }else{
                organOldman.setFirType(OrganFirEnum.SQYL.getIndex());
            }
        }
        return organOldman;
    }


}
