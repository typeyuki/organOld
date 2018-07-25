package com.organOld.dao.repository;

import com.organOld.dao.entity.record.Record;
import com.organOld.dao.util.Page;

import java.util.List;

public interface RecordDao extends BaseDao<Record,Number> {
    List<Record> getByCardPage(Page<Record> page);

    Long getSizeByCardPage(Page<Record> page);
}
