package com.organOld.service.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.record.Record;
import com.organOld.dao.repository.CardDao;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.RecordDao;
import com.organOld.dao.util.Page;
import com.organOld.service.constant.ValueConstant;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.CardRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.enumModel.RecordTypeEnum;
import com.organOld.service.model.CardModel;
import com.organOld.service.model.ExcelReturnModel;
import com.organOld.service.model.OldmanAllInfoModel;
import com.organOld.service.service.CardService;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OldmanService;
import com.organOld.service.service.RecordService;
import com.organOld.dao.util.bean.QrCodeData;
import com.organOld.service.wrapper.CardWrapper;
import com.swetake.util.Qrcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by netlab606 on 2018/6/25.
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardDao cardDao;
    @Autowired
    CommonService commonService;
    @Autowired
    RecordDao recordDao;
    @Autowired
    OldmanService oldmanService;
    @Autowired
    RecordService recordService;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    CardWrapper cardWrapper;


    @Override
    public String getByPage(CardRequest cardRequest, BTableRequest bTableRequest) {
        Page<Card> page=commonService.getPage(bTableRequest,"card");
        Card card= cardWrapper.unwrap(cardRequest);
        page.setEntity(card);
        List<CardModel> cardModelList=cardDao.getByPage(page).stream().map(cardWrapper::wrap).collect(Collectors.toList());
        Long size=cardDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,cardModelList);
    }

    @Override
    @Transactional
    public Result addMoney(String[] ids, Double money) {
        List<Record> recordList=new ArrayList<>();
        for(String id:ids){
            Card card=cardDao.getById(Integer.parseInt(id));
            Record record=new Record();
            record.setOldmanId(card.getOldmanId());
            record.setType(RecordTypeEnum.CQ.getIndex());
            record.setData(money+"");
            record.setPrevMoney(card.getMoney());
            record.setNowMoney(card.getMoney()+money);
            recordList.add(record);
        }
        cardDao.addMoney(ids,money);
        recordDao.saveAll(recordList);
        return new Result(true);
    }

    @Override
    public Result changeStatus(String[] ids, String status) {
        cardDao.updateProps("status",status,ids);
        return new Result(true);
    }

    @Override
    public Integer getIdByOldmanId(int oldmanId) {
        Card card=cardDao.getByOldmanId(oldmanId);
        if(card==null) return null;
        return card.getId();
    }

    @Override
    public OldmanAllInfoModel handleInfo(int cid, int organId) {
        Card card=cardDao.getByCid(cid);
        OldmanAllInfoModel oldmanAllInfoModel =oldmanService.getOldmanInfo(card.getOldmanId());

        Record record2=new Record();
        record2.setOldmanId(card.getOldmanId());
        record2.setType(RecordTypeEnum.INFO.getIndex());
        record2.setOrganId(organId);
        recordService.saveEntity(record2);
        return oldmanAllInfoModel;
    }

    @Override
    public Result handleIntegral(int cid, int organId) {
        Card card=cardDao.getByCid(cid);
        Result result = oldmanService.getIntegralByOldmanId(card.getOldmanId());
        Record record2=new Record();
        record2.setOldmanId(card.getOldmanId());
        record2.setType(RecordTypeEnum.IN.getIndex());
        record2.setOrganId(organId);
        recordService.saveEntity(record2);
        return result;
    }

    @Override
    @Transactional
    public Result handleSign(int cid, int organId) {
        Card card=cardDao.getByCid(cid);
        Oldman oldman=oldmanDao.getIntegralByOldmanId(card.getOldmanId());
        Record record2=new Record();
        record2.setOldmanId(card.getOldmanId());
        record2.setType(RecordTypeEnum.SIGN.getIndex());
        record2.setOrganId(organId);
        recordService.saveEntity(record2);
        //积分变动记录
        Record record=new Record();
        record.setType(RecordTypeEnum.JF.getIndex());
        record.setOrder("2");
        record.setOldmanId(card.getOldmanId());
        record.setData(ValueConstant.INTEGRAL_RULE_SIGN+"");
        record.setPrevMoney(Double.valueOf(oldman.getIntegral()));
        record.setNowMoney(Double.valueOf(oldman.getIntegral())+ValueConstant.INTEGRAL_RULE_SIGN);
        oldmanDao.addInregral(card.getOldmanId(),ValueConstant.INTEGRAL_RULE_SIGN);
        recordService.saveEntity(record);

        Result result=new Result(true,"签到成功");
        return result;
    }

    @Override
    public Result handleConsume(int cid, int organId, String order, String oldmanPassword, String m) {
        Double money=Double.parseDouble(m);
        Result check=checkCanConsume(cid,oldmanPassword,money);
        if(check.isSuccess()) {
            Card card = cardDao.getByCid(cid);
            Record record = new Record();
            record.setType(RecordTypeEnum.CONSUME.getIndex());
            record.setOrder(order);
            record.setOldmanId(card.getOldmanId());
            record.setData(money + "");
            record.setOrganId(organId);
            record.setPrevMoney(card.getMoney());
            record.setNowMoney(card.getMoney() - money);
            recordService.saveEntity(record);
            cardDao.updateProp("money",record.getNowMoney()+"",card.getId());
            Result result = new Result(true, "消费成功");
            return result;
        }else{
            Result result = new Result(false, "消费失败");
            return result;
        }
    }

    //TODO 老人密码验证
    private Result checkCanConsume(int cid, String oldmanPassword, Double money) {
        Card card=cardDao.getByCid(cid);
        if(card.getMoney()<money){
            return new Result(false,"消费失败，余额不足");
        }else{
            return new Result(true);
        }
    }

    @Override
    public Result create(String[] ids) {
        List<QrCodeData> qrCodeData=cardDao.getQrDataByIds(ids);
        ExcelReturnModel excelReturnModel=createCode(qrCodeData);
        excelReturnModel.setTotal(ids.length);
        excelReturnModel.setNumSuccess(qrCodeData.size());
        return new Result(true,excelReturnModel);

    }

    public ExcelReturnModel createCode(List<QrCodeData> qrCodeDataList){
       ExcelReturnModel excelReturnModel=new ExcelReturnModel();
       int sucessAdd=0,failNum=0;
       try {
           for (QrCodeData qrCodeData : qrCodeDataList) {
               Qrcode qrcode = new Qrcode();
               qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
               qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
               qrcode.setQrcodeVersion(7);//版本
               //生成二维码中要存储的信息
               String qrData = qrCodeData.getCid();
               //设置一下二维码的像素
               int width = 67 + 12 * (7 - 1);
               int height = 67 + 12 * (7 - 1);
               BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
               //绘图
               Graphics2D gs = bufferedImage.createGraphics();
               gs.setBackground(Color.WHITE);
               gs.setColor(Color.BLACK);
               gs.clearRect(0, 0, width, height);//清除下画板内容

               //设置下偏移量,如果不加偏移量，有时会导致出错。
               int pixoff = 2;

               byte[] d = qrData.getBytes("gb2312");
               if (d.length > 0 && d.length < 120) {
                   boolean[][] s = qrcode.calQrcode(d);
                   for (int i = 0; i < s.length; i++) {
                       for (int j = 0; j < s.length; j++) {
                           if (s[j][i]) {
                               gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                           }
                       }
                   }
               }
               gs.dispose();
               bufferedImage.flush();
               File file=new File(ValueConstant.CODE_CREATE_PATH + qrCodeData.getName() + ".png");
               if (!file.getParentFile().exists()) {
                   file.getParentFile().mkdirs();
               }
               ImageIO.write(bufferedImage, "png", file);
               sucessAdd++;
               cardDao.updateProp("is_create","1",qrCodeData.getId());
           }
       }catch (Exception e){
           e.printStackTrace();
           failNum++;
       }
       excelReturnModel.setSuccessAdd(sucessAdd);
       excelReturnModel.setNumFail(failNum);
        return excelReturnModel;
    }


    @Override
    public Result getById(Integer id) {
        return new Result(true,cardDao.getById(id));
    }

    @Override
    public void updateById(Card card) {
        cardDao.updateById(card);
    }
}
