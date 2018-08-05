package com.organOld.service.wrapper;

import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.service.contract.HomeOldmanRequest;
import com.organOld.service.contract.OrganOldmanRequest;
import com.organOld.service.enumModel.HomeEnum;
import com.organOld.service.enumModel.OrganFirEnum;
import com.organOld.service.model.HomeOldmanModel;
import com.organOld.service.model.OrganOldmanModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HomeOldmanWrapper implements Wrapper<HomeOldman,HomeOldmanModel,HomeOldmanRequest> {

    @Override
    public HomeOldmanModel wrap(HomeOldman homeOldman) {
        HomeOldmanModel homeOldmanModel=new HomeOldmanModel();
        homeOldmanModel.setHomeName(homeOldman.getHome().getSecType());
        homeOldmanModel.setHomeType(HomeEnum.getValue(homeOldman.getHome().getFirType()));
        homeOldmanModel.setId(homeOldman.getId());
        homeOldmanModel.setOldmanId(homeOldman.getOldman().getId());
        homeOldmanModel.setOldmanName(homeOldman.getOldman().getName());
        if(homeOldman.getHome().getFirType()==HomeEnum.CHX.getIndex()){
            homeOldmanModel.setIsService(homeOldman.getIsService()==0?"未获得":"已获得");
        }else{
            homeOldmanModel.setTimeIn(Tool.dateToString(homeOldman.getTimeIn(),"yyyy-MM-dd"));
            homeOldmanModel.setTimeOut(Tool.dateToString(homeOldman.getTimeOut(),"yyyy-MM-dd"));
        }
        homeOldmanModel.setTime(Tool.dateToString(homeOldman.getTime(),"yyyy-MM-dd"));
        homeOldmanModel.setOrgan(homeOldman.getOrgan());
        return homeOldmanModel;
    }

    @Override
    public HomeOldman unwrap(HomeOldmanRequest homeOldmanRequest) {
        HomeOldman homeOldman=new HomeOldman();
        BeanUtils.copyProperties(homeOldmanRequest,homeOldman);
        return homeOldman;
    }


}
