package com.ucmed.hnust.controller;


import com.ucmed.hnust.pojo.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZY-LJ-1446 on 2018/8/23.
 */
@Controller
@RequestMapping("/person")
@Api(tags = "个人业务")
public class SwaggerTest {
    @RequestMapping(value = "/getPerson", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "个人信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Admin getPersons() {
        Admin admin = new Admin();
        admin.setPassword("11111");
        return admin;
    }
}
