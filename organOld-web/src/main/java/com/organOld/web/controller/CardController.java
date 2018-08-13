package com.organOld.web.controller;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.SysUser;
import com.organOld.service.contract.*;
import com.organOld.service.model.OldmanAllInfoModel;
import com.organOld.service.contract.Result;
import com.organOld.service.service.CardService;
import com.organOld.service.service.OldmanService;
import com.organOld.service.service.RecordService;
import com.organOld.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @RequestMapping(value = "/{id}/getById",method = RequestMethod.GET)
    public Result getById(@PathVariable Integer id){
        Result result=cardService.getById(id);
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView update(Card card){
        cardService.updateById(card);
        ModelAndView mv=new ModelAndView("redirect:/card");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(CardRequest cardRequest, BTableRequest bTableRequest){
        return cardService.getByPage(cardRequest,bTableRequest);
    }

    @RequestMapping(value = "/{id}/record",method = RequestMethod.GET)
    public ModelAndView record(@PathVariable int id,@RequestParam(value = "type",required = false) Integer type){
        ModelAndView mv=new ModelAndView("card/record");
        mv.addObject("id",id);
        mv.addObject("type",type);
        return mv;
    }

    @RequestMapping(value = "/{oldmanId}/integral/record",method = RequestMethod.GET)
    public ModelAndView record(@PathVariable int oldmanId){
        Integer cid=cardService.getIdByOldmanId(oldmanId);
        ModelAndView mv;
        if(cid==null || cid==0 ){
            mv=new ModelAndView("error/message");
            mv.addObject("message","卡号不存在");
        }else{
            mv=new ModelAndView("redirect:/card/"+cid+"/record?type=9");
        }
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


    /**
     * 消费
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/consume",method = RequestMethod.GET)
    public Result consume(@RequestParam int cid,@RequestParam int organId,SysUser sysUser,String order,String oldmanPassword,String money){
        Result check=userService.ckeckOrganLogin(sysUser);
        if(check!=null) {
            Result result=cardService.handleConsume(cid,organId,order,oldmanPassword,money);
            return result;
        }else{
            return new Result(false,"没有权限");
        }
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
     * 老人信息查询  根据卡号
     * @param cid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Result info(@RequestParam int cid,@RequestParam int organId,SysUser sysUser){
        Result check=userService.ckeckOrganLogin(sysUser);
        if(check!=null){
            OldmanAllInfoModel oldmanAllInfoModel =cardService.handleInfo(cid,organId);
            if(oldmanAllInfoModel.getOldman()==null) return new Result(false,"找不到");
            else  return new Result(true,oldmanAllInfoModel);
        }else{
            return new Result(false,"没有权限");
        }
    }


    /**
     * 积分查询
     * @param cid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/integral",method = RequestMethod.GET)
    public Result integral(@RequestParam int cid,@RequestParam int organId,SysUser sysUser){
        Result check=userService.ckeckOrganLogin(sysUser);
        if(check!=null) {
            Result result=cardService.handleIntegral(cid,organId);
            return result;
        }else{
            return new Result(false,"没有权限");
        }
    }


    /**
     * 签到
     * @param cid
     * @param organId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sign",method = RequestMethod.GET)
    public Result sign(@RequestParam int cid,@RequestParam int organId,SysUser sysUser){
        Result check=userService.ckeckOrganLogin(sysUser);
        if(check!=null) {
            Result result=cardService.handleSign(cid,organId);
            return result;
        }else{
            return new Result(false,"没有权限");
        }
    }



    /**
     * 生成二维码 压缩包
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void create_zip(@RequestParam("id") String ids[], HttpServletResponse response, HttpServletRequest request){
        cardService.createZip(ids,response,request);
    }
}
