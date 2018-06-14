package com.organOld.service.service;


import com.organOld.dao.util.MenuTree;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by netlab606 on 2018/3/25.
 */
public interface SystemService {
    List<MenuTree> getMenu(HttpSession session);

    void importExcel(MultipartFile file, String cType, String pType) throws IOException;
}
