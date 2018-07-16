package com.organOld.web.controller;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.ProductBookRequest;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 商品管理
     * organId 有值 表示从管理页面过来
     * @return
     */

    @RequestMapping("")
    public ModelAndView index(@RequestParam(required = false) Integer organId){
        ModelAndView mv=new ModelAndView("product/product");
        mv.addObject("organId",organId);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(ProductRequest productRequest, BTableRequest bTableRequest){
        return productService.getByPage(productRequest,bTableRequest);
    }


    /**
     * 商品预订
     */

    @RequestMapping("/book")
    public ModelAndView book(@RequestParam(required = false) Integer organId){
        ModelAndView mv=new ModelAndView("product/product_book");
        mv.addObject("organId",organId);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/book/data",method = RequestMethod.POST)
    public String data(ProductBookRequest productBookRequest, BTableRequest bTableRequest){
        return productService.getBookByPage(productBookRequest,bTableRequest);
    }
}
