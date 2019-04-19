package com.ucmed.hnust.service;

import com.ucmed.hnust.pojo.Admin;

/**
 * Created by ZY-LJ-1446 on 2018/1/23.
 */
public interface AdminService {
    //根据用户输入信息校验用户信息
    Admin selectByAdminInfo(Admin admin);
    public String cxfDemo1(String name);

}
