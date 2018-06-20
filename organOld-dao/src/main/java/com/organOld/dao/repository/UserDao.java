package com.organOld.dao.repository;


import com.organOld.dao.entity.SysAuthority;
import com.organOld.dao.entity.SysUser;


import java.util.List;

/**
 * Created by netlab606 on 2018/3/24.
 */
public interface UserDao {
    SysUser getByUsername(String username);

    List<SysAuthority> getSysAuthoritiesByUsername(String username);

    Integer getOrganIdByUsername(String username);
}
