package com.organOld.service.wrapper;

import com.organOld.dao.entity.label.Label;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.model.LabelModel;
import com.organOld.service.util.Tool;
import com.organOld.service.contract.*;
import org.springframework.beans.BeanUtils;

public class LabelWrapper implements Wrapper<Label,LabelModel,LabelRequest> {

    @Override
    public LabelModel wrap(Label label) {
        LabelModel labelModel=new LabelModel();
        labelModel.setContent(label.getContent());
        labelModel.setFir(label.getLabelSec().getFirName());
        labelModel.setSec(label.getLabelSec().getSecName());
        labelModel.setId(label.getId());
        labelModel.setName(label.getName());
        labelModel.setRule(label.getRule());
        if(label.getOrgan()!=null)
        labelModel.setOrganName(label.getOrgan().getName());
        labelModel.setTime(Tool.dateToString(label.getTime(), TimeConstant.DATA_FORMAT_YMD));
        return labelModel;
    }

    @Override
    public Label unwrap(LabelRequest labelRequest) {
        Label label=new Label();
        BeanUtils.copyProperties(labelRequest,label);
        return label;
    }

}
