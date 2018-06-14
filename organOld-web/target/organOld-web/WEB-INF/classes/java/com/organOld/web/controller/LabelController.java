package com.organOld.web.controller;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.LabelRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        mv.addObject("type","1");
        return mv;
    }

    /**
     * 规则指定标签
     * @return
     */
    @RequestMapping(value = "/rule",method = RequestMethod.GET)
    public ModelAndView index_rule(){
        ModelAndView mv=new ModelAndView("oldman/label/label_three");
        mv.addObject("type","2");
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
    public String data(BTableRequest bTableRequest, LabelRequest labelRequest){
        return labelService.getByPage(labelRequest,bTableRequest);
    }

    /**
     * 规则制定标签 指定的规则 页面
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/rule/{labelId}",method = RequestMethod.GET)
    public ModelAndView rule(@PathVariable int labelId){
        ModelAndView mv=new ModelAndView("oldman/label/rule");
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
}
