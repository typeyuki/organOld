package com.organOld.service.service.impl;

import com.organOld.dao.entity.SysAuthority;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.repository.UserDao;
import com.organOld.dao.entity.SysUser;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.contract.UserRequest;
import com.organOld.service.model.OldmanModel;
import com.organOld.service.model.UserModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.UserService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by netlab606 on 2018/4/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    CommonService commonService;


    @Override
    public SysUser getByUsername(String username) {
        SysUser s=userDao.getByUsername(username);
        return s;
    }

    /**
     * 根据用户名获取到用户的权限并封装成GrantedAuthority集合
     * @param username
     */
    @Override
    public Collection<GrantedAuthority> loadUserAuthorities(String username) {
        List<SysAuthority> list = userDao.getSysAuthoritiesByUsername(username);

        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        for (SysAuthority authority : list) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuName());
            auths.add(grantedAuthority);
        }

        return auths;
    }


    @Override
    public void save(SysUser user) {
        userDao.save(user);
    }

    @Override
    public void setUserRole(int id, int i) {
        userDao.setUserRole(id,i);
    }

    @Override
    public void setUserOrgan(int id, int organId) {
        userDao.setUserOrgan(id,organId);
    }


    @Override
    public String getByPage(UserRequest userRequest, BTableRequest bTableRequest) {
        Page<SysUser> page=commonService.getPage(bTableRequest,"user");
        SysUser sysUser=new SysUser();
        page.setEntity(sysUser);
        List<UserModel> userModelList=userDao.getByPage(page).stream().map(Wrappers.userWrapper::wrap).collect(Collectors.toList());
        Long size=userDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,userModelList);
    }
}
