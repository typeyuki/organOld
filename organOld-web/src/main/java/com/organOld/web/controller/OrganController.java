package com.organOld.web.controller;

import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.service.contract.*;
import com.organOld.service.model.OrganAddModel;
import com.organOld.service.model.OrganModel;
import com.organOld.service.contract.Result;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
     * @param type  21 机构养老  22 社区养老   1 政府机构  3社会涉老机构
     * @return
     */
    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public ModelAndView organ(@PathVariable int type, @RequestParam(required = false) String status){
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
     * 机构的导入 只能添加
     * @param file
     * @param type
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/{type}/importExcel",method = RequestMethod.POST)
    public ModelAndView importExcel(@RequestParam MultipartFile file, @PathVariable int type,HttpServletRequest request,@RequestParam(required = false) String status) throws IOException {
        ModelAndView mv=new ModelAndView("organ/organ");
        Result result=organService.importExcel(file,type,request);
        mv.addObject("result",result);
        mv.addObject("type",type);
        if (!StringUtils.isEmpty(status))
            mv.addObject("status",status.split("\\?")[0]);
        return mv;
    }


    /**
     * 机构人员的导入 更新：先删除之前的再添加  先根据 身份证号码 检测该老人是否在系统中 不在的话不添加
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/man/importExcel",method = RequestMethod.POST)
    public ModelAndView importManExcel(@RequestParam MultipartFile file) throws IOException {
        ModelAndView mv=new ModelAndView("organ/oldman_man");
        mv.addObject("single","single");
        mv.addObject("dataUrl","/organ/oldman/single/man/data");
        Result result=organService.importManExcel(file);
        mv.addObject("result",result);
        return mv;
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

    @RequestMapping(value = "/oldman/add",method = RequestMethod.POST)
    public ModelAndView oldman_add(OrganOldman organOldman){
        ModelAndView mv=new ModelAndView("redirect:/organ/oldman/single/man");
        organService.addOldman(organOldman);
        return mv;
    }

    @RequestMapping(value = "/oldman/update",method = RequestMethod.POST)
    public ModelAndView oldman_update(OrganOldman organOldman){
        ModelAndView mv=new ModelAndView("redirect:/organ/oldman/single/man");
        organService.updateOldman(organOldman);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/oldman/del",method = RequestMethod.POST)
    public Result oldman_del(@RequestParam("ids[]") String ids[]){
        organService.delByOldmanIds(ids);
        return new Result(true);
    }

    @ResponseBody
    @RequestMapping(value = "/oldman/{id}/getById",method = RequestMethod.GET)
    public Result getOrganOldmanById(@PathVariable Integer id){
        return new Result(true, organService.getOldmanById(id));
    }

    /**
     * 机构查看
     * @param organId
     * @return
     */
    @RequestMapping(value = "/{organId}/info",method = RequestMethod.GET)
    public ModelAndView oldman(@PathVariable int organId,@RequestParam(required = false)String look){
        ModelAndView mv=new ModelAndView("organ/organ_single");
        OrganModel organModel=organService.getById(organId);
        mv.addObject("organ",organModel);
        if(look!=null && !look.equals(""))
            mv.addObject("look",look);
        return mv;
    }

    /**
     * 机构添加
     * @param firType
     * @return
     */
    @RequestMapping(value = "/{firType}/add",method = RequestMethod.GET)
    public ModelAndView add(@PathVariable int firType){
        ModelAndView mv=new ModelAndView("organ/organ_single");
        OrganAddModel organAddModel=organService.getAddInfo(firType);
        mv.addObject("organ",organAddModel);
        return mv;
    }

    /**
     * 机构账号登陆  管理
     * @return
     */
    @RequestMapping(value = "/oldman/single",method = RequestMethod.GET)
    public ModelAndView oldman(HttpSession httpSession){
        ModelAndView mv=new ModelAndView("organ/organ_single");
        OrganModel organModel=organService.getBySession(httpSession);
        mv.addObject("organ",organModel);
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
    public String single(BTableRequest bTableRequest, OrganOldmanRequest organOldmanManRequest){
        int organId=commonService.getIdBySession();
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

    /**
     * 审核不通过
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/reject",method = RequestMethod.POST)
    public Result reject(@RequestParam int id){
        Result result=organService.reject(id);
        return result;
    }

    /**
     * 第三方机构 撤销
     * @param organId
     * @return
     */
    @RequestMapping(value = "/{organId}/cancel",method = RequestMethod.GET)
    public ModelAndView cancel(@PathVariable int organId){
        ModelAndView mv=new ModelAndView("redirect:/organ/3?status=2");
        organService.cancel(organId);
        return mv;
    }

    /**
     * 机构注册
     * @return
     */
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public ModelAndView reg(OrganRegRequest organRegRequest, HttpServletRequest request){
        ModelAndView mv=new ModelAndView("organ/reg_return");
        Result result=organService.reg(organRegRequest,request);
        mv.addObject("result",result);
        return mv;
    }

    /**
     * 机构添加或修改
     * @param type add 添加 update 更新
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{type}",method = RequestMethod.POST)
    public ModelAndView organ(OrganRegRequest organRegRequest, HttpServletRequest request,@PathVariable String type){
        ModelAndView mv;
        Integer organId=organService.addOrUpdate(organRegRequest,request,type);
        mv=new ModelAndView("redirect:/organ/"+organId+"/info");
        return mv;
    }


    /**
     * 机构注册页面
     * @return
     */
    @RequestMapping(value = "/organReg",method = RequestMethod.GET)
    public ModelAndView organReg(){
        ModelAndView mv=new ModelAndView("organ/organ_reg");
        mv.addObject("info",organService.getRegInfo());
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/getByFirType",method = RequestMethod.POST)
    public Result getByFirType(@RequestParam int firType){
        return new Result(true,organService.getByOrganFirType(firType));
    }

    /**
     * 服务情况
     * @return
     */
    @RequestMapping(value = "/record",method = RequestMethod.GET)
    public ModelAndView record(@RequestParam(required = false) Integer organId){
        ModelAndView mv=new ModelAndView("organ/organ_service_record");
        if(organId!=null)
            mv.addObject("organId",organId);
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "/record/data",method = RequestMethod.POST)
    public String data(OrganServiceRecordRequest organServiceRecordRequest, BTableRequest bTableRequest){
        return organService.getRecordByPage(organServiceRecordRequest,bTableRequest);
    }
    @RequestMapping(value = "/record/importExcel",method = RequestMethod.POST)
    public ModelAndView importRecordExcel(@RequestParam MultipartFile file,@RequestParam Integer organId) throws IOException {
        ModelAndView mv=new ModelAndView("organ/organ_service_record");
        Result result=organService.importRecordExcel(file);
        mv.addObject("result",result);
        mv.addObject("organId",organId);
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/del/ids",method = RequestMethod.POST)
    public Result dela(@RequestParam("ids[]") String ids[]){
        organService.delByIds(ids);
        return new Result(true);
    }

}
