package com.organOld.web.controller;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.ProductBookRequest;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     * @return
     */

    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("product/product");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(ProductRequest productRequest, BTableRequest bTableRequest, HttpSession session){
        return productService.getByPage(productRequest,bTableRequest,session);
    }


    /**
     * 商品预订
     */

    @RequestMapping("/book")
    public ModelAndView book(){
        ModelAndView mv=new ModelAndView("product/product_book");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/book/data",method = RequestMethod.POST)
    public String data(ProductBookRequest productBookRequest, BTableRequest bTableRequest, HttpSession session){
        return productService.getBookByPage(productBookRequest,bTableRequest,session);
    }
}
