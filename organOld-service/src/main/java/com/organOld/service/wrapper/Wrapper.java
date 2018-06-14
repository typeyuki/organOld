package com.organOld.service.wrapper;

import com.alibaba.fastjson.JSONObject;
import com.organOld.dao.entity.DBEntity;


import java.util.List;

//转换器  T：entity R：com.organOld.service.model S：request
public interface Wrapper<T extends DBEntity,R,S> {
    R wrap(T t); //数据库实体 转换为 模型
    T unwrap(S s);//前端request 转为为数据库实体
}
