package com.organOld.web.controller;

import com.organOld.dao.entity.AutoValue;
import com.organOld.service.contract.AutoValueRequest;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.contract.VolunteerRequest;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/autoValue")
public class AutoVolueController {

    @Autowired
    AutoValueService autoValueService;

    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public ModelAndView index(@PathVariable int type){
        ModelAndView mv=new ModelAndView("oldman/auto_value");
        mv.addObject("type",type);
        mv.addObject("typeName", AutoValueEnum.getValue(type));
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(AutoValueRequest autoValueRequest, BTableRequest bTableRequest){
        return autoValueService.getByPage(autoValueRequest,bTableRequest);
    }


    @ResponseBody
    @RequestMapping(value = "/{id}/getById",method = RequestMethod.GET)
    public Result getById(@PathVariable int id){
        return autoValueService.getById(id);
    }

    @RequestMapping(value = "/{typeId}/{type}",method = RequestMethod.POST)
    public ModelAndView handle(@PathVariable String type, @PathVariable int typeId, AutoValue autoValue){
        ModelAndView mv=new ModelAndView("redirect:/autoValue/"+typeId);
        autoValueService.handle(type,autoValue);
        return mv;
    }
}
