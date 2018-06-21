package com.organOld.service.service.impl;

import com.organOld.dao.entity.oldman.KeyRule;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.dao.repository.OldmanKeyDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.contract.Result;
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
        int goal;//总分
//        List<KeyRule> ageRule=new ArrayList<>();
//        List<KeyRule> familyRule=new ArrayList<>();
//        List<KeyRule> chxRule=new ArrayList<>();
//        List<KeyRule> snRule=new ArrayList<>();
//        List<KeyRule> intelligenceageRule=new ArrayList<>();
//        List<KeyRule> eyesightRule=new ArrayList<>();
//        List<KeyRule> mbRule=new ArrayList<>();
//        List<KeyRule> economicRule=new ArrayList<>();
//        List<KeyRule> otherRule=new ArrayList<>();
        for (KeyRule keyRule:keyRuleList){
            if(keyRule.getType()== KeyRuleTypeEnum.NL.getIndex()){
//                ageRule.add(keyRule);
                //年龄
                int start;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.JTJG.getIndex()){
//                familyRule.add(keyRule);
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
