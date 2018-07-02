package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.SysUser;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.entity.organ.OrganReg;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.*;
import com.organOld.service.enumModel.OrganFirEnum;
import com.organOld.service.model.OrganModel;
import com.organOld.service.model.OrganOldmanModel;
import com.organOld.service.model.OrganRegInfoModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OrganService;
import com.organOld.service.service.UserService;
import com.organOld.service.util.Email;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class OrganServiceImpl implements OrganService{

    @Autowired
    OrganDao organDao;
    @Autowired
    CommonService commonService;
    @Autowired
    OrganOldmanDao organOldmanDao;
    @Autowired
    UserService userService;
    @Autowired
    OrganRegDao organRegDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    OrganTypeDao organTypeDao;


    @Override
    public String getByPage(OrganRequest organRequest, BTableRequest bTableRequest) {
        Page<Organ> page=commonService.getPage(bTableRequest,"organ");
        Organ organ= Wrappers.organWrapper.unwrap(organRequest);
        page.setEntity(organ);
        List<OrganModel> organModelList=organDao.getByPage(page).stream().map(Wrappers.organWrapper::wrap).collect(Collectors.toList());
        Long size=organDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organModelList);
    }

    @Override
    public String getManByPage(BTableRequest bTableRequest, OrganOldmanRequest organOrganManRequest) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"organ_man");
        OrganOldman organOldman= Wrappers.organOldmanWrapper.unwrap(organOrganManRequest);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public OrganModel getBySession(HttpSession httpSession) {
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username=userDetails.getUsername();
        OrganModel organModel=Wrappers.organWrapper.wrap(organDao.getByUsername(username));
        return organModel;
    }

    @Override
    public OrganModel getById(int organId) {
        return null;
    }

    @Override
    public Result pass(int organId) {
        Organ organ=new Organ();
        organ.setId(organId);
        organ.setStatus("2");
        organDao.updateById(organ);

        OrganReg organReg=organRegDao.getByOrganId(organId);
        SysUser user=newAccount(organId);
        String content=String.format("您的账号:%s<br>密码：%s",user.getUsername(),user.getPassword());
        Email.send(organReg.getEmail(),content);

        return new Result(true);
    }

    @Override
    public Result reject(int organId) {
        OrganReg organReg=organRegDao.getByOrganId(organId);
        String content=String.format("抱歉您的审核未通过");
        Email.send(organReg.getEmail(),content);

        Organ organ=new Organ();
        organ.setId(organId);
        organ.setStatus("3");
        organDao.updateById(organ);
        return new Result(true);
    }

    /**
     * 为机构注册新账号
     * @param organId
     */
    @Transactional
    SysUser newAccount(int organId) {
        SysUser user=createUser(organId);
        userService.save(user);
        userService.setUserOrgan(user.getId(),organId);

        Organ auths=organDao.getAuthById(organId);
        int goal;//商品 1  消费2 签到4     总分 0无特殊权限 1 商品权限 2消费权限 4 签到权限 3商品+消费权限

        goal=auths.getAuthConsume()+auths.getAuthProduct()+auths.getAuthProduct();
        switch (goal){
            case 0:
                userService.setUserRole(user.getId(),3);
                break;
            case 1:
                userService.setUserRole(user.getId(),8);
                break;
            case 2:
                userService.setUserRole(user.getId(),6);
                break;
            case 3:
                userService.setUserRole(user.getId(),9);
                break;
            case 4:
                userService.setUserRole(user.getId(),7);
                break;
            default:
                break;
        }

        return user;
    }

    private SysUser createUser(int organId) {
        SysUser sysUser=new SysUser();
        String username="Organ"+organId;
        String password="000000";
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        return sysUser;
    }


    @Override
    public OrganRegInfoModel getRegInfo() {
        OrganRegInfoModel organRegInfoModel=new OrganRegInfoModel();
        List<Integer> typeList=commonService.getAutoValueTypes("organ_reg");
        List<AutoValue> district=autoValueDao.getByTypeList(typeList);
        organRegInfoModel.setDistrict(district);
        organRegInfoModel.setOrganTypeList(organTypeDao.getByFirType(OrganFirEnum.SH.getIndex()));
        return organRegInfoModel;
    }

    @Override
    @Transactional
    public Result reg(OrganRegRequest organRegRequest, HttpServletRequest request) {
        Organ organ=Wrappers.organWrapper.unwrapRegOrgan(organRegRequest,request);
        OrganReg organReg=Wrappers.organWrapper.unwrapRegOrganReg(organRegRequest);
        organDao.save(organ);
        organReg.setOrganId(organ.getId());
        organRegDao.save(organReg);
        return new Result(true,"注册成功！请等待审核");
    }


    @Override
    public Result getRoleOrgan(int type, int typeIndex) {
        return new Result(true,organDao.getRoleOrgan(type,typeIndex));
    }
}
