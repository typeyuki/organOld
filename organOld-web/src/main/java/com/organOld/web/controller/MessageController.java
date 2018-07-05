package com.organOld.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/message")
public class MessageController {


    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("message/message");
    }
}
