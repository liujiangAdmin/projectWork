package com.ucmed.hnust.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/4/18 0018.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {


    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public String index1(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = request.getParameter("name");
        map.put("name",name);
        return "/login/login";
    }

    @ResponseBody
    @RequestMapping(value = "/index2",method = RequestMethod.POST)
    public String index5(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        request.getSession().setAttribute("userId",name+password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("password",password);
        return jsonObject.toString();
    }
}
