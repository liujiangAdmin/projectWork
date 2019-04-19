package com.ucmed.hnust.controller;

import com.ucmed.hnust.service.DeptService;
import com.ucmed.hnust.service.IocXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZY-LJ-1446 on 2018/9/29.
 */

@Controller
@RequestMapping(value = "/iocXml")
public class IocXmlController {

    @Autowired
    private IocXml iocXml;

    @Autowired
    private DeptService deptService;

    @RequestMapping(method = RequestMethod.GET)
    public String index1(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        return "/iocXml";
    }
}
