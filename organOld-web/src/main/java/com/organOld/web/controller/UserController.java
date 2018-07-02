package com.organOld.web.controller;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.contract.UserRequest;
import com.organOld.service.model.Model;
import com.organOld.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView user(HttpSession session){
        ModelAndView mv=new ModelAndView("sys/account");
        return mv;
    }

    /**
     * 所有账号 数据
     * @param userRequest
     * @param bTableRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(UserRequest userRequest, BTableRequest bTableRequest){
        return userService.getByPage(userRequest,bTableRequest);
    }
}
