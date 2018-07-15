package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.ProductBookRequest;
import com.organOld.service.contract.ProductRequest;

import javax.servlet.http.HttpSession;

public interface ProductService {
    String getByPage(ProductRequest productRequest, BTableRequest bTableRequest);

    String getBookByPage(ProductBookRequest productBookRequest, BTableRequest bTableRequest);
}
