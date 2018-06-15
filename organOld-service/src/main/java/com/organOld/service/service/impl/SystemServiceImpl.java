package com.organOld.service.service.impl;

import com.organOld.dao.repository.MenuDao;
import com.organOld.dao.repository.SystemDao;
import com.organOld.dao.util.MenuTree;
import com.organOld.service.service.SystemService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by netlab606 on 2018/3/25.
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    MenuDao menuDao;
    @Autowired
    SystemDao systemDao;

    @Override
    public List<MenuTree> getMenu(HttpSession session) {
        UserDetails userDetails;
        List<String> authNameList=new ArrayList<>();
        if(SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal()!=null) {
            userDetails = (UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            for (GrantedAuthority authority:userDetails.getAuthorities()) {
                authNameList.add(authority.toString());
            }
            return menuDao.getMenuTreeByAuthentications(authNameList);
        }
        return new ArrayList<>();

    }

    @Override
    public void importExcel(MultipartFile file, String cType, String pType) throws IOException {
        List temp = new ArrayList();
        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {
            //如果当前行的行号（从0开始）未达到1（第二行）则从新循环
            if (r.getRowNum() == 0) {
                continue;
            }
            //创建实体类
//            if(pType.equals("oldman")){
//                Oldman oldman=new Oldman();
//                oldman.setName(r.getCell(0).getStringCellValue());
//                oldman.setSex((r.getCell(1).getStringCellValue().equals("男"))?"1":"0");
//                temp.add(oldman);
//            }
        }
        systemDao.importExcel(temp,cType,pType);
    }
}
