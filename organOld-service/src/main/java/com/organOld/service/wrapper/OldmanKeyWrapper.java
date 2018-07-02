package com.organOld.service.wrapper;

import com.organOld.dao.entity.oldman.KeyRule;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanFamily;
import com.organOld.service.constant.ValueConstant;
import com.organOld.service.contract.KeyRuleRequest;
import com.organOld.service.contract.OldmanFamilyRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.enumModel.KeyRuleTypeEnum;
import com.organOld.service.model.KeyRuleTypeModel;
import com.organOld.service.model.OldmanFamilyModel;
import com.organOld.service.model.OldmanKeyModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OldmanKeyWrapper implements Wrapper<Oldman,OldmanKeyModel,OldmanKeyRequest> {

    @Override
    public OldmanKeyModel wrap(Oldman oldman) {
        OldmanKeyModel oldmanKeyModel=new OldmanKeyModel();
        oldmanKeyModel.setOldmanId(oldman.getId());
        oldmanKeyModel.setGoal(oldman.getGoal());
        oldmanKeyModel.setOldmanNameKeyStatus(oldman.getName()+"#"+oldman.getKeyStatus());
        return oldmanKeyModel;
    }

    @Override
    public Oldman unwrap(OldmanKeyRequest oldmanKeyRequest) {
        Oldman oldman=new Oldman();
        oldman.setKeyGoalBase(ValueConstant.OLDMAN_KEY_GOAL_BASE);
        oldman.setFuture(oldmanKeyRequest.getFuture());
        return oldman;
    }


    public List<KeyRuleTypeModel> wrapKeyRule(List<KeyRule> keyRuleList) {
        List<KeyRuleTypeModel> keyRuleTypeModelList=new ArrayList<>();
        for (int i=1;i<=10;i++){
            KeyRuleTypeModel keyRuleTypeModel=new KeyRuleTypeModel();
            keyRuleTypeModel.setType(i);
            keyRuleTypeModel.setTypeDesc(KeyRuleTypeEnum.getValue(i));
            keyRuleTypeModelList.add(keyRuleTypeModel);
        }
        Collections.sort(keyRuleTypeModelList);
        for(KeyRule keyRule:keyRuleList){
            keyRuleTypeModelList.get(keyRule.getType()-1).getKeyRuleList().add(keyRule);
        }
        return keyRuleTypeModelList;
    }

    public List<KeyRule> unwrapKeyRule(KeyRuleRequest keyRuleRequest) {
        List<KeyRule> keyRuleList=new ArrayList<>();
        for (int i=0;i<keyRuleRequest.getGoal().length;i++){
            KeyRule keyRule=new KeyRule();
            keyRule.setGoal(Integer.parseInt(keyRuleRequest.getGoal()[i]));
            keyRule.setId(Integer.parseInt(keyRuleRequest.getId()[i]));
            keyRuleList.add(keyRule);
        }
        return keyRuleList;
    }
}
