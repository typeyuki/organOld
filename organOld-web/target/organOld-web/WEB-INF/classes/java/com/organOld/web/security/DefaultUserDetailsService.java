package com.organOld.web.security;


import com.organOld.dao.entity.SysUser;
import com.organOld.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by netlab606 on 2018/4/8.
 */
public class DefaultUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserCache userCache;
    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//        User user = (User) this.userCache.getUserFromCache(username);

//        if(user == null){
            SysUser user = userService.getByUsername(username);
            if(user == null)
                throw new UsernameNotFoundException("UserDetailsService.userNotFount");
            //得到用户的权限
            auths = userService.loadUserAuthorities( username );
            user.setAuthorities(auths);
//        }

//        this.userCache.putUserInCache(user);
        return user;
    }
}
