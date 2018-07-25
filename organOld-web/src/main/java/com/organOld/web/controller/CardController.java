package com.organOld.web.controller;

import com.organOld.dao.entity.SysUser;
import com.organOld.service.contract.*;
import com.organOld.service.enumModel.RecordTypeEnum;
import com.organOld.service.model.OldmanAllInfoModel;
import com.organOld.service.model.OrganQueryIntegralModel;
import com.organOld.service.service.CardService;
import com.organOld.service.service.OldmanService;
import com.organOld.service.service.RecordService;
import com.organOld.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 一卡通
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;
    @Autowired
    UserService userService;
    @Autowired
    OldmanService oldmanService;
    @Autowired
    RecordService recordService;


    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView base(){
        ModelAndView mv=new ModelAndView("card/card");
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(CardRequest cardRequest, BTableRequest bTableRequest){
        return cardService.getByPage(cardRequest,bTableRequest);
    }

    @RequestMapping(value = "/{id}/record",method = RequestMethod.GET)
    public ModelAndView record(@PathVariable int id){
        ModelAndView mv=new ModelAndView("card/record");
        mv.addObject("id",id);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/record/data",method = RequestMethod.POST)
    public String record_data(BTableRequest bTableRequest,CardRecordRequest cardRecordRequest){
        return recordService.getByCardPage(bTableRequest,cardRecordRequest);
    }

    /**
     * 充值
     * @param ids
     * @param money
     * @return
     */
    @ResponseBody
    @RequestMapping( value = "/addMoney",method = RequestMethod.POST)
    public Result addMoney(@RequestParam("ids[]") String ids[],Double money){
        return cardService.addMoney(ids,money);
    }
    @ResponseBody
    @RequestMapping( value = "/changeStatus/{status}",method = RequestMethod.POST)
    public Result changeStatus(@RequestParam("ids[]") String ids[],@PathVariable String status){
        return cardService.changeStatus(ids,status);
    }



    @ResponseBody
    @RequestMapping(value = "/aa",method = RequestMethod.GET)
    public Result consume(CardConsumeRequest cardConsumeRequest){
        CardConsumeRequest consumeRequest=cardConsumeRequest;

        System.out.println(cardConsumeRequest.toString());
        Result result=new Result(true,"成功");
        return result;
    }


    /**
     * 登陆验证  返回具有的权限
     * @param sysUser
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Result login(SysUser sysUser){
        Result result=userService.ckeckOrganLogin(sysUser);
        return result;
    }

    /**
     * 老人信息查询
     * @param oldmanId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Result info(@RequestParam int oldmanId,@RequestParam int organId){
        OldmanAllInfoModel oldmanAllInfoModel =oldmanService.getOldmanInfo(oldmanId);
        recordService.save(oldmanId,organId, RecordTypeEnum.INFO.getIndex());
        if(oldmanAllInfoModel.getOldman()==null) return new Result(false,"找不到");
        else  return new Result(true,oldmanAllInfoModel);
    }


    /**
     * 积分查询
     * @param oldmanId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/integral",method = RequestMethod.GET)
    public Result integral(@RequestParam int oldmanId,@RequestParam int organId){
        Result result=oldmanService.getIntegralByOldmanId(oldmanId);
        recordService.save(oldmanId,organId, RecordTypeEnum.IN.getIndex());
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/sign",method = RequestMethod.GET)
    public Result sign(@RequestParam int oldmanId,@RequestParam int organId){
        Result result=new Result(true,"签到成功");
        recordService.save(oldmanId,organId, RecordTypeEnum.SIGN.getIndex());
        return result;
    }
}
