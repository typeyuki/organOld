package com.organOld.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 重点老人
 * Created by netlab606 on 2018/6/1.
 */
@Controller
@RequestMapping("/oldman/key")
public class OldmanKeyController {

    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("oldman/key");
        return mv;
    }
}
