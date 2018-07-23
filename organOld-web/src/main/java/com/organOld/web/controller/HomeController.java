package com.organOld.web.controller;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.home.Home;
import com.organOld.service.contract.*;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.enumModel.HomeEnum;
import com.organOld.service.model.OrganModel;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.HomeService;
import com.organOld.service.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
     * 居家养老人员的导入 更新：先删除之前的再添加  先根据 身份证号码 检测该老人是否在系统中 不在的话不添加
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/man/importExcel",method = RequestMethod.POST)
    public ModelAndView importManExcel(@RequestParam MultipartFile file) throws IOException {
        ModelAndView mv=new ModelAndView("oldman/home_oldman");
        Result result=homeService.importManExcel(file);
        mv.addObject("result",result);
        return mv;
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView add(Home home){
        ModelAndView mv=new ModelAndView("redirect:/home/"+home.getFirType());
        homeService.add(home);
        return mv;
    }
}
