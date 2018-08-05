package com.organOld.service.service;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.Xq;
import com.organOld.service.contract.AutoValueRequest;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.Result;

import java.util.List;

public interface AutoValueService {
    List<AutoValue> getByType(int index);

    String getByPage(AutoValueRequest autoValueRequest, BTableRequest bTableRequest);

    Result getById(int id);

    void handle(String type, AutoValue autoValue);

    void delByIds(String[] ids);

    List<AutoValue> getByIds(String[] sq);

    Xq getXqById(Integer xqId);

    List<AutoValue> getByTypeList(List<Integer> type);

    List<Integer> getXqIdsByJwIds(String[] jw);

    List<Integer> getXqIdsByPqIds(String[] district);

    List<Integer> getXqIdsByUsername(String userNameBySession);
}
