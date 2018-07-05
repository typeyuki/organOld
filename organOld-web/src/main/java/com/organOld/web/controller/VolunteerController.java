package com.organOld.web.controller;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.contract.VolunteerRequest;
import com.organOld.service.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    @RequestMapping(value = "/man",method = RequestMethod.GET)
    public ModelAndView base(){
        ModelAndView mv=new ModelAndView("volunteer/volunteer");
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/man/data",method = RequestMethod.POST)
    public String data(VolunteerRequest volunteerRequest, BTableRequest bTableRequest, HttpSession session){
        return volunteerService.getByPage(volunteerRequest,bTableRequest,session);
    }
}
