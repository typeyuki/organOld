package com.organOld.web.controller;

import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.service.contract.*;
import com.organOld.service.enumModel.HomeEnum;
import com.organOld.service.contract.Result;
import com.organOld.service.service.HomeService;
import com.organOld.service.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * 居家养老
 * Created by netlab606 on 2018/6/11.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;
    @Autowired
    OrganService organService;

    /**
     *
     * 居家养老
     *
     */

    /**
     * 居家养老录入人员的页面
     * @return
     */
    @RequestMapping(value = "/man/all",method = RequestMethod.GET)
    public ModelAndView manAll(){
        ModelAndView mv=new ModelAndView("home/home_oldman_all");
        mv.addObject("info",homeService.getAddInfo());
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "/man/all/data",method = RequestMethod.POST)
    public String home_data_all(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest,
                                @RequestParam(value = "type_array[]",required = false) String type[]){
        homeOldmanRequest.setType(type);
        return homeService.getManAllByPage(homeOldmanRequest,bTableRequest);
    }


    @RequestMapping(value = "/oldman/add",method = RequestMethod.POST)
    public ModelAndView oldman_add(HomeOldman homeOldman){
        ModelAndView mv=new ModelAndView("redirect:/home/man/all");
        homeService.addOldman(homeOldman);
        return mv;
    }

    @RequestMapping(value = "/oldman/update",method = RequestMethod.POST)
    public ModelAndView oldman_update(HomeOldman homeOldman){
        ModelAndView mv=new ModelAndView("redirect:/home/man/all");
        homeService.updateOldman(homeOldman);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/oldman/del",method = RequestMethod.POST)
    public Result oldman_del(@RequestParam("ids[]") String ids[]){
        homeService.delByOldmanIds(ids);
        return new Result(true);
    }

    @ResponseBody
    @RequestMapping(value = "/oldman/{id}/getById",method = RequestMethod.GET)
    public Result getOldmanById(@PathVariable Integer id){
        return new Result(true, homeService.getOldmanById(id));
    }


    /**
     * 页面
     * @param type  1家庭服务 2长护险 3智能终端 4家庭医生 5家庭病床
     * @return
     */
    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public ModelAndView home(@PathVariable Integer type){
        ModelAndView mv=new ModelAndView("home/home");
        mv.addObject("title", HomeEnum.getValue(type));
        mv.addObject("type", type);
        if(type==4|| type==5){
            mv.addObject("organ",organService.getAll());
        }
        return mv;
    }


    /**
     * 获数据 分页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String home_data(HomeRequest homeRequest, BTableRequest bTableRequest){
        return homeService.getByPage(homeRequest,bTableRequest);
    }

    /**
     * 人员页面
     * @param hid
     * @return
     */
    @RequestMapping(value = "/{type}/{hid}/man",method = RequestMethod.GET)
    public ModelAndView man(@PathVariable int hid,@PathVariable int type){
        ModelAndView mv=new ModelAndView("home/home_man");
        mv.addObject("hid",hid);
        mv.addObject("type",type);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/man",method = RequestMethod.POST)
    public String home_man(HomeOldmanRequest homeOldmanRequest,BTableRequest bTableRequest){
        return homeService.getManByPage(homeOldmanRequest,bTableRequest);
    }



    /**
     * 居家养老人员的导入 更新：先删除之前的再添加  先根据 身份证号码 检测该老人是否在系统中 不在的话  设为不在系统的老人
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/man/importExcel",method = RequestMethod.POST)
    public ModelAndView importManExcel(@RequestParam MultipartFile file,@RequestParam String type) throws IOException {
        ModelAndView mv=new ModelAndView("oldman/home_oldman");
        Result result=homeService.importManExcel(file,type);
        mv.addObject("result",result);
        return mv;
    }


    /**
     * 添加
     * @param home
     * @return
     */
    @RequestMapping(value = "/{type}",method = RequestMethod.POST)
    public ModelAndView addOrUpdate(@PathVariable String type,Home home){
        ModelAndView mv=new ModelAndView("redirect:/home/"+home.getFirType());
        homeService.addOrUpdate(home,type);
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/{firType}/{id}/getById",method = RequestMethod.GET)
    public Result getById(@PathVariable int id,@PathVariable int firType){
        Result result=homeService.getById(id,firType);
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/{type}/del",method = RequestMethod.POST)
    public Result dela(@PathVariable int type,@RequestParam("ids[]") String ids[]){
        homeService.delByIds(ids,type);
        return new Result(true);
    }

}
