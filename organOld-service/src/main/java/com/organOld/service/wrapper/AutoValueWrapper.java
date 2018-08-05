package com.organOld.service.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.service.contract.AutoValueRequest;
import com.organOld.service.model.AutoValueModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by netlab606 on 2018/7/25.
 */
@Service
public class AutoValueWrapper implements Wrapper<AutoValue,AutoValueModel,AutoValueRequest> {


    @Override
    public AutoValueModel wrap(AutoValue autoValue) {
        AutoValueModel autoValueModel=new AutoValueModel();
        BeanUtils.copyProperties(autoValue,autoValueModel);
        return autoValueModel;
    }

    @Override
    public AutoValue unwrap(AutoValueRequest autoValueRequest) {
        AutoValue autoValue=new AutoValue();
        BeanUtils.copyProperties(autoValueRequest,autoValue);
        return autoValue;
    }
}
