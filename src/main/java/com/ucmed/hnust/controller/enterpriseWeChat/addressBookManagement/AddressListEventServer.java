package com.ucmed.hnust.controller.enterpriseWeChat.addressBookManagement;

/**
 * Created by ZY-LJ-1446 on 2018/4/19.
 */

import com.ucmed.hnust.controller.enterpriseWeChat.PublicVariable;
import com.ucmed.hnust.util.weixin.WXBizMsgCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 设置通讯录接收事件服务器
 */
@Controller
@RequestMapping(value = "/jssjfwq")
public class AddressListEventServer {

    /**
     * 设置接收事件服务器
     */
    @ResponseBody
    @RequestMapping(value = "/yzurl/{pageNum}", method = RequestMethod.GET)
    public String operation(@PathVariable("pageNum") int pageNum,HttpServletRequest request) {
        String res = null;
        try {
            String msg_signature = request.getParameter("msg_signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");
            String echostr = request.getParameter("echostr");
            WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(PublicVariable.stoken, PublicVariable.sencodingaeskey, PublicVariable.corpid);
            res = wxBizMsgCrypt.VerifyURL(msg_signature, timestamp, nonce, echostr);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 接收通讯录变更事件
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
            WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(PublicVariable.stoken, PublicVariable.sencodingaeskey, PublicVariable.corpid);
            String res = wxBizMsgCrypt.DecryptMsg(msgSignature, timestamp, nonce, postData);
            String replyMsg="0";
            String timestamp1=String.valueOf(System.currentTimeMillis()).substring(0,10);
            String nonce1=String.valueOf(System.currentTimeMillis()).substring(0,10);
            encryptres=wxBizMsgCrypt.EncryptMsg(replyMsg,timestamp1,nonce1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptres;
    }

    /*
    *  获取请求完整链接
    *  String url="http://" + request.getServerName() //服务器地址
                + ":"
                + request.getServerPort()           //端口号
                + request.getRequestURI();
        String queryurl=request.getQueryString();
        if(null!=queryurl){
            url+="?"+queryurl;
        }
    * */
}
