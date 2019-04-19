package com.ucmed.hnust.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/4/18 0018.
 */

@Controller
@RequestMapping(value = "/demo2")
public class Demo2Controller {
    private static final Logger logger = Logger.getLogger(Demo2Controller.class);


    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public String index1(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String name = request.getParameter("name");
        map.put("name",name);
        return "/demo2/index1";
    }

}
