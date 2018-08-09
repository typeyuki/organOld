package com.organOld.web.controller;

import com.organOld.service.contract.Result;
import com.organOld.service.service.TotalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 汇总导览 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/total/data")
public class TotalDataController {

    @Autowired
    TotalDataService totalDataService;

    @ResponseBody
    @RequestMapping(value = "/admin/getOldStatus",method = RequestMethod.GET)
    public Result admin_getOldStatus(){
        Result result=totalDataService.getOldStatus();
        return result;
    }

}
