package com.ucmed.hnust.controller;

import com.alibaba.fastjson.JSONObject;
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Created by Administrator on 2019/4/18 0018.
 */
@Controller
@RequestMapping(value = "/demo1")
public class Demo1Controller {
    private static final Logger logger = Logger.getLogger(Demo1Controller.class);

    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public String index1(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = request.getParameter("name");
        map.put("name",name);
        return "/demo1/index1";
    }

    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public String index2(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = request.getParameter("name");
        map.put("name",name);
        return "/demo1/index2";
    }

    @ResponseBody
    @RequestMapping(value = "/index5",method = RequestMethod.POST)
    public String index5(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("age",age);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/index3",method = RequestMethod.GET)
    public String index3(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = request.getParameter("name");
        map.put("name",name);
        return "/demo1/index3";
    }

    @ResponseBody
    @RequestMapping(value = "/index6",method = RequestMethod.POST)
    public String index6(@RequestBody JSONObject jsonObject, HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = jsonObject.getString("name");
        Integer age = jsonObject.getInteger("age");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name",name);
        jsonObject1.put("age",age);
        return jsonObject1.toString();
    }


    @RequestMapping(value = "/index4",method = RequestMethod.GET)
    public String index4(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = request.getParameter("name");
        map.put("name",name);
        return "/demo1/index4";
    }

    @ResponseBody
    @RequestMapping(value = "/index7",method = RequestMethod.POST)
    public String index7(@RequestBody JSONObject jsonObject, HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = jsonObject.getString("name");
        Integer age = jsonObject.getInteger("age");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name",name);
        jsonObject1.put("age",age);
        return name+"哈哈"+age;
    }

    @RequestMapping(value = "/index10",method = RequestMethod.GET)
    public String index10(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = request.getParameter("name");
        map.put("name",name);
        return "/demo1/index10";
    }
    //不使用RequestBody 使用IO流
    @ResponseBody
    @RequestMapping(value = "/index11",method = RequestMethod.POST)
    public String index11( HttpServletRequest request, ModelMap map, HttpServletResponse response) throws IOException {
        StringBuilder out = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(request.getInputStream(), Charset.forName("utf-8"));
        char[] buffer = new char[4096];
        int bytesRead = -1;
        while ((bytesRead = reader.read(buffer)) != -1) {
            out.append(buffer, 0, bytesRead);
        }
        reader.close();
        JSONObject jsonObject = JSONObject.parseObject(out.toString());
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name",jsonObject.getString("name"));
        jsonObject1.put("age",jsonObject.getInteger("age"));
        return jsonObject1.toString();
    }
}
