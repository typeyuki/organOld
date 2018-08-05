package com.organOld.service.wrapper;

import com.organOld.dao.entity.Message;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.MessageRequest;
import com.organOld.service.enumModel.MessageTypeEnum;
import com.organOld.service.model.MessageModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MessageWrapper implements Wrapper<Message,MessageModel,MessageRequest> {


    @Override
    public MessageModel wrap(Message message) {
        MessageModel messageModel=new MessageModel();
        messageModel.setContent(message.getContent());
        messageModel.setTypeName(MessageTypeEnum.getValue(message.getType()));
        messageModel.setOrgan(message.getOrgan());
        messageModel.setTime(Tool.dateToString(message.getTime(), TimeConstant.DATA_FORMAT_YMD));
        messageModel.setIdAndIsRead(message.getId()+"#"+message.getIsRead());
        return messageModel;
    }

    @Override
    public Message unwrap(MessageRequest messageRequest) {
        Message message=new Message();
        BeanUtils.copyProperties(messageRequest,message);
        return message;
    }
}
