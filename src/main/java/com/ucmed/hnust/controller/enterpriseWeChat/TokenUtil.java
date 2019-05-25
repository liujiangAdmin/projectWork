package com.ucmed.hnust.controller.enterpriseWeChat;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.util.HttpRequestGet;
import com.ucmed.hnust.util.RedisCacheUtil;
import com.ucmed.hnust.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ZY-LJ-1446 on 2018/4/18.
 */
public class TokenUtil {


    @Autowired
    private RedisCacheUtil redisCacheUtil;

    /**获取通讯录token*/
    public String gettxlTokenImpl() {
        if (redisCacheUtil.getCacheObjectForqywx("txltoken") == null) {
            Map<String, Object> param = new HashMap<>();
            param.put("corpid", PublicVariable.corpid);
            param.put("corpsecret", PublicVariable.txlsecret);
            JSONObject res = HttpRequestGet.sendGet(
                    PublicVariable.tokenuri,
                    param, "utf-8");

            redisCacheUtil.setCacheObjectForqywx("txltoken", res.getString("access_token"));
        }
        return redisCacheUtil.getCacheObjectForqywx("txltoken").toString();
    }

    /**获取自建应用token*/
    public String getzjyyTokenImpl(String zjyysecret) {
        if (redisCacheUtil.getCacheObjectForqywx(zjyysecret) == null) {

            Map<String, Object> param = new HashMap<>();
            param.put("corpid", PublicVariable.corpid);
            param.put("corpsecret", zjyysecret);
            JSONObject res = HttpRequestGet.sendGet(
                    PublicVariable.tokenuri,
                    param, "utf-8");

            redisCacheUtil.setCacheObjectForqywx(zjyysecret, res.getString("access_token"));
        }
        return redisCacheUtil.getCacheObjectForqywx(zjyysecret).toString();
    }

    /**获取自建应用jsapi_ticket*/
    public String getTicket(String zjyysecret) {
        if (redisCacheUtil.getCacheObjectForqywx(zjyysecret+"ticket") == null){
            Map<String, Object> map = new HashMap<>();
            map.put("access_token",getzjyyTokenImpl(zjyysecret));
            JSONObject res = HttpRequestGet.sendGet(PublicVariable.jsapiticket,map,"utf-8");

            redisCacheUtil.setCacheObjectForqywx(zjyysecret+"ticket", res.getString("ticket"));
        }
        return redisCacheUtil.getCacheObjectForqywx(zjyysecret+"ticket").toString();
    }
    /**生成签名信息
     * @param noncestr 随机字符串
     * @param jsapiTicket
     * @param timestamp 时间戳
     * @param url 当前网页的URL，不包含#及其后面部分
     * */
    public String getSignature(String noncestr,String jsapiTicket,String timestamp,String url)
    {
        String string1="jsapi_ticket="+jsapiTicket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;
        String signature=Tool.getSha1(string1);
        return signature;
    }



}
