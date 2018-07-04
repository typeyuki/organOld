package com.organOld.service.wrapper;

import com.organOld.dao.entity.product.Product;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.model.ProductModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;


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
        BeanUtils.copyProperties(productRequest,product);
        return product;
    }
}
