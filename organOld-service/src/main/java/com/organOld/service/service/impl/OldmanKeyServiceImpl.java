package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.KeyRule;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.repository.KeyRuleDao;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.OldmanKeyDao;
import com.organOld.dao.util.Page;
import com.organOld.service.constant.ValueConstant;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.enumModel.HealthEnum;
import com.organOld.service.enumModel.KeyRuleTypeEnum;
import com.organOld.service.enumModel.KeyStatusEnum;
import com.organOld.service.model.LinkmanModel;
import com.organOld.service.model.OldmanKeyModel;
import com.organOld.service.model.OldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.KeyUpdate;
import com.organOld.service.service.OldmanKeyService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class OldmanKeyServiceImpl implements OldmanKeyService {

    @Autowired
    CommonService commonService;
    @Autowired
    OldmanKeyDao oldmanKeyDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    KeyRuleDao keyRuleDao;
    @Autowired
    OldmanDao oldmaDao;
    @Autowired
    KeyUpdate keyUpdate;

    public static List<KeyRule> keyRuleList;



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
//        Result result;
        keyRuleList=keyRuleDao.getAll();

        keyUpdate.longPollingExecutor.execute(keyUpdate.updateRunner);
        return new Result(true);
    }


    @Override
    public void updateKey(List<OldmanKey> oldmanKeys) {
        List<Oldman> oldmanList=new ArrayList<>();

        for (OldmanKey oldmanKey:oldmanKeys){
            for(HealthSelect healthSelect:oldmanKey.getHealthSelectIdsList()){
                if(healthSelect.getFirType()== HealthEnum.MB.getIndex()){
                    oldmanKey.getMbIds().add(healthSelect.getId());
                }
                if(healthSelect.getFirType()== HealthEnum.SN.getIndex()){
                    oldmanKey.getSnIds().add(healthSelect.getId());
                }
            }
            Oldman oldman=new Oldman();
            oldman.setId(oldmanKey.getOldmanId());
            oldman.setGoal(calculateKeyGoal(oldmanKey));
            oldman.setKeyStatus(oldmanKey.getKeyStatus());
            checkKeyStatus(oldman);
            oldmanList.add(oldman);
            System.out.println(oldman.toString());
        }
//        oldmaDao.updateKeyOldman(oldmanList);
    }

    @Override
    public void checkKeyStatus(Oldman oldman) {
        Boolean isKeyNow=false;
        if(oldman.getGoal()>= ValueConstant.OLDMAN_KEY_GOAL_BASE)
            isKeyNow=true;
        if(oldman.getKeyStatus()== KeyStatusEnum.NO.getIndex() || oldman.getKeyStatus()== KeyStatusEnum.DEL.getIndex()){
            if(isKeyNow){
                //上次不是 这次是
                oldman.setKeyStatus(KeyStatusEnum.ADD.getIndex());
            }else{
                //上次这次都不是
                oldman.setKeyStatus(KeyStatusEnum.NO.getIndex());
            }
        }
        if(oldman.getKeyStatus()== KeyStatusEnum.YES.getIndex() || oldman.getKeyStatus()== KeyStatusEnum.ADD.getIndex()){
            if(isKeyNow){
                //上次这次都是
                oldman.setKeyStatus(KeyStatusEnum.YES.getIndex());
            }else{
                //上次是  这次不是
                oldman.setKeyStatus(KeyStatusEnum.DEL.getIndex());
            }
        }
    }

    @Override
    public int calculateKeyGoal(OldmanKey oldmanKey){
        int goal=0;//总分
        int goalHealth=0;// 健康状态的分数  最后如果有长护险的话 总分减去这个

        int flagAge=0,flagJTJG=0,flagJJTJ=0,flagLOU=0,flagJYLY=0;
        int flagCHX=0,flagSL=0,flagSZ=0;
        int flagSN=oldmanKey.getSnIds().size(),flagMB=oldmanKey.getMbIds().size();

        for (KeyRule keyRule:keyRuleList){
            if(keyRule.getType()== KeyRuleTypeEnum.NL.getIndex()){
                //年龄
                if(flagAge==0){
                    String[] a=keyRule.getValueName().split("-");
                    int start=Integer.parseInt(keyRule.getValueName().split("-")[0]);
                    int end=keyRule.getValueName().split("-").length==1? Integer.MAX_VALUE:Integer.parseInt(keyRule.getValueName().split("-")[1]);
                    int age=commonService.birthdayToAge(oldmanKey.getBirthday());
                    if(age>=start && age<=end){
                        flagAge=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;

            }
            if(keyRule.getType()== KeyRuleTypeEnum.JTJG.getIndex()){
                //家庭结构
                if(flagJTJG==0){
                    if(keyRule.getValueIndex()==oldmanKey.getFamilyIndex()){
                        flagJTJG=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.CHX.getIndex()){
                //长护险
                if(flagCHX==0){
                    if(keyRule.getValueIndex()==oldmanKey.getChxIndex()){
                        flagCHX=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.SN.getIndex()){
                //失能
                if(flagSN!=0 && flagCHX==0){
                    if(oldmanKey.getSnIds().contains(keyRule.getValueIndex())){
                        flagSN--;
                        goal+=keyRule.getGoal();
                        goalHealth+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.ZL.getIndex()){
                //失智
                if(flagSZ==0 && flagCHX==0){
                    if(oldmanKey.getIntelligence()==keyRule.getValueIndex()){
                        flagSZ=1;
                        goal+=keyRule.getGoal();
                        goalHealth+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.SL.getIndex()){
                //视力
                if(flagSL==0 && flagCHX==0){
                    if(oldmanKey.getEyesight()==keyRule.getValueIndex()){
                        flagSL=1;
                        goal+=keyRule.getGoal();
                        goalHealth+=keyRule.getGoal();
                    }
                }
                continue;
            }if(keyRule.getType()== KeyRuleTypeEnum.MB.getIndex()){
                //慢病
                if(flagMB!=0 && flagCHX==0){
                    if(oldmanKey.getMbIds().contains(keyRule.getValueIndex())){
                        flagMB--;
                        goal+=keyRule.getGoal();
                        goalHealth+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.JJTJ.getIndex()){
                //经济条件
                if(flagJJTJ==0){
                    if(keyRule.getValueIndex()==oldmanKey.getEconomicIndex()){
                        flagJJTJ=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.LOU.getIndex()){
                //无电梯楼层
                if(flagLOU==0){
                    if(keyRule.getValueIndex()==oldmanKey.getFloor()){
                        flagLOU=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.JYLY.getIndex()){
                //是否主动进养老院
                if(flagJYLY==0){
                    if(keyRule.getValueIndex()==oldmanKey.getIsActivityOrgan()){
                        flagJYLY=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
        }
        if(flagCHX==1){
            goal-=goalHealth;
        }
        return goal;
    }
}
