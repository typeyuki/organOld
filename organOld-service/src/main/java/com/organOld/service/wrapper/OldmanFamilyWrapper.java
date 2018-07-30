package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.OldmanFamily;
import com.organOld.service.model.OldmanFamilyModel;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;



public class OldmanFamilyWrapper implements Wrapper<OldmanFamily,OldmanFamilyModel,OldmanFamilyRequest> {

    @Override
    public OldmanFamilyModel wrap(OldmanFamily family) {
        OldmanFamilyModel familyModel=new OldmanFamilyModel();
        familyModel.setId(family.getId());
        familyModel.setOldmanId(family.getOldman().getId());
        familyModel.setOldmanName(family.getOldman().getName());
        familyModel.setFamily(family.getFamily()==null?"":family.getFamily());
        familyModel.setTime(Tool.dateToString(family.getTime(),"yyyy-MM-dd"));
        familyModel.setFamilyTypeString(family.getFamilyTypeIndex());
        return familyModel;
    }

    @Override
    public OldmanFamily unwrap(OldmanFamilyRequest familyRequest) {
        OldmanFamily family=new OldmanFamily();
        BeanUtils.copyProperties(familyRequest,family);
        return family;
    }


}
