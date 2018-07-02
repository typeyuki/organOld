package com.organOld.service.wrapper;

import com.organOld.dao.entity.SysUser;
import com.organOld.dao.entity.oldman.OldmanFamily;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.OldmanFamilyRequest;
import com.organOld.service.contract.UserRequest;
import com.organOld.service.model.OldmanFamilyModel;
import com.organOld.service.model.UserModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;


public class UserWrapper implements Wrapper<SysUser,UserModel,UserRequest> {

    @Override
    public UserModel wrap(SysUser sysUser) {
        UserModel userModel=new UserModel();
        userModel.setId(sysUser.getId());
        userModel.setPassword(sysUser.getPassword());
        userModel.setUsername(sysUser.getUsername());
        userModel.setRoleDesc(sysUser.getRoleDesc());
        userModel.setTime(Tool.dateToString(sysUser.getTime(), TimeConstant.DATA_FORMAT_YMD));
        return userModel;
    }

    @Override
    public SysUser unwrap(UserRequest userRequest) {
        return null;
    }
}
