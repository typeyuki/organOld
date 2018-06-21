package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.KeyRule;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.repository.OldmanKeyDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.enumModel.KeyRuleTypeEnum;
import com.organOld.service.model.LinkmanModel;
import com.organOld.service.model.OldmanKeyModel;
import com.organOld.service.model.OldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OldmanKeyService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OldmanKeyServiceImpl implements OldmanKeyService {

    @Autowired
    CommonService commonService;
    @Autowired
    OldmanKeyDao oldmanKeyDao;
    @Autowired
    AutoValueDao autoValueDao;

    @Override
    public String getByPage(BTableRequest bTableRequest, HttpSession session, OldmanKeyRequest oldmanKeyRequest) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_key");
        Oldman oldman= Wrappers.oldmanKeyWrapper.unwrap(oldmanKeyRequest);
        commonService.checkIsJw(session,oldman);
        page.setEntity(oldman);
        List<OldmanKeyModel> oldmanKeyModelList=oldmanKeyDao.getByPage(page).stream().map(Wrappers.oldmanKeyWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanKeyDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanKeyModelList);
    }

    @Override
    public Result updateMan() {
        Result result;

        return null;
    }

    public void calculateKeyGoal(OldmanKey oldmanKey, List<KeyRule> keyRuleList){
        int goal=0;//总分

        int flagAge=0;

        for (KeyRule keyRule:keyRuleList){
            if(keyRule.getType()== KeyRuleTypeEnum.NL.getIndex()){
                //年龄
                if(flagAge==0){
                    int start=Integer.parseInt(keyRule.getValueName().split("-")[0]);
                    int end=keyRule.getValueName().split("-")[1].equals("")? Integer.MAX_VALUE+"":Integer.parseInt(keyRule.getValueName().split("-")[1]);
                    int age=commonService.birthdayToAge(oldmanKey.getBirthday());
                    if(age>=start && age<end){
                        flagAge=1;
                        goal+=keyRule.getGoal();
                    }
                }else{
                    continue;
                }
            }
            if(keyRule.getType()== KeyRuleTypeEnum.JTJG.getIndex()){
                
            }
            if(keyRule.getType()== KeyRuleTypeEnum.CHX.getIndex()){
//                chxRule.add(keyRule);
            }
            if(keyRule.getType()== KeyRuleTypeEnum.SN.getIndex()){
//                snRule.add(keyRule);
            }
            if(keyRule.getType()== KeyRuleTypeEnum.ZL.getIndex()){
//                intelligenceageRule.add(keyRule);
            }
            if(keyRule.getType()== KeyRuleTypeEnum.SL.getIndex()){
//                eyesightRule.add(keyRule);
            }if(keyRule.getType()== KeyRuleTypeEnum.MB.getIndex()){
//                mbRule.add(keyRule);
            }
            if(keyRule.getType()== KeyRuleTypeEnum.JJTJ.getIndex()){
//                economicRule.add(keyRule);
            }
            if(keyRule.getType()== KeyRuleTypeEnum.QT.getIndex()){
//                otherRule.add(keyRule);
            }
        }
    }
}
