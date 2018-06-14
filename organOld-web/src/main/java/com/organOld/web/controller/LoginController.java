package com.organOld.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by netlab606 on 2018/4/8.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }
}
