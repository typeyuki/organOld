package com.organOld.service.service;

import com.organOld.dao.entity.AutoValue;

import java.util.List;

public interface AutoValueService {
    List<AutoValue> getByType(int index);
}
