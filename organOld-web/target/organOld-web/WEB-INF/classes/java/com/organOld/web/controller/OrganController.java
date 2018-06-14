package com.organOld.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by netlab606 on 2018/6/11.
 */
@Controller
@RequestMapping("/organ")
public class OrganController {

    /**
     *
     * 养老服务机构
     *
     */

    /**
     * 页面
     * @return
     */
    @RequestMapping(value = "/oldman",method = RequestMethod.GET)
    public ModelAndView oldman(){
        return new ModelAndView("organ/oldman");
    }


    /**
     *
     * @return
     */
    @RequestMapping(value = "/oldman/single",method = RequestMethod.GET)
    public ModelAndView oldman(HttpSession httpSession){
        return new ModelAndView("organ/oldman_single");
    }
}
