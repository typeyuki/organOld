package com.organOld.web.controller;

import com.organOld.dao.entity.label.Label;
import com.organOld.service.contract.*;
import com.organOld.service.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 标签管理
 * Created by netlab606 on 2018/6/1.
 */
@Controller
@RequestMapping("/oldman/label")
public class LabelController {


    @Autowired
    LabelService labelService;

    /**
     * 人员绑定标签
     * @return
     */
    @RequestMapping(value = "/bind",method = RequestMethod.GET)
    public ModelAndView index_bind(){
        ModelAndView mv=new ModelAndView("oldman/label/label_three");
        mv.addObject("type","1");//标志 是人员绑定
        return mv;
    }

    /**
     * 规则指定标签
     * @return
     */
    @RequestMapping(value = "/rule",method = RequestMethod.GET)
    public ModelAndView index_rule(){
        ModelAndView mv=new ModelAndView("oldman/label/label_three");
        mv.addObject("type","2");//标志 是规则制定
        return mv;
    }



    /**
     * 获取标签的分页数据
     * @param bTableRequest
     * @param labelRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(BTableRequest bTableRequest, LabelRequest labelRequest, HttpSession session){
        return labelService.getByPage(labelRequest,bTableRequest,session);
    }

    /**
     * 规则制定标签 指定的规则 页面
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/rule/{labelId}",method = RequestMethod.GET)
    public ModelAndView rule(@PathVariable int labelId){
        ModelAndView mv=new ModelAndView("oldman/label/rule");
        mv.addObject("labelId",labelId);
        mv.addObject("rule",labelService.getLabelRule());
        return mv;
    }

    /**
     * 规则制定标签  获得某一ID的规则
     * @param labelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/rule/{labelId}/getRule",method = RequestMethod.GET)
    public Result get_rule(@PathVariable int labelId){
        return new Result(true,labelService.getLabelRuleById(labelId));
    }

    /**
     * 规则保存
     * @param labelRuleRequest
     * @return
     */
    @RequestMapping(value = "/rule/save",method = RequestMethod.POST)
    public ModelAndView rule_save(LabelRuleRequest labelRuleRequest){
        ModelAndView mv=new ModelAndView("redirect:/oldman/label/rule/"+labelRuleRequest.getLabelId());
        labelService.save(labelRuleRequest);
        return mv;
    }

    /**
     * 标签 绑定的人员 页面
     * @param type  bind 人员绑定  rule规则制定
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/{type}/{labelId}/man",method = RequestMethod.GET)
    public ModelAndView bind(@PathVariable int labelId,@PathVariable String type){
        ModelAndView mv=new ModelAndView("oldman/label/bind");
        mv.addObject("labelId",labelId);
        mv.addObject("type",type);
        return mv;
    }


    /**
     * 获取人员绑定标签的人员 分页数据
     * @param bTableRequest
     * @param oldmanRequest
     * @param type  bind 人员绑定  rule规则制定
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{type}/{labelId}/manData",method = RequestMethod.POST)
    public String bind_man_data(BTableRequest bTableRequest, OldmanRequest oldmanRequest, @PathVariable int labelId, @PathVariable String type){
        return labelService.getBindManByPage(oldmanRequest,bTableRequest,labelId,type);
    }

    /**
     * 人员绑定标签  获取该标签未绑定的人员
     * @param bTableRequest
     * @param oldmanRequest
     * @param labelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/bind/{labelId}/getNoSelectManData",method = RequestMethod.POST)
    public String bind_no_select_man_data(BTableRequest bTableRequest, OldmanRequest oldmanRequest, @PathVariable int labelId){
        return labelService.getNoSelectManDataByPage(oldmanRequest,bTableRequest,labelId);
    }


    /**
     * 获得某个老人的全部标签
     * @param oldmanId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{oldmanId}",method = RequestMethod.GET)
    public Result getManLabel(@PathVariable int oldmanId){
        return labelService.getByOldmanId(oldmanId);
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView add(Label label, HttpSession session){
        ModelAndView mv=new ModelAndView("redirect:/label/"+((label.getType()==1)?"bind":"rule"));
        labelService.save(label,session);
        return mv;
    }

}
