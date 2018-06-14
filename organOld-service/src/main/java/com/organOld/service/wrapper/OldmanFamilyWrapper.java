package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.Family;
import com.organOld.service.enumModel.FamilyEnum;
import com.organOld.service.model.FamilyModel;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;



public class OldmanFamilyWrapper implements Wrapper<Family,FamilyModel,OldmanFamilyRequest> {

    @Override
    public FamilyModel wrap(Family family) {
        FamilyModel familyModel=new FamilyModel();
        familyModel.setOldmanId(family.getOldmanId());
        familyModel.setFamilyIndex(FamilyEnum.getValue(family.getFamilyIndex()));
        familyModel.setOldmanName(family.getOldmanName());
        familyModel.setTime(Tool.dateToString(family.getTime(),"yyyy-MM-dd"));
        return familyModel;
    }

    @Override
    public Family unwrap(OldmanFamilyRequest familyRequest) {
        Family family=new Family();
        BeanUtils.copyProperties(familyRequest,family);
        return family;
    }


}
