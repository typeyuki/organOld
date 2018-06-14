package com.organOld.web.controller;

import com.organOld.service.contract.*;
import com.organOld.service.service.OldmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String data(OldmanRequest oldmanRequest, BTableRequest bTableRequest){
        return oldmanService.getOldmanByPage(oldmanRequest,bTableRequest);
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
     * 添加  全部信息
     * @param oldmanAddRequest
     * @return
     */
    @RequestMapping(value = "/base/add",method = RequestMethod.POST)
    public String base_add(OldmanAddRequest oldmanAddRequest){
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
    public String health_data(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest){
        return oldmanService.getHealthByPage(oldmanHealthRequest,bTableRequest);
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
    public String family_data(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest){
        return oldmanService.getFamilyByPage(familyRequest,bTableRequest);
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
    public String economy_data(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest){
        return oldmanService.getEconomyByPage(economicRequest,bTableRequest);
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
    public String linkman_data(LinkmanRequest linkmanRequest, BTableRequest bTableRequest){
        return oldmanService.getLinkmanByPage(linkmanRequest,bTableRequest);
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
     * 机构养老信息
     * @return
     */
    @RequestMapping(value = "/organOldman",method = RequestMethod.GET)
    public ModelAndView organOldman(){
        return new ModelAndView("oldman/organOldman");
    }

    /**
     * 获取基本信息数据 分页
     //     * @param aoData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/organOldmanData",method = RequestMethod.POST)
    public String data(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest){
        return oldmanService.getOrganOldmanByPage(organOldmanRequest,bTableRequest);
    }
    /**
     * 信息更新
     * @param organOldmanRequest
     * @return
     */
    @RequestMapping(value = "/organOldman/update",method = RequestMethod.POST)
    public String organOldman_update(OrganOldmanRequest organOldmanRequest){
        oldmanService.updateOrganOldman(organOldmanRequest);
        return "redirect:/organOldman";
    }



}
