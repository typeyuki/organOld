package com.organOld.web.controller;

import com.organOld.service.contract.*;
import com.organOld.service.model.Model;
import com.organOld.service.service.OrganService;
import com.organOld.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    OrganService organService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView user(HttpSession session){
        ModelAndView mv=new ModelAndView("sys/account");
        mv.addObject("roles",userService.getAllRole());
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


    /**
     * 获得 该角色对应类型 所有机构
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRoleOrgan",method = RequestMethod.POST)
    public Result data(@RequestParam int type,@RequestParam int typeIndex){
        return organService.getRoleOrgan(type,typeIndex);
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView save(UserAddRequest userAddRequest){
        ModelAndView mv=new ModelAndView("redirect:/user");
        userService.save(userAddRequest);
        return mv;
    }
}
