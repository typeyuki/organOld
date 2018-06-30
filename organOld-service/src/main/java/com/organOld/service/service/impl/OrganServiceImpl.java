package com.organOld.service.service.impl;

import com.organOld.dao.entity.SysUser;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.entity.organ.OrganReg;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.OrganOldmanDao;
import com.organOld.dao.repository.OrganRegDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OrganOldmanRequest;
import com.organOld.service.contract.OrganRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.model.OrganModel;
import com.organOld.service.model.OrganOldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OrganService;
import com.organOld.service.service.UserService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import java.util.Properties;
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
//        OrganReg organReg=organRegDao.getByOrganId(organId);
//        SysUser user=newAccount(organId);

        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", "smtp.163.com");   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        try {

        MimeMessage message = createMimeMessage(session, "wisher1263@163.com", "601011162@qq.com");

        // 4. 根据 Session 获取邮件传输对象
        Transport transport = null;
            transport = session.getTransport();

            transport.connect("wisher1263@163.com","shi8808125");

            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());

            // 7. 关闭连接
            transport.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(true);
    }

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, "某宝网", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject("打折钜惠", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent("XX用户你好, 今天全场5折, 快来抢购, 错过今天再等一年。。。", "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }


    /**
     * 为机构注册新账号
     * @param organId
     */
    @Transactional
    SysUser newAccount(int organId) {
        SysUser user=createUser(organId);
        userService.saveAndReturn(user);
        userService.setUserRole(user.getId(),3);
        userService.setUserOrgan(user.getId(),organId);
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


}
