package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.service.enumModel.OrganFirEnum;
import com.organOld.service.model.OrganOldmanModel;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OrganOldmanWrapper implements Wrapper<OrganOldman,OrganOldmanModel,OrganOldmanRequest> {

    @Override
    public OrganOldmanModel wrap(OrganOldman organOldman) {
        OrganOldmanModel organOldmanModel=new OrganOldmanModel();
        organOldmanModel.setId(organOldman.getId()+"");
        if(!StringUtils.isEmpty(organOldman.getOrgan())){
            organOldmanModel.setOrganId(organOldman.getOrgan().getId());
            organOldmanModel.setOrganName(organOldman.getOrgan().getName());
            organOldmanModel.setOrgan(organOldman.getOrgan());
        }
        if(!StringUtils.isEmpty(organOldman.getOldman())){
            organOldmanModel.setOldmanId(organOldman.getOldman().getId());
            organOldmanModel.setOldmanName(organOldman.getOldman().getName());
        }
        if(!StringUtils.isEmpty(organOldman.getNoExistName())){
            organOldmanModel.setOldmanId(null);
            organOldmanModel.setOldmanName(organOldman.getNoExistName());
        }
        organOldmanModel.setNum(organOldman.getNum());
        organOldmanModel.setTimeIn(Tool.dateToString(organOldman.getTimeIn(),"yyyy-MM-dd"));
        organOldmanModel.setTimeOut(Tool.dateToString(organOldman.getTimeOut(),"yyyy-MM-dd"));
        organOldmanModel.setTime(Tool.dateToString(organOldman.getTime(),"yyyy-MM-dd"));
        organOldmanModel.setApplyTime(Tool.dateToString(organOldman.getApplyTime(),"yyyy-MM-dd"));
        return organOldmanModel;
    }

    @Override
    public OrganOldman unwrap(OrganOldmanRequest organOldmanRequest) {
        OrganOldman organOldman=new OrganOldman();
        Organ organ=new Organ();
        organ.setId(organOldmanRequest.getOrganId());
        organOldman.setSearch(organOldmanRequest.getSearch());
        if(organOldmanRequest.getOldmanId()!=null && organOldmanRequest.getOldmanId()!=0){
            Oldman oldman=new Oldman();
            oldman.setId(organOldmanRequest.getOldmanId());
            organOldman.setOldman(oldman);
        }
        organOldman.setOrgan(organ);
        organOldman.setIsPd(organOldmanRequest.getIsPd());
        organOldman.setIsExist(organOldmanRequest.getIsExist());

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
