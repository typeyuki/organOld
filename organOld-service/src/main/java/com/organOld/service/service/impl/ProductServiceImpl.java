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
import com.organOld.service.util.ImgUpload;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    public String getByPage(ProductRequest productRequest, BTableRequest bTableRequest) {
        Page<Product> page=commonService.getPage(bTableRequest,"product");
        Product product= Wrappers.productWrapper.unwrap(productRequest);
        if(product.getOrganId()==null || product.getOrganId()==0){
            //机构账号页面
            commonService.checkIsOrgan(product);
        }
        page.setEntity(product);
        List<ProductModel> productModelList=productDao.getByPage(page).stream().map(Wrappers.productWrapper::wrap).collect(Collectors.toList());
        Long size=productDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }

    @Override
    public String getBookByPage(ProductBookRequest productBookRequest, BTableRequest bTableRequest) {
        Page<ProductBook> page=commonService.getPage(bTableRequest,"product_book");
        ProductBook productBook= Wrappers.productBookWrapper.unwrap(productBookRequest);
        if(productBook.getOrganId()==null || productBook.getOrganId()==0){
            //机构账号页面
            commonService.checkIsOrgan(productBook);
        }
        commonService.checkIsOrgan(productBook);
        page.setEntity(productBook);
        List<ProductBookModel> productBookModelList=productBookDao.getByPage(page).stream().map(Wrappers.productBookWrapper::wrap).collect(Collectors.toList());
        Long size=productBookDao.getSizeByPage(page);


        //TODO  先获得 该机构所有的 商品 做缓存  减少查询次数
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


    @Override
    public void addOrUpdate(ProductRequest productRequest, String type, HttpServletRequest request) {
        Product product=Wrappers.productWrapper.unwrap(productRequest);
        if(!productRequest.getPic().isEmpty()){
            try {
                String path= ImgUpload.uploadFile(productRequest.getPic(), request,"product");
                int index = path.indexOf("img");
                String picUrl= path.substring(index, path.length());
                product.setImgUrl(picUrl);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        Integer organId=commonService.getIdBySession();
        product.setOrganId(organId);
        if(type.equals("add"))
            productDao.save(product);
        else
            productDao.updateById(product);
    }
}
