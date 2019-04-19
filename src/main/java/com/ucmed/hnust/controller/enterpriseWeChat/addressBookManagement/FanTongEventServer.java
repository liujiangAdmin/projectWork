package com.ucmed.hnust.controller.enterpriseWeChat.addressBookManagement;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.controller.enterpriseWeChat.PublicVariable;
import com.ucmed.hnust.controller.enterpriseWeChat.TokenUtil;
import com.ucmed.hnust.util.HttpRequestGet;
import com.ucmed.hnust.util.weixin.WXBizMsgCrypt;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 设置饭桶应消息接收服务器
 * Created by ZY-LJ-1446 on 2018/4/26.
 */
@Controller
@RequestMapping(value = "/fantong")
public class FanTongEventServer {
    Logger logger = Logger.getLogger(AddressListEventServer.class);

    @Autowired
    private TokenUtil tokenUtil;
    /**
     * 设置饭桶接收事件服务器
     * */
    @ResponseBody
    @RequestMapping(value = "/yzurl", method = RequestMethod.GET)
    public String operation(HttpServletRequest request) {
        String res = null;
        try {
            String msg_signature = request.getParameter("msg_signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");
            String echostr = request.getParameter("echostr");
            WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(PublicVariable.fantongstoken, PublicVariable.fantongsencodingaeskey, PublicVariable.corpid);
            res = wxBizMsgCrypt.VerifyURL(msg_signature, timestamp, nonce, echostr);
            logger.info("res:" + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 接收饭桶消息接收事件
     */
    @ResponseBody
    @RequestMapping(value = "/yzurl", method = RequestMethod.POST)
    public String operation1(HttpServletRequest request) {
        String encryptres=null;
        try {
            //获取post请求url参数和body体包裹参数
            String msgSignature = request.getParameter("msg_signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuffer buffer = new StringBuffer(1024);
            String line = "";
            while ((line = inputStream.readLine()) != null) {
                buffer.append(line);
            }
            String postData = buffer.toString();
            WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(PublicVariable.fantongstoken, PublicVariable.fantongsencodingaeskey, PublicVariable.corpid);
            String res = wxBizMsgCrypt.DecryptMsg(msgSignature, timestamp, nonce, postData);
            logger.info("解密后内容:"+res);
            String removeStr3="<![CDATA[";
            String removeStr4="]]>";
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new StringReader(res));
            Element rootElement = document.getRootElement();
            String ToUserName = rootElement.elementText("ToUserName").replace(removeStr3,"").replace(removeStr4,"").trim();
            String FromUserName = rootElement.elementText("FromUserName").replace(removeStr3,"").replace(removeStr4,"").trim();
            String CreateTime = rootElement.elementText("CreateTime").trim();
            String MsgType = rootElement.elementText("MsgType").replace(removeStr3,"").replace(removeStr4,"").trim();
            String Event = rootElement.elementText("Event").replace(removeStr3,"").replace(removeStr4,"").trim();
            String EventKey = rootElement.elementText("EventKey").replace(removeStr3,"").replace(removeStr4,"").trim();
            String AgentID = rootElement.elementText("AgentID").replace(removeStr3,"").replace(removeStr4,"").trim();
            Map<String, Object> map = new HashMap<>();
            map.put("access_token",tokenUtil.getzjyyTokenImpl(PublicVariable.fantongsecret));
            map.put("userid",FromUserName);
            JSONObject res1 =  HttpRequestGet.sendGet(PublicVariable.dqcy,map,"utf-8");

            StringBuilder sb = new StringBuilder();
            sb.append("<xml><ToUserName><![CDATA[");
            sb.append(FromUserName);
            sb.append("]]></ToUserName><FromUserName><![CDATA[");
            sb.append(PublicVariable.corpid);
            sb.append("]]></FromUserName><CreateTime>");
            sb.append(String.valueOf(System.currentTimeMillis()).substring(0,10));
            sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");
            sb.append(res1.getString("name"));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            String a = simpleDateFormat.format(new Date());
            String b ="17:00:00";
            String c ="13:00:00";
            if(a.compareTo(b)>0 || a.compareTo(c)<0)
            {
                sb.append("你好，已超过订餐时间，订餐时间 13:00 -- 17:00。]]></Content></xml>");
            }else{
                sb.append("你好，订餐成功。]]></Content></xml>");
            }

            String timestamp1=String.valueOf(System.currentTimeMillis()).substring(0,10);
            String nonce1=String.valueOf(System.currentTimeMillis()).substring(0,10);
            encryptres=wxBizMsgCrypt.EncryptMsg(sb.toString(),timestamp1,nonce1);
            logger.info("加密后内容:"+encryptres);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptres;
    }
}
