package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.OldmanKeyHandle;

public interface OldmanKeyHandleDao extends BaseDao<OldmanKeyHandle,Number> {
    OldmanKeyHandle getByOldmanId(int oldmanId);

    void updateByOldmanId(OldmanKeyHandle oldmanKeyHandle);

    void delByOldmanId(int oldmanId);
}
