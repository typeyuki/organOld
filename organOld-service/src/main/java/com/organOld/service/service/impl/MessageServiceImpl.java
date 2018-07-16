package com.organOld.service.service.impl;

import com.organOld.dao.entity.Message;
import com.organOld.dao.repository.MessageDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.MessageRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.model.MessageModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.MessageService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;
    @Autowired
    CommonService commonService;

    @Override
    public String getByPage(MessageRequest messageRequest, BTableRequest bTableRequest) {
        Page<Message> page=commonService.getPage(bTableRequest,"message");
        Message message= Wrappers.messageWrapper.unwrap(messageRequest);
        String username=commonService.getUserNameBySession();
        message.setUsername(username);
        page.setEntity(message);
        List<MessageModel> messageModelList=messageDao.getByPage(page).stream().map(Wrappers.messageWrapper::wrap).collect(Collectors.toList());
        Long size=messageDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,messageModelList);
    }

    @Override
    public Result read() {
        String username=commonService.getUserNameBySession();
        messageDao.readByUsername(username);
        return new Result(true);
    }

    @Override
    public int getNoReadNum() {
        String username=commonService.getUserNameBySession();
        return messageDao.getNoReadNumByUsername(username);
    }
}
