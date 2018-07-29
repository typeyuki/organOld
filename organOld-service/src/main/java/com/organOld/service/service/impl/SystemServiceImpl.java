package com.organOld.service.service.impl;

import com.organOld.dao.repository.MenuDao;
import com.organOld.dao.repository.SystemDao;
import com.organOld.dao.util.MenuTree;
import com.organOld.service.contract.ExportTableThRequest;
import com.organOld.service.service.SystemService;
import com.organOld.service.util.ExcelUtil;
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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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
        try{
            if(SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal()!=null) {
                userDetails = (UserDetails) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();
                for (GrantedAuthority authority:userDetails.getAuthorities()) {
                    authNameList.add(authority.toString());
                }
            }
        }catch (Exception e){

        }finally {
            if(authNameList.size()==0)
                return new ArrayList<>();
            return menuDao.getMenuTreeByAuthentications(authNameList);
        }
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

    @Override
    public void export(HttpServletResponse response, ExportTableThRequest exportTableThRequest) {

        //excel标题
        String[] title = {"名称","性别","年龄","学校","班级"};

        //excel文件名
        String fileName = "学生信息表"+System.currentTimeMillis()+".xls";

        String sheetName = "学生信息表";
        String[][] content=new String[1][];
        content[0] = new String[5];
        content[0][0] = "1";
        content[0][1] ="2";
        content[0][2] = "3";
        content[0][3] = "4";
        content[0][4] ="5";
//创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

//响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="+fileName);
//            response.setContentType("application/octet-stream;charset=ISO8859-1");
//            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
//            response.addHeader("Pargam", "no-cache");
//            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
