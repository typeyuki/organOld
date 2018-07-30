package com.organOld.web.controller;


import com.organOld.dao.entity.SysUser;
import com.organOld.service.contract.*;

import com.organOld.service.model.Model;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OrganService;
import com.organOld.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    OrganService organService;
    @Autowired
    CommonService commonService;


    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView user(){
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


    /**
     * 账号添加
     * @param userAddRequest
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView save(UserAddRequest userAddRequest){
        ModelAndView mv=new ModelAndView("redirect:/user");
        userService.save(userAddRequest);
        return mv;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView update(UserAddRequest userAddRequest){
        ModelAndView mv=new ModelAndView("redirect:/user");
        userService.update(userAddRequest);
        return mv;
    }


    /**
     * 检测 账号对应的 机构的 类型
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkUserOrganType",method = RequestMethod.GET)
    public Result checkUserOrganType(){
        Result result=commonService.checkUserOrganType();
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Result del( @RequestParam("ids[]") String ids[]){
        userService.delByIds(ids);
        return new Result(true);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/getById",method = RequestMethod.GET)
    public Result getById(@PathVariable int id){
        return userService.getById(id);
    }


    @RequestMapping(value = "/password/edit",method = RequestMethod.GET)
    public ModelAndView password(){
        ModelAndView mv=new ModelAndView("sys/password_edit");
        mv.addObject("user",userService.getBySession());
        return mv;
    }
}
