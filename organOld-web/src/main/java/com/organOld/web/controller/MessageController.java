package com.organOld.web.controller;

import com.organOld.dao.entity.Message;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.MessageRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.contract.VolunteerRequest;
import com.organOld.service.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("message/message");
    }

    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(MessageRequest messageRequest, BTableRequest bTableRequest){
        return messageService.getByPage(messageRequest,bTableRequest);
    }

    /**
     * 该账号的消息 全部已读
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/read",method = RequestMethod.GET)
    public Result read(){
        Result result=messageService.read();
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Result del(@RequestParam("ids[]") String ids[]){
        messageService.delByIds(ids);
        return new Result(true);
    }
}
