package com.organOld.service.service.impl;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.repository.OldmanKeyDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.model.LinkmanModel;
import com.organOld.service.model.OldmanKeyModel;
import com.organOld.service.model.OldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OldmanKeyService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OldmanKeyServiceImpl implements OldmanKeyService {

    @Autowired
    CommonService commonService;
    @Autowired
    OldmanKeyDao oldmanKeyDao;

    @Override
    public String getByPage(BTableRequest bTableRequest, HttpSession session, OldmanKeyRequest oldmanKeyRequest) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_key");
        Oldman oldman= Wrappers.oldmanKeyWrapper.unwrap(oldmanKeyRequest);
        commonService.checkIsJw(session,oldman);
        page.setEntity(oldman);
        List<OldmanKeyModel> oldmanKeyModelList=oldmanKeyDao.getByPage(page).stream().map(Wrappers.oldmanKeyWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanKeyDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanKeyModelList);
    }

    @Override
    public Result updateMan() {
        return null;
    }
}
