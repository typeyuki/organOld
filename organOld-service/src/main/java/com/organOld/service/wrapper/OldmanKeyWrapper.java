package com.organOld.service.wrapper;

import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.oldman.KeyRule;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanFamily;
import com.organOld.dao.entity.oldman.OldmanKeyHandle;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.OrganDao;
import com.organOld.service.constant.ValueConstant;
import com.organOld.service.contract.KeyRuleRequest;
import com.organOld.service.contract.OldmanFamilyRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.contract.OldmanhKeyHandleRequest;
import com.organOld.service.enumModel.HomeEnum;
import com.organOld.service.enumModel.KeyHandleEnum;
import com.organOld.service.enumModel.KeyRuleTypeEnum;
import com.organOld.service.enumModel.OldStatusEnum;
import com.organOld.service.model.KeyRuleTypeModel;
import com.organOld.service.model.OldmanFamilyModel;
import com.organOld.service.model.OldmanKeyHandleModel;
import com.organOld.service.model.OldmanKeyModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.util.Tool;
import com.sun.deploy.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class OldmanKeyWrapper implements Wrapper<Oldman,OldmanKeyModel,OldmanKeyRequest> {

    @Override
    public OldmanKeyModel wrap(Oldman oldman) {
        OldmanKeyModel oldmanKeyModel=new OldmanKeyModel();
        oldmanKeyModel.setOldmanId(oldman.getId());
        oldmanKeyModel.setGoal(oldman.getGoal());
        oldmanKeyModel.setOldmanNameKeyStatus(oldman.getName()+"#"+oldman.getKeyStatus());

        oldmanKeyModel.setStatus(KeyHandleEnum.getValue(oldman.getIsHandle()));
        oldmanKeyModel.setOldStatus(OldStatusEnum.getValue(oldman.getOldStatus()));

        if(oldman.getOrganList()!=null && oldman.getOrganList().size()>0){
            for(Organ organ:oldman.getOrganList()){
                if(organ.getOrganTypeId()==29){
                    //是助餐点
                    oldmanKeyModel.getOrganAndHome().put(organ.getId()+"",organ.getName());
                }else{
                    if(organ.getOrganNum()==null || organ.getOrganNum().equals("0")){
                        //主动申请的
                        oldmanKeyModel.getOrganActivity().add(organ);
                    }else{
                        oldmanKeyModel.getOrganAndHome().put(organ.getId()+"",organ.getName());
                    }
                }
            }
        }

        if(oldman.getHomeList()!=null && oldman.getHomeList().size()>0){
            int i=0;
            for(Home home:oldman.getHomeList()){
                oldmanKeyModel.getOrganAndHome().put("0"+(i++), HomeEnum.getValue(home.getFirType()));
            }
        }

        if(oldman.getOldmanKeyHandle()!=null)
        oldmanKeyModel.setOldmanKeyHandleModel(this.wrapHandle(oldman.getOldmanKeyHandle()));
        return oldmanKeyModel;
    }

    @Override
    public Oldman unwrap(OldmanKeyRequest oldmanKeyRequest) {
        Oldman oldman=new Oldman();
        oldman.setKeyGoalBase(ValueConstant.OLDMAN_KEY_GOAL_BASE);
        oldman.setFuture(oldmanKeyRequest.getFuture());
        if(oldmanKeyRequest.getOldmanId()!=null)
            oldman.setId(oldmanKeyRequest.getOldmanId());
        oldman.setIsHandle(oldmanKeyRequest.getIsHandle());
        oldman.setGoalEnd(oldmanKeyRequest.getGoalEnd());
        oldman.setGoalStart(oldmanKeyRequest.getGoalStart());
        oldman.setIsActivity(oldmanKeyRequest.getIsActivity());
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

    public OldmanKeyHandle unwrapKeyHandle(OldmanhKeyHandleRequest oldmanhKeyHandleRequest) {
        OldmanKeyHandle oldmanKeyHandle=new OldmanKeyHandle();
        if(oldmanhKeyHandleRequest.getId()!=null)
            oldmanKeyHandle.setId(oldmanhKeyHandleRequest.getId());
        oldmanKeyHandle.setType(oldmanhKeyHandleRequest.getType());
        oldmanKeyHandle.setOldmanId(oldmanhKeyHandleRequest.getOldmanId());
        if(oldmanhKeyHandleRequest.getType()==3 ||oldmanhKeyHandleRequest.getType()==4) {
            if (oldmanhKeyHandleRequest.getHomeFirTypes() != null && oldmanhKeyHandleRequest.getHomeFirTypes().length > 0)
                oldmanKeyHandle.setHomeFirTypes(String.join("#", oldmanhKeyHandleRequest.getHomeFirTypes()));
        }
        if(oldmanhKeyHandleRequest.getType()==1 ||oldmanhKeyHandleRequest.getType()==2 ||oldmanhKeyHandleRequest.getType()==4) {
            if (oldmanhKeyHandleRequest.getOrganIds() != null && oldmanhKeyHandleRequest.getOrganIds().length > 0)
                oldmanKeyHandle.setOrganIds(String.join("#", oldmanhKeyHandleRequest.getOrganIds()));
        }

        return oldmanKeyHandle;
    }

    public OldmanKeyHandleModel wrapHandle(OldmanKeyHandle oldmanKeyHandle) {
        OldmanKeyHandleModel oldmanKeyHandleModel=new OldmanKeyHandleModel();
        oldmanKeyHandleModel.setId(oldmanKeyHandle.getId());
        oldmanKeyHandleModel.setType(OldStatusEnum.getValue(oldmanKeyHandle.getType()));
        if(oldmanKeyHandle.getHomeFirTypes()!=null && !oldmanKeyHandle.equals("")){
            List<String> list=Arrays.asList(oldmanKeyHandle.getHomeFirTypes().split("#"));
            for(String index:list){
                oldmanKeyHandleModel.getHomeFirTypes().add(HomeEnum.getValue(Integer.parseInt(index)));
            }
        }
        if(oldmanKeyHandle.getOrganIds()!=null && !oldmanKeyHandle.getOrganIds().equals("")){
            List<String> ids=Arrays.asList(oldmanKeyHandle.getOrganIds().split("#"));
            oldmanKeyHandleModel.setOrgandIds(ids);
        }

        return oldmanKeyHandleModel;
    }
}
