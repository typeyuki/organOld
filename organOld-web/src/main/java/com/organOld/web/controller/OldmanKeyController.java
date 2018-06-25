package com.organOld.web.controller;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.KeyRuleRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.service.OldmanKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 重点老人
 * Created by netlab606 on 2018/6/1.
 */
@Controller
@RequestMapping("/oldman/key")
public class OldmanKeyController {


    @Autowired
    OldmanKeyService oldmanKeyService;

    /**
     * 页面
     * @return
     */
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("oldman/key");
        return mv;
    }

    /**
     * 分页数据
     * @param bTableRequest
     * @param session
     * @param oldmanKeyRequest
     * @return
     */
    @ResponseBody
    @RequestMapping("/data")
    public String data(BTableRequest bTableRequest, HttpSession session, OldmanKeyRequest oldmanKeyRequest){
        return oldmanKeyService.getByPage(bTableRequest,session,oldmanKeyRequest);
    }

    /**
     * 自动更新重点老人
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/autoUpdate",method = RequestMethod.POST)
    public Result autoUpdateMan(@RequestParam Boolean open){
        Result result=oldmanKeyService.autoUpdateMan(open);
        return result;
    }

    /**
     * 更新重点老人
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result updateMan(@RequestParam(required = false) String futureTime){
        Result result=oldmanKeyService.updateMan(futureTime);
        return result;
    }


    /**
     * 规则页面
     * @return
     */
    @RequestMapping("/rule")
    public ModelAndView rule(){
        ModelAndView mv=new ModelAndView("oldman/key_goal");
        mv.addObject("rule",oldmanKeyService.getRule());
        return mv;
    }

    /**
     * 分数更新
     * @return
     */
    @RequestMapping(value = "/rule/update",method = RequestMethod.POST)
    public ModelAndView rule_update(KeyRuleRequest keyRuleRequest){
        ModelAndView mv=new ModelAndView("redirect:/oldman/key/rule");
        oldmanKeyService.updateRule(keyRuleRequest);
        return mv;
    }
}
