package com.organOld.web.controller;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.*;
import com.organOld.service.contract.*;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.model.Model;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.OldmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by netlab606 on 2018/4/1.
 */
@Controller
@RequestMapping("/oldman")
public class OldmanController {

    @Autowired
    OldmanService oldmanService;
    @Autowired
    AutoValueService autoValueService;

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
        ModelAndView mv=new ModelAndView("oldman/base");
        mv.addObject("info",oldmanService.getAddInfo());
        return mv;
    }

    /**
     * 获取基本信息数据 分页 由于前台传过来的 参数都带 [] 所以对象封装数组 用不了 只能这样
     * requestparam 的名字不能跟 oldmanRequest的属性名一样
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/baseData",method = RequestMethod.POST)
    public String data(OldmanRequest oldmanRequest, BTableRequest bTableRequest, HttpSession session,
                       @RequestParam(value = "census_array[]",required = false) String census[],
                       @RequestParam(value = "family_array[]",required = false) String family[],
                       @RequestParam(value = "economic_array[]",required = false) String economic[],
                       @RequestParam(value = "politicalStatus_array[]",required = false) String politicalStatus[],
                       @RequestParam(value = "isHealth_array[]",required = false) String isHealth[],
                       @RequestParam(value = "intelligence_array[]",required = false) String intelligence[],
                       @RequestParam(value = "eyesight_array[]",required = false) String eyesight[],
                       @RequestParam(value = "district_array[]",required = false) String district[],
                       @RequestParam(value = "jw_array[]",required = false) String jw[],
                       @RequestParam(value = "oldStatus_array[]",required = false) String oldStatus[]){
        oldmanRequest.setCensusArray(census);
        oldmanRequest.setFamily(family);
        oldmanRequest.setEconomic(economic);
        oldmanRequest.setPoliticalStatusArray(politicalStatus);
        oldmanRequest.setIntelligence(intelligence);
        oldmanRequest.setEyesight(eyesight);
        oldmanRequest.setDistrict(district);
        oldmanRequest.setJw(jw);
        oldmanRequest.setIsHealth(isHealth);
        oldmanRequest.setOldStatusArray(oldStatus);

        return oldmanService.getOldmanByPage(oldmanRequest,bTableRequest);
    }


    /**
     * 导入的话  已有老人更新，没有的添加，去掉的设置为不可用    不能先删除之前的再添加，因为老人表涉及其他多个表 不能单纯的删除
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
    public ModelAndView importExcel(@RequestParam MultipartFile file,HttpSession session) throws IOException {
        ModelAndView mv=new ModelAndView("oldman/base");
        Result result=oldmanService.importExcel(file,session);
        mv.addObject("result",result);
        mv.addObject("info",oldmanService.getAddInfo());
        return mv;
    }


    /**
     * 添加  全部信息 页面
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView add_get(@RequestParam(required = false) String v){
        ModelAndView mv=new ModelAndView("oldman/add_all");
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
        return oldmanService.getHealthByPage(oldmanHealthRequest,bTableRequest);
    }

    /**
     * 健康档案 系统管理页面
     * @return
     */
    @RequestMapping(value = "/health/select",method = RequestMethod.GET)
    public ModelAndView select(){
        ModelAndView mv=new ModelAndView("oldman/health_select");
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/health/select/data",method = RequestMethod.POST)
    public String type_data(BTableRequest bTableRequest,HealthSelectRequest healthSelectRequest){
        return oldmanService.getHealthSelectByPage(healthSelectRequest,bTableRequest);
    }

    /**
     * 一级标签 添加、更新
     * @param healthSelect
     * @param type add添加 update修改
     * @return
     */
    @RequestMapping(value = "/health/select/{type}",method = RequestMethod.POST)
    public ModelAndView type_add(HealthSelect healthSelect, @PathVariable String type){
        ModelAndView mv=new ModelAndView("redirect:/oldman/health/select");
        oldmanService.addOrUpdateHealthSelect(healthSelect,type);
        return mv;
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
        ModelAndView mv= new ModelAndView("oldman/family");
        mv.addObject("family",autoValueService.getByType(AutoValueEnum.JJJG.getIndex()));
        return mv;
    }

    /**
     * 获取家庭数据 分页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/familyData",method = RequestMethod.POST)
    public String family_data(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest,
                              @RequestParam(value = "family_array[]",required = false) String family[]){
        familyRequest.setFamilyArray(family);
        return oldmanService.getFamilyByPage(familyRequest,bTableRequest);
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
        ModelAndView mv= new ModelAndView("oldman/economic");
        mv.addObject("economic",autoValueService.getByType(AutoValueEnum.JJTJ.getIndex()));
        return mv;
    }

    /**
     * 获取经济条件数据 分页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/economicData",method = RequestMethod.POST)
    public String economy_data(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest,
                               @RequestParam(value = "economic_array[]",required = false) String economic[]){
        economicRequest.setEconomicArray(economic);
        return oldmanService.getEconomyByPage(economicRequest,bTableRequest);
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
    public String data(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest){
        return oldmanService.getOrganOldmanByPage(organOldmanRequest,bTableRequest);
    }


    /**
     * 养老信息  居家养老
     * @return
     */
    @RequestMapping(value = "/organ/home",method = RequestMethod.GET)
    public ModelAndView homeOldman(){
        ModelAndView mv=new ModelAndView("oldman/home_oldman");
        return mv;
    }

    /**
     * 获取基本信息数据 分页
     //     * @param aoData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/homeOldmanData",method = RequestMethod.POST)
    public String homedata(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest,
                           @RequestParam(value = "type_array[]",required = false) String type[]){
        homeOldmanRequest.setType(type);
        return oldmanService.getHomeOldmanByPage(homeOldmanRequest,bTableRequest);
    }



    /**
     * 查看某个老人的全部信息
     * @return
     */
    @RequestMapping(value = "/{oldmanId}/info",method = RequestMethod.GET)
    public ModelAndView info(@PathVariable int oldmanId){
        ModelAndView mv=new ModelAndView("oldman/info");
        mv.addObject("info",oldmanService.getOldmanInfo(oldmanId));
        return mv;
    }



    /**
     * 积分管理
     * @return
     */
    @RequestMapping(value = "/integral",method = RequestMethod.GET)
    public ModelAndView integral(){
        return new ModelAndView("oldman/integral");
    }

    /**
     * 获取积分 分页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/integralData",method = RequestMethod.POST)
    public String integral_data(OldmanIntegralRequest oldmanIntegralRequest, BTableRequest bTableRequest){
        return oldmanService.getIntegralByPage(oldmanIntegralRequest,bTableRequest);
    }


    @ResponseBody
    @RequestMapping(value = "/{type}/{id}/getById",method = RequestMethod.GET)
    public Result base_getById(@PathVariable String type,@PathVariable int id){
        return oldmanService.getById(id,type);
    }


    @RequestMapping(value = "/base/update",method = RequestMethod.POST)
    public ModelAndView base_update(Oldman oldman){
        ModelAndView mv=new ModelAndView("redirect:/oldman/base");
        oldmanService.updateById(oldman,"base");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/base/del",method = RequestMethod.POST)
    public Result base_del(@RequestParam("ids[]") String ids[]){
        oldmanService.delByIds(ids);
        return new Result(true);
    }

    @ResponseBody
    @RequestMapping(value = "/health/select/del",method = RequestMethod.POST)
    public Result health_select_del(@RequestParam("ids[]") String ids[]){
        oldmanService.delHealthSelectByIds(ids);
        return new Result(true);
    }

    @RequestMapping(value = "/economic/update",method = RequestMethod.POST)
    public ModelAndView economic_update(OldmanEconomic oldmanEconomic){
        ModelAndView mv=new ModelAndView("redirect:/oldman/economic");
        oldmanService.updateById(oldmanEconomic,"economic");
        return mv;
    }

    @RequestMapping(value = "/family/update",method = RequestMethod.POST)
    public ModelAndView family_update(OldmanFamily oldmanFamily){
        ModelAndView mv=new ModelAndView("redirect:/oldman/family");
        oldmanService.updateById(oldmanFamily,"family");
        return mv;
    }

    @RequestMapping(value = "/linkman/update",method = RequestMethod.POST)
    public ModelAndView linkman_update(Linkman linkman){
        ModelAndView mv=new ModelAndView("redirect:/oldman/linkman");
        oldmanService.updateById(linkman,"linkman");
        return mv;
    }


}
