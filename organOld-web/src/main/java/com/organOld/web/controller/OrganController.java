package com.organOld.web.controller;

import com.organOld.dao.entity.AutoValue;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OrganOldmanRequest;
import com.organOld.service.contract.OrganRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.model.OrganModel;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by netlab606 on 2018/6/11.
 */
@Controller
@RequestMapping("/organ")
public class OrganController {

    @Autowired
    OrganService organService;
    @Autowired
    AutoValueService autoValueService;
    @Autowired
    CommonService commonService;

    /**
     *
     * 养老服务机构
     *
     */

    /**
     * 页面
     * @param type  oldmanOrgan 机构养老  oldmanCommunity 社区养老   government 政府机构  society社会涉老机构
     * @return
     */
    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public ModelAndView organ(@PathVariable String type, @RequestParam(required = false) String status){
        ModelAndView mv=new ModelAndView("organ/organ");
        mv.addObject("type",type);
        if (!StringUtils.isEmpty(status))
            mv.addObject("status",status.split("\\?")[0]);
        return mv;
    }


    /**
     * 获数据 分页
     //     * @param aoData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(OrganRequest organRequest, BTableRequest bTableRequest){
        return organService.getByPage(organRequest,bTableRequest);
    }


    /**
     * 某养老机构的人员  页面
//     * @param organID
     * @return
     */
    @RequestMapping(value = "/oldman/{organId}/man",method = RequestMethod.GET)
    public ModelAndView man(@PathVariable String organId){
        ModelAndView mv=new ModelAndView("organ/oldman_man");
        mv.addObject("organId",organId);
        mv.addObject("dataUrl","/organ/oldman/man/data");
        return mv;
    }

    /**
     * 某养老机构的人员  数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/oldman/man/data",method = RequestMethod.POST)
    public String man_post(BTableRequest bTableRequest, OrganOldmanRequest organOldmanManRequest){
        return organService.getManByPage(bTableRequest,organOldmanManRequest);
    }

    /**
     * 机构账号登陆  管理
     * @return
     */
    @RequestMapping(value = "/oldman/single",method = RequestMethod.GET)
    public ModelAndView oldman(HttpSession httpSession){
        ModelAndView mv=new ModelAndView("organ/oldman_single");
        OrganModel organModel=organService.getBySession(httpSession);
        mv.addObject("organ",organModel);
        List<AutoValue> districtList=autoValueService.getByType(AutoValueEnum.PQ.getIndex());
        mv.addObject("districts",districtList);
        return mv;
    }

    /**
     * 机构账号登陆  人员
     * @return
     */
    @RequestMapping(value = "/oldman/single/man",method = RequestMethod.GET)
    public ModelAndView single_man(){
        ModelAndView mv=new ModelAndView("organ/oldman_man");
        mv.addObject("single","single");
        mv.addObject("dataUrl","/organ/oldman/single/man/data");
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/oldman/single/man/data",method = RequestMethod.POST)
    public String single(BTableRequest bTableRequest, OrganOldmanRequest organOldmanManRequest,HttpSession session){
        int organId=commonService.getIdBySession(session);
        organOldmanManRequest.setOrganId(organId);
        return organService.getManByPage(bTableRequest,organOldmanManRequest);
    }

    /**
     * 审核通过
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pass",method = RequestMethod.POST)
    public Result pass(@RequestParam int id){
        Result result=organService.pass(id);
        return result;
    }
}
