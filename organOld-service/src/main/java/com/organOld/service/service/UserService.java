package com.organOld.service.service;

import com.organOld.dao.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by netlab606 on 2018/4/8.
 */
public interface UserService {
    SysUser getByUsername(String username);

    Collection<GrantedAuthority> loadUserAuthorities(String username);
}
