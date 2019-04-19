package com.ucmed.hnust.controller.enterpriseWeChat.addressBookManagement;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.controller.enterpriseWeChat.TokenUtil;
import com.ucmed.hnust.util.HttpRequestGet;
import com.ucmed.hnust.util.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZY-LJ-1446 on 2018/4/20.
 */
@Controller
@RequestMapping(value = "/two")
public class TwoLevelVerification {
    private static final Logger logger = Logger.getLogger(TwoLevelVerification.class);
    @Autowired
    private RedisCacheUtil redisCacheUtil;
    @Autowired
    private TokenUtil tokenUtil;

    @RequestMapping(value = "/two",method= RequestMethod.GET)
    public String gettxlToken(HttpServletRequest request, Model model, ModelMap map, HttpServletResponse response)
    {
        String code=request.getParameter("code");
        logger.info("code:"+code);
        redisCacheUtil.setCacheObjectForqywx("code",code);
        return "two";
    }
    @RequestMapping(value = "/two1",method= RequestMethod.POST)
    public @ResponseBody String gettxlToken1(HttpServletRequest request, Model model, HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("access_token",tokenUtil.gettxlTokenImpl());
        map.put("code",redisCacheUtil.getCacheObjectForqywx("code"));
        JSONObject jsonObject=HttpRequestGet.sendGet("https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo",map,"utf-8");
        String userid=jsonObject.getString("UserId");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("access_token",tokenUtil.gettxlTokenImpl());
        map1.put("userid",userid);
        JSONObject jsonObject1=HttpRequestGet.sendGet("https://qyapi.weixin.qq.com/cgi-bin/user/authsucc",map1,"utf-8");

        return "0";
    }
}
