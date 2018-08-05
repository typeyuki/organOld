package com.organOld.service.wrapper;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.volunteer.Volunteer;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.ProductRequest;
import com.organOld.service.contract.VolunteerRequest;
import com.organOld.service.model.ProductModel;
import com.organOld.service.model.VolunteerModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VolunteerWrapper implements Wrapper<Volunteer,VolunteerModel,VolunteerRequest> {

    @Override
    public VolunteerModel wrap(Volunteer volunteer) {
        VolunteerModel volunteerModel=new VolunteerModel();
        volunteerModel.setId(volunteer.getId());
        volunteerModel.setOldmanId(volunteer.getOldman().getId());
        volunteerModel.setOldmanName(volunteer.getOldman().getName());
        volunteerModel.setTime(Tool.dateToString(volunteer.getTime(),TimeConstant.DATA_FORMAT_YMD));
        return volunteerModel;
    }

    @Override
    public Volunteer unwrap(VolunteerRequest volunteerRequest) {
        Volunteer volunteer=new Volunteer();
        BeanUtils.copyProperties(volunteerRequest,volunteer);
        return volunteer;
    }
}
