package com.organOld.service.service.impl;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductBook;
import com.organOld.dao.entity.record.Record;
import com.organOld.dao.repository.ProductBookDao;
import com.organOld.dao.repository.ProductDao;
import com.organOld.dao.repository.RecordDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.ProductBookRequest;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.contract.RecordRequest;
import com.organOld.service.model.ProductBookModel;
import com.organOld.service.model.ProductModel;
import com.organOld.service.model.RecordModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.ProductService;
import com.organOld.service.service.RecordService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    CommonService commonService;
    @Autowired
    RecordDao recordDao;

    @Override
    public String getByPage(RecordRequest recordRequest, BTableRequest bTableRequest) {
        Page<Record> page=commonService.getPage(bTableRequest,"record");
        Record record= Wrappers.recordWrapper.unwrap(recordRequest);
        if(record.getOrganId()==null || record.getOrganId()==0){
            //机构账号页面
            commonService.checkIsOrgan(record);
        }
        page.setEntity(record);
        List<RecordModel> productModelList=recordDao.getByPage(page).stream().map(Wrappers.recordWrapper::wrap).collect(Collectors.toList());
        Long size=recordDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }



}
