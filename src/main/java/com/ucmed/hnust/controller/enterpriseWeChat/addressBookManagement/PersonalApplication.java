package com.ucmed.hnust.controller.enterpriseWeChat.addressBookManagement;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.controller.enterpriseWeChat.PublicVariable;
import com.ucmed.hnust.controller.enterpriseWeChat.TokenUtil;
import com.ucmed.hnust.util.HttpRequestGet;
import com.ucmed.hnust.util.HttpRequestPost;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 个人测试应用类
 * Created by ZY-LJ-1446 on 2018/4/25.
 */
@Controller
@RequestMapping(value = "/personalApplication")
public class PersonalApplication {
    private static final Logger logger = Logger.getLogger(PersonalApplication.class);

    @Value("${mymy.list}")
    private String mrmyList;

    @Autowired
    private TokenUtil tokenUtil;

    @RequestMapping(value = "/index",method= RequestMethod.GET)
    public String index(HttpServletRequest request, Model model, ModelMap map, HttpServletResponse response)
    {
        String [] mrmyArray =  mrmyList.split("。");
        Random r = new Random();
        int randomNumber = r.nextInt(mrmyArray.length);
        String randomMrmy=mrmyArray[randomNumber];
        map.put("randomMrmy",randomMrmy);

        //根据code获取userid并获取成员详细信息
        String code=request.getParameter("code");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("access_token",tokenUtil.getzjyyTokenImpl(PublicVariable.gryysecret));
        map1.put("code",code);
        JSONObject jsonObject= HttpRequestGet.sendGet(PublicVariable.hqcyxxbycode,map1,"utf-8");
        logger.info("根据code获取成员信息："+jsonObject);
        if(!jsonObject.getString("errcode").equals("0"))
        {
            map.put("errcode","1");
            map.put("errmsg",jsonObject.getString("errmsg"));
            return "gerenyingyong";
        }
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("user_ticket",jsonObject.getString("user_ticket"));
        String res=HttpRequestPost.HttpRequest(PublicVariable.hqcyxqbyticket+tokenUtil.getzjyyTokenImpl(PublicVariable.gryysecret)
        ,"POST",jsonObject1.toString());
        logger.info("根据user_ticket获取成员详细信息:"+jsonObject);
        JSONObject jsonObject2=JSONObject.parseObject(res);
        map.put("userid",jsonObject2.getString("userid"));
        map.put("name",jsonObject2.getString("name"));
        map.put("mobile",jsonObject2.getString("mobile"));
        //str = str== null ? "" : str;
        String gender = jsonObject2.getString("gender").equals("1") ? "男":"女";
        map.put("gender",gender);
        map.put("errcode","0");
        return "gerenyingyong";
    }

    @RequestMapping(value = "/index2",method= RequestMethod.GET)
    public String index2(HttpServletRequest request, Model model, ModelMap map, HttpServletResponse response)
    {
        logger.info(mrmyList);
        String [] mrmyArray =  mrmyList.split("。");
        Random r = new Random();
        int randomNumber = r.nextInt(mrmyArray.length);
        String randomMrmy=mrmyArray[randomNumber];
        map.put("randomMrmy",randomMrmy);
        return "gerenyingyong";
    }
}
