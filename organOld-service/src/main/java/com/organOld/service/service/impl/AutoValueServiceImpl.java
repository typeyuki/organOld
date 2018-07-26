package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.AutoValueRequest;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.model.AutoValueModel;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.CommonService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoValueServiceImpl implements AutoValueService {

    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    CommonService commonService;

    @Override
    public List<AutoValue> getByType(int type) {
        return autoValueDao.getByType(type);
    }


    @Override
    public String getByPage(AutoValueRequest autoValueRequest, BTableRequest bTableRequest) {
        Page<AutoValue> page=commonService.getPage(bTableRequest,"auto_value");
        AutoValue autoValue= Wrappers.autoValueWrapper.unwrap(autoValueRequest);
        page.setEntity(autoValue);
        List<AutoValueModel> autoValueModelList=autoValueDao.getByPage(page).stream().map(Wrappers.autoValueWrapper::wrap).collect(Collectors.toList());
        Long size=autoValueDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,autoValueModelList);
    }

    @Override
    public Result getById(int id) {
        return new Result(true,autoValueDao.getById(id));
    }

    @Override
    public void handle(String type, AutoValue autoValue) {
        if(type.equals("add")){
            autoValueDao.save(autoValue);
        }else{
            autoValueDao.updateById(autoValue);
        }
    }

    @Override
    public void delByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        autoValueDao.delByIds(id);
    }

    @Override
    public List<AutoValue> getByIds(String[] sq) {
        return autoValueDao.getByIds(sq);
    }
}
