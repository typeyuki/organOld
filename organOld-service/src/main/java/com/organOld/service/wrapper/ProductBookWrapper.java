package com.organOld.service.wrapper;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductBook;
import com.organOld.dao.repository.ProductDao;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.ProductBookRequest;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.model.ProductBookModel;
import com.organOld.service.model.ProductModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class ProductBookWrapper implements Wrapper<ProductBook,ProductBookModel,ProductBookRequest> {


    @Override
    public ProductBookModel wrap(ProductBook productBook) {
        ProductBookModel productBookModel=new ProductBookModel();
        productBookModel.setId(productBook.getId());
        productBookModel.setTime(Tool.dateToString(productBook.getTime(),TimeConstant.DATA_FORMAT_YMD));
        productBookModel.setIds(productBook.getProductIds());
        productBookModel.setOldman(productBook.getOldman());
        productBookModel.setStatus(productBook.getStatus());
        return productBookModel;
    }

    @Override
    public ProductBook unwrap(ProductBookRequest productBookRequest) {
        ProductBook productBook=new ProductBook();
        BeanUtils.copyProperties(productBookRequest,productBook);
        return productBook;
    }
}
