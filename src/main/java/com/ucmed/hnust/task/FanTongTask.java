package com.ucmed.hnust.task;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.controller.enterpriseWeChat.PublicVariable;
import com.ucmed.hnust.controller.enterpriseWeChat.TokenUtil;
import com.ucmed.hnust.controller.enterpriseWeChat.addressBookManagement.PersonalApplication;
import com.ucmed.hnust.util.HttpRequestPost;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by ZY-LJ-1446 on 2018/4/26.
 */
@Service
public class FanTongTask {

    private static final Logger logger = Logger.getLogger(FanTongTask.class);
    @Autowired
    private TokenUtil tokenUtil;

    @Scheduled(cron = "0 0/30 * * * ?")
    public void notice() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser","@all");
        jsonObject.put("msgtype","text");
        jsonObject.put("agentid",PublicVariable.fantongid);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("content","饭桶时间到了，来一桶[奸笑]？饭桶时间 13:00 -- 17:00");
        jsonObject.put("text",jsonObject1);
        String res= HttpRequestPost.HttpRequest(PublicVariable.fsxx+tokenUtil.getzjyyTokenImpl(PublicVariable.fantongsecret),
                "POST",jsonObject.toString());
        logger.info("fantongResult:"+res);

    }
}
