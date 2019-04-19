package com.ucmed.hnust.controller;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.pojo.Admin;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by ZY-LJ-1446 on 2018/5/21.
 */
@Controller
@RequestMapping(value = "/cookie")
public class CookieController {

    private static final Logger logger = Logger.getLogger(CookieController.class);

    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public String index1(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        //1 利用UUID生成一个随机字符串
        String id = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("id", id);
        response.addCookie(cookie);
        return "/cookie/index1";
    }

    @RequestMapping(value = "/index5",method = RequestMethod.GET)
    public String index5(HttpServletRequest request, ModelMap map, HttpServletResponse response){

        //String s = request.getParameter("");
        System.out.print("aaaaa");
        System.out.print("aaaaa");
        System.out.print("aaaaa");
        return null;

    }

    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public String index2(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        //2 判断Request对象中的Cookie是否存在
        if(cookies != null){
            //3 遍历Request对象中的所有Cookie
            for (Cookie cookie : cookies) {
                //4 获取每一个Cookie的名称
                String name = cookie.getName();
                //5 判断Cookie的名称是否存在是id
                if(name.equals("id")){
                    map.put("id",cookie.getValue());
                }
            }
        }
        return "/cookie/index2";
    }

    @ResponseBody
    @RequestMapping(value = "/index3",method = RequestMethod.POST)
    public String index3(@RequestBody JSONObject a, HttpServletRequest request, ModelMap map, HttpServletResponse response){
        logger.info("aaaaaaaaaaaaaaaaa");
        logger.info("aaaaaaaaaaaaaaaaa");
        logger.info(a);
        logger.info("aaaaaaaaaaaaaaaaa");
        logger.info("aaaaaaaaaaaaaaaaa");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("k","v");
        return jsonObject.toString();
    }
}
