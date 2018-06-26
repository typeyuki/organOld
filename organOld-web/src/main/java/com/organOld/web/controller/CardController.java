package com.organOld.web.controller;

import com.organOld.service.contract.Result;
import com.organOld.service.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 一卡通
 * Created by netlab606 on 2018/6/25.
 */
@Controller()
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Result consume(){
        Result result=null;
        return result;
    }
}
