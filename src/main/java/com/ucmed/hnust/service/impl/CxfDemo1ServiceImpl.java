package com.ucmed.hnust.service.impl;

import com.ucmed.hnust.controller.enterpriseWeChat.TokenUtil;
import com.ucmed.hnust.service.AdminService;
import com.ucmed.hnust.service.CxfDemo1Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
/**
 * Created by Administrator on 2019/4/18 0018.
 */

@WebService
public class CxfDemo1ServiceImpl implements CxfDemo1Service{



    @Autowired
    private AdminService adminService;

    @Override
    public String getUserById(String name) {

        return adminService.cxfDemo1(name);
    }

    @Override
    public String getAllUsers() {
        return null;
    }
}
