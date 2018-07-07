package com.organOld.service.service.impl;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductBook;
import com.organOld.dao.repository.ProductBookDao;
import com.organOld.dao.repository.ProductDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.ProductBookRequest;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.model.ProductBookModel;
import com.organOld.service.model.ProductModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.ProductService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    CommonService commonService;
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductBookDao productBookDao;

    @Override
    public String getByPage(ProductRequest productRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<Product> page=commonService.getPage(bTableRequest,"product");
        Product product= Wrappers.productWrapper.unwrap(productRequest);
        commonService.checkIsOrgan(product);
        page.setEntity(product);
        List<ProductModel> productModelList=productDao.getByPage(page).stream().map(Wrappers.productWrapper::wrap).collect(Collectors.toList());
        Long size=productDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }

    @Override
    public String getBookByPage(ProductBookRequest productBookRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<ProductBook> page=commonService.getPage(bTableRequest,"product_book");
        ProductBook productBook= Wrappers.productBookWrapper.unwrap(productBookRequest);
        commonService.checkIsOrgan(productBook);
        page.setEntity(productBook);
        List<ProductBookModel> productBookModelList=productBookDao.getByPage(page).stream().map(Wrappers.productBookWrapper::wrap).collect(Collectors.toList());
        Long size=productBookDao.getSizeByPage(page);


        //TODO  先获得 改机构所有的 商品 做缓存  减少查询次数
        for(ProductBookModel book:productBookModelList){
            String[] ids=book.getIds().split("#");
            List<Product> productList=new ArrayList<>();
            for(int i=0;i<ids.length;i++){
                Product product=productDao.getById(ids[i]);
                productList.add(product);
            }
            book.setProductList(productList);
        }

        return commonService.tableReturn(bTableRequest.getsEcho(),size,productBookModelList);
    }
}
