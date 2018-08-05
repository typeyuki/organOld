package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.Linkman;
import com.organOld.service.model.LinkmanModel;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class LinkmanWrapper implements Wrapper<Linkman,LinkmanModel,LinkmanRequest> {

    @Override
    public LinkmanModel wrap(Linkman linkman) {
        LinkmanModel linkmanModel=new LinkmanModel();
        linkmanModel.setId(linkman.getId());
        linkmanModel.setOldman(linkman.getOldman().getId()+"："+linkman.getOldman().getName());
        linkmanModel.setName(linkman.getName());
        linkmanModel.setPhone(linkman.getPhone());
        linkmanModel.setRelation(linkman.getRelation());
        linkmanModel.setTime(Tool.dateToString(linkman.getTime(),"yyyy-MM-dd"));

        return linkmanModel;
    }

    @Override
    public Linkman unwrap(LinkmanRequest linkmanRequest) {
        Linkman linkman=new Linkman();
        BeanUtils.copyProperties(linkmanRequest,linkman);
        return linkman;
    }


}
