package com.ucmed.hnust.dao;

import com.ucmed.hnust.pojo.Admin;

/**
 * Created by ZY-LJ-1446 on 2018/1/22.
 */

public interface AdminMapper {

    //根据用户输入信息校验用户信息
    Admin selectByAdminInfo(Admin admin);
}
