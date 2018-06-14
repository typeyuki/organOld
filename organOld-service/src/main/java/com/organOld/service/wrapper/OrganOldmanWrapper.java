package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.OrganOldman;
import com.organOld.service.model.OrganOldmanModel;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;




public class OrganOldmanWrapper implements Wrapper<OrganOldman,OrganOldmanModel,OrganOldmanRequest> {

    @Override
    public OrganOldmanModel wrap(OrganOldman organOldman) {
        OrganOldmanModel organOldmanModel=new OrganOldmanModel();
        organOldmanModel.setId(organOldman.getId());
        organOldmanModel.setOldmanId(organOldman.getOldmanId());
        organOldmanModel.setOrganId(organOldman.getOrganId());
        organOldmanModel.setTimeIn(Tool.dateToString(organOldman.getTime_in(),"yyyy-MM-dd"));
        organOldmanModel.setTimeOut(Tool.dateToString(organOldman.getTime_out(),"yyyy-MM-dd"));
        organOldmanModel.setTime(Tool.dateToString(organOldman.getTime(),"yyyy-MM-dd"));

        return organOldmanModel;
    }

    @Override
    public OrganOldman unwrap(OrganOldmanRequest organOldmanRequest) {
        OrganOldman organOldman=new OrganOldman();
        BeanUtils.copyProperties(organOldmanRequest,organOldman);
        return organOldman;
    }


}
