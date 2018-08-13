package com.organOld.web.controller;

import com.organOld.service.contract.*;
import com.organOld.service.enumModel.RecordTypeEnum;
import com.organOld.service.contract.Result;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OrganService;
import com.organOld.service.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;
    @Autowired
    OrganService organService;
    @Autowired
    CommonService commonService;

    /**
     *type  看RecordTypeEnum
     * organId 有值不为0 表示从管理页面过来
     * @return
     */

    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false) Integer organId, @PathVariable int type){
        ModelAndView mv;
        Boolean result=organService.checkHaveAuthByAuthType(type,organId);
        if(organId==null || organId==0)
            organId=commonService.getIdBySession();
        if(result) {
            mv = new ModelAndView("record/record");
            mv.addObject("organId", organId);
            mv.addObject("type", type);
            mv.addObject("typeDesc", RecordTypeEnum.getValue(type));
            if(type==1){
                mv.addObject("moneySum",recordService.getMoneySum(null,null,organId));
            }
        }else{
            //没有权限
            mv = new ModelAndView("error/message");
            mv.addObject("message","抱歉！您没有权限");
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/getMoneySum",method = RequestMethod.GET)
    public Result getMoneySum(String start, String end, Integer organId){
        Result result=recordService.getMoneySum(start,end,organId);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(RecordRequest recordRequest, BTableRequest bTableRequest){
        return recordService.getByPage(recordRequest,bTableRequest);
    }


}
