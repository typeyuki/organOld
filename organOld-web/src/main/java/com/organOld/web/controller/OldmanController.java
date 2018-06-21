package com.organOld.web.controller;

import com.organOld.service.contract.*;
import com.organOld.service.service.OldmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by netlab606 on 2018/4/1.
 */
@Controller
@RequestMapping("/oldman")
public class OldmanController {

    @Autowired
    OldmanService oldmanService;

    /**
     *
     * 基本信息
     *
     */


    /**
     * 基本信息
     * @return
     */
    @RequestMapping(value = "/base",method = RequestMethod.GET)
    public ModelAndView base(){
        return new ModelAndView("oldman/base");
    }

    /**
     * 获取基本信息数据 分页
     //     * @param aoData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/baseData",method = RequestMethod.POST)
    public String data(OldmanRequest oldmanRequest, BTableRequest bTableRequest, HttpSession session){
        return oldmanService.getOldmanByPage(oldmanRequest,bTableRequest,session);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/base/del",method = RequestMethod.POST)
    public Result base_del(@RequestParam int id){
        oldmanService.delById(id);
        return new Result(true);
    }

    /**
     * 添加  全部信息 页面
     * @return
     */
    @RequestMapping(value = "/base/add",method = RequestMethod.GET)
    public ModelAndView add_get(){
        ModelAndView mv=new ModelAndView("oldman/add");
        mv.addObject("info",oldmanService.getAddInfo());
        return mv;
    }

    /**
     * 添加  全部信息
     * @param oldmanAddRequest
     * @return
     */
    @RequestMapping(value = "/base/add",method = RequestMethod.POST)
    public String add_post(OldmanAddRequest oldmanAddRequest){
        oldmanService.save(oldmanAddRequest);
        return "redirect:/oldman/base";
    }

    /**
     * 基本信息更新
     * @param oldmanRequest
     * @return
     */
    @RequestMapping(value = "/base/update",method = RequestMethod.POST)
    public String base_update(OldmanRequest oldmanRequest){
        oldmanService.updateOldman(oldmanRequest);
        return "redirect:/oldman/base";
    }

    /**
     *
     * 健康档案
     *
     */


    /**
     * 健康档案
     * @return
     */
    @RequestMapping(value = "/health",method = RequestMethod.GET)
    public ModelAndView health(){
        return new ModelAndView("oldman/health");
    }

    /**
     * 获取基本信息数据 分页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/healthData",method = RequestMethod.POST)
    public String health_data(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest,HttpSession session){
        return oldmanService.getHealthByPage(oldmanHealthRequest,bTableRequest,session);
    }


    /**
     *
     * 家庭结构
     *
     */


    /**
     * 家庭结构
     * @return
     */
    @RequestMapping(value = "/family",method = RequestMethod.GET)
    public ModelAndView family(){
        return new ModelAndView("oldman/family");
    }

    /**
     * 获取家庭数据 分页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/familyData",method = RequestMethod.POST)
    public String family_data(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest,HttpSession session){
        return oldmanService.getFamilyByPage(familyRequest,bTableRequest,session);
    }
    /**
     * 信息更新
     * @param familyRequest
     * @return
     */
    @RequestMapping(value = "/family/update",method = RequestMethod.POST)
    public String family_update(OldmanFamilyRequest familyRequest){
        oldmanService.updateFamily(familyRequest);
        return "redirect:/family";
    }


    /**
     *
     * 经济条件
     *
     */

    /**
     * 经济条件
     * @return
     */
    @RequestMapping(value = "/economic",method = RequestMethod.GET)
    public ModelAndView economic(){
        return new ModelAndView("oldman/economic");
    }

    /**
     * 获取经济条件数据 分页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/economicData",method = RequestMethod.POST)
    public String economy_data(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest,HttpSession session){
        return oldmanService.getEconomyByPage(economicRequest,bTableRequest,session);
    }
    /**
     * 信息更新
     * @param economicRequest
     * @return
     */
    @RequestMapping(value = "economic/update",method = RequestMethod.POST)
    public String economic_update(OldmanEconomicRequest economicRequest){
        oldmanService.updateEconomy(economicRequest);
        return "redirect:/economic";
    }

    /**
     *
     * 应急联系人
     *
     */

    @RequestMapping(value = "/linkman",method = RequestMethod.GET)
    public ModelAndView linkman(){
        return new ModelAndView("oldman/linkman");
    }

    /**
     * 获取基本信息数据 分页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/linkman/data",method = RequestMethod.POST)
    public String linkman_data(LinkmanRequest linkmanRequest, BTableRequest bTableRequest,HttpSession session){
        return oldmanService.getLinkmanByPage(linkmanRequest,bTableRequest,session);
    }
    /**
     * 信息更新
     * @param linkmanRequest
     * @return
     */
    @RequestMapping(value = "/linkman/update",method = RequestMethod.POST)
    public String linkman_update(LinkmanRequest linkmanRequest){
        oldmanService.updateLinkman(linkmanRequest);
        return "redirect:/linkman";
    }


    /**
     *
     *养老状态：机构养老
     *
     */


    /**
     * 养老信息  organ 机构养老  community社区养老
     * @return
     */
    @RequestMapping(value = "/organ/{type}",method = RequestMethod.GET)
    public ModelAndView organOldman(@PathVariable String type){
        ModelAndView mv=new ModelAndView("oldman/organOldman");
        mv.addObject("type",type);
        return mv;
    }

    /**
     * 获取基本信息数据 分页
     //     * @param aoData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/organOldmanData",method = RequestMethod.POST)
    public String data(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest,HttpSession session){
        return oldmanService.getOrganOldmanByPage(organOldmanRequest,bTableRequest,session);
    }




}
