package com.organOld.service.wrapper;

import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganReg;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.OrganRegRequest;
import com.organOld.service.contract.OrganRequest;
import com.organOld.service.model.OrganModel;
import com.organOld.service.util.ImgUpload;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class OrganWrapper implements Wrapper<Organ,OrganModel,OrganRequest> {

    @Override
    public OrganModel wrap(Organ organ) {
        OrganModel organModel=new OrganModel();
        BeanUtils.copyProperties(organ,organModel);
        if(organ.getTime()!=null)
        organModel.setTime(Tool.dateToString(organ.getTime(), TimeConstant.DATA_FORMAT_YMD));
        return organModel;
    }

    @Override
    public Organ unwrap(OrganRequest organRequest) {
        Organ organ=new Organ();
        BeanUtils.copyProperties(organRequest,organ);
        organ.setOrganFirTypeId(organRequest.getType());
        return organ;
    }


    public Organ unwrapRegOrgan(OrganRegRequest organRegRequest, HttpServletRequest request) {
        Organ organ=new Organ();
        BeanUtils.copyProperties(organRegRequest,organ);
        organ.setPhone(organRegRequest.getOrgPhone());
        organ.setStatus("1");
        if(organRegRequest.getAuth()!=null && organRegRequest.getAuth().length>0){
            List<String> auths= Arrays.asList(organRegRequest.getAuth());
            if(auths.contains("sign"))organ.setAuthSign(1);else organ.setAuthSign(0);
            if(auths.contains("product"))organ.setAuthProduct(1);else organ.setAuthProduct(0);
            if(auths.contains("consume"))organ.setAuthConsume(1);else organ.setAuthConsume(0);
            if(auths.contains("info"))organ.setAuthConsume(1);else organ.setAuthConsume(0);
            if(auths.contains("integral"))organ.setAuthConsume(1);else organ.setAuthConsume(0);
        }else{
            organ.setAuthSign(0);
            organ.setAuthProduct(0);
            organ.setAuthConsume(0);
            organ.setAuthQueryInfo(0);
            organ.setAuthQueryIntegral(0);
        }
        if(organRegRequest.getPic()!=null){
            try {
                String path= ImgUpload.uploadFile(organRegRequest.getPic(), request,"organ");
                int index = path.indexOf("img");
                String picUrl= path.substring(index, path.length());
                organ.setImgUrl(picUrl);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        return organ;
    }

    public OrganReg unwrapRegOrganReg(OrganRegRequest organRegRequest) {
        OrganReg organReg=new OrganReg();
        BeanUtils.copyProperties(organRegRequest,organReg);
        return organReg;
    }
}
