package com.organOld.web.controller;


import com.organOld.service.contract.ExportTableThRequest;
import com.organOld.service.service.MessageService;
import com.organOld.service.service.SystemService;
import com.organOld.service.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by netlab606 on 2018/3/24.
 */
@Controller
public class SystemController {

    @Autowired
    SystemService systemService;
    @Autowired
    MessageService messageService;

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView home(HttpSession session){
        ModelAndView mv=new ModelAndView("home");
        mv.addObject("menus",systemService.getMenu(session));
        mv.addObject("messageNum",messageService.getNoReadNum());
        return mv;
    }

    /**
     * 导入 Excel表格
     * @param file
     * @param cType
     * @param pType
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
    public ModelAndView importExcel(@RequestParam MultipartFile file,String cType,String pType) throws IOException {
        ModelAndView mv=new ModelAndView("redirect:/oldman/base");
        systemService.importExcel(file,cType,pType);
        return mv;
    }



}
