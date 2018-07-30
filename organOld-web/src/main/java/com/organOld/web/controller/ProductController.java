package com.organOld.web.controller;

import com.organOld.dao.entity.product.Product;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.ProductBookRequest;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/{type}",method = RequestMethod.POST)
    public ModelAndView addOrupdate(@PathVariable String type, ProductRequest productRequest, HttpServletRequest request){
        ModelAndView mv=new ModelAndView("redirect:/product");
        productService.addOrUpdate(productRequest,type,request);
        return mv;
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

    @ResponseBody
    @RequestMapping("/book/handle")
    public Result bookHandle(@RequestParam Integer id){
        Result result=productService.bookHandle(id);
        return result;
    }
}
