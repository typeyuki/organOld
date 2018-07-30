package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.ProductBookRequest;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.contract.Result;

import javax.servlet.http.HttpServletRequest;

public interface ProductService {
    String getByPage(ProductRequest productRequest, BTableRequest bTableRequest);

    String getBookByPage(ProductBookRequest productBookRequest, BTableRequest bTableRequest);

    void addOrUpdate(ProductRequest product, String type, HttpServletRequest request);

    Result bookHandle(Integer id);
}
