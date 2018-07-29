package com.organOld.service.wrapper;

import com.organOld.dao.entity.product.Product;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.model.ProductModel;
import com.organOld.service.util.ImgUpload;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;

import java.io.IOException;


public class ProductWrapper implements Wrapper<Product,ProductModel,ProductRequest> {

    @Override
    public ProductModel wrap(Product product) {
        ProductModel productModel=new ProductModel();
        BeanUtils.copyProperties(product,productModel);
        productModel.setTime(Tool.dateToString(product.getTime(), TimeConstant.DATA_FORMAT_YMD));
        return productModel;
    }

    @Override
    public Product unwrap(ProductRequest productRequest) {
        Product product=new Product();
        if(productRequest.getPrice()!=null && !productRequest.getPrice().equals(""))
            product.setPrice(Double.parseDouble(productRequest.getPrice()));
        product.setIntro(productRequest.getIntro());
        if(productRequest.getId()!=null)
        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setOrganId(productRequest.getOrganId());
        return product;
    }
}
