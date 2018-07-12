package com.organOld.service.dwr;

import com.organOld.service.model.DwrData;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by admin on 2017/4/4.
 */
@Component
public class Remote {


//    public static Map<String,String> user=new HashMap<String,String>();

    //实现 筛选 发送推送
//    public void getData(String userCode) {
//        noticeNewOrder("123",userCode);
//    }

    // 得到推送信息并推送  预警推送
    public static void noticeNewOrder(final DwrData dwrData) {

        Runnable run = new Runnable(){
            private ScriptBuffer script = new ScriptBuffer();
            public void run() {
                //设置要调用的 js及参数
                script.appendCall("finish",dwrData);
//                script.appendCall("warn" ,type, obj);
                //得到所有ScriptSession
                Collection<ScriptSession> sessions = Browser.getTargetSessions();
                //遍历每一个ScriptSession
                for (ScriptSession scriptSession : sessions){
                    scriptSession.addScript( script);
                }
            }
        };
        Browser. withAllSessions(run);

    }


}
