package com.organOld.web.controller;

import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.label.LabelFeedback;
import com.organOld.service.contract.*;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    AutoValueService autoValueService;

    /**
     * 人员绑定标签
     * @return
     */
    @RequestMapping(value = "/bind",method = RequestMethod.GET)
    public ModelAndView index_bind(){
        ModelAndView mv=new ModelAndView("oldman/label/label_three");
        mv.addObject("type","1");//标志 是人员绑定
        mv.addObject("rule",labelService.getFilterLabelRule(1));
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/{firType}/getSecLabel",method = RequestMethod.GET)
    public Result getSecLabel(@PathVariable int firType){
        Result result=labelService.getSecLabelByFirType(firType);
        return result;
    }

    /**
     * 规则指定标签
     * @return
     */
    @RequestMapping(value = "/rule",method = RequestMethod.GET)
    public ModelAndView index_rule(){
        ModelAndView mv=new ModelAndView("oldman/label/label_three");
        mv.addObject("type","2");//标志 是规则制定
        mv.addObject("rule",labelService.getFilterLabelRule(2));
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
    public String data(BTableRequest bTableRequest, LabelRequest labelRequest,
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
        labelRequest.setCensusArray(census);
        labelRequest.setFamily(family);
        labelRequest.setEconomic(economic);
        labelRequest.setPoliticalStatusArray(politicalStatus);
        labelRequest.setIntelligence(intelligence);
        labelRequest.setEyesight(eyesight);
        labelRequest.setDistrict(district);
        labelRequest.setJw(jw);
        labelRequest.setIsHealth(isHealth);
        labelRequest.setOldStatusArray(oldStatus);
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
        labelService.saveRule(labelRuleRequest);
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
     * @param labelManRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manData",method = RequestMethod.POST)
    public String bind_man_data(BTableRequest bTableRequest, LabelManRequest labelManRequest){
        return labelService.getBindManByPage(labelManRequest,bTableRequest);
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
     * 添加 标签的老人  人员绑定标签
     * @param labelId
     * @param oldmanIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{labelId}/saveMan",method = RequestMethod.POST)
    public Result saveLabelMan(@PathVariable int labelId, @RequestParam("oldmanId[]") int[] oldmanIds){
        Result result=labelService.saveLabelMan(labelId,oldmanIds);
        return result;
    }


    /**
     * 落实
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/implement",method = RequestMethod.POST)
    public Result implement(@RequestParam int id){
        Result result=labelService.implement(id);
        return result;
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


    /**
     * 标签添加
     * @param label
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView add(Label label){
        ModelAndView mv;
        labelService.save(label);
        if(label.getType()==1){
            mv=new ModelAndView("redirect:/oldman/label/bind");
        }else{
            mv=new ModelAndView("redirect:/oldman/label/rule/"+label.getId());
        }
        return mv;
    }


    /**
     * 标签反馈 管理
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/{labelId}/feedback",method = RequestMethod.GET)
    public ModelAndView feedback(@PathVariable int labelId){
        ModelAndView mv=new ModelAndView("oldman/label/label_feedback");
        mv.addObject("labelId",labelId);
        return mv;
    }

    /**
     * 查看某一标签的反馈信息
     * @param bTableRequest
     * @param labelFeedbackRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/feedback",method = RequestMethod.POST)
    public String data(BTableRequest bTableRequest, LabelFeedbackRequest labelFeedbackRequest){
        return labelService.getFeedbackByPage(labelFeedbackRequest,bTableRequest);
    }

    /**
     * 反馈添加
     * @param labelFeedbackAddRequest
     * @return
     */
    @RequestMapping(value = "/feedback/add",method = RequestMethod.POST)
    public ModelAndView feedback_add(LabelFeedbackAddRequest labelFeedbackAddRequest){
        ModelAndView mv=new ModelAndView("redirect:/oldman/label/"+(labelFeedbackAddRequest.getType().equals("2")?"rule":"bind"));
        labelService.feedbackAdd(labelFeedbackAddRequest);
        return mv;
    }

    /**
     * 查看 某一反馈
     * @param labelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/feedback/{labelId}/look",method = RequestMethod.GET)
    public Result feedback_look(@PathVariable int labelId){
        Result result=labelService.getFeedbackByLabelId(labelId);
        return result;
    }


    /**
     * 检测 该角色能够修改标签规则
     * @param labelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{labelId}/checkCanChange",method = RequestMethod.GET)
    public Result checkCanChange(@PathVariable int labelId){
        Result result=labelService.checkCanChange(labelId);
        return result;
    }
}
