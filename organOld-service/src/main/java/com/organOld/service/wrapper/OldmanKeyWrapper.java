package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanFamily;
import com.organOld.service.constant.ValueConstant;
import com.organOld.service.contract.OldmanFamilyRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.model.OldmanFamilyModel;
import com.organOld.service.model.OldmanKeyModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;


public class OldmanKeyWrapper implements Wrapper<Oldman,OldmanKeyModel,OldmanKeyRequest> {

    @Override
    public OldmanKeyModel wrap(Oldman oldman) {
        OldmanKeyModel oldmanKeyModel=new OldmanKeyModel();
        oldmanKeyModel.setOldmanId(oldman.getId());
        oldmanKeyModel.setGoal(oldman.getGoal());
        oldmanKeyModel.setOldmanName(oldman.getName());
        return oldmanKeyModel;
    }

    @Override
    public Oldman unwrap(OldmanKeyRequest oldmanKeyRequest) {
        Oldman oldman=new Oldman();
        oldman.setKeyGoalBase(ValueConstant.OLDMAN_KEY_GOAL_BASE);
        return oldman;
    }


}
