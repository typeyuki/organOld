package com.organOld.service.service.impl;

import com.organOld.dao.entity.SysAuthority;
import com.organOld.dao.repository.UserDao;
import com.organOld.dao.entity.SysUser;
import com.organOld.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by netlab606 on 2018/4/8.
 */
@Service
public class UserServiceImpl implements UserService {

@Autowired
    UserDao userDao;


    @Override
    public SysUser getByUsername(String username) {
        return userDao.getByUsername(username);
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

}
