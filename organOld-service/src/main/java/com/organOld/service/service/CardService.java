package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.CardRequest; /**
 * Created by netlab606 on 2018/6/25.
 */
public interface CardService {
    String getByPage(CardRequest cardRequest, BTableRequest bTableRequest);
}
