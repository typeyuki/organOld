package com.organOld.service.service.impl;

import com.organOld.service.contract.Result;
import com.organOld.service.enumModel.OrganFirEnum;
import com.organOld.service.model.TotalAdminOldStatus;
import com.organOld.service.service.OldmanService;
import com.organOld.service.service.OrganService;
import com.organOld.service.service.TotalDataService;
import com.organOld.service.wrapper.OldmanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by netlab606 on 2018/8/9.
 */
@Service
public class TotalDataServiceImpl implements TotalDataService{


    @Autowired
    OldmanService oldmanService;
    @Autowired
    OldmanWrapper oldmanWrapper;

    @Override
    public Result getOldStatus() {
        TotalAdminOldStatus totalAdminOldStatus=oldmanWrapper.wrapOldStatus(oldmanService.getOldStatusNum());
        return new Result(true,totalAdminOldStatus);
    }
}
