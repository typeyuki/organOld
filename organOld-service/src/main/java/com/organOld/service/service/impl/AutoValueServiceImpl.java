package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.service.service.AutoValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoValueServiceImpl implements AutoValueService {

    @Autowired
    AutoValueDao autoValueDao;

    @Override
    public List<AutoValue> getByType(int type) {
        return autoValueDao.getByType(type);
    }
}
