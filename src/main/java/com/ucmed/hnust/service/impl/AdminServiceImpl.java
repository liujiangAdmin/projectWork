package com.ucmed.hnust.service.impl;

import com.ucmed.hnust.dao.AdminMapper;
import com.ucmed.hnust.pojo.Admin;
import com.ucmed.hnust.service.AdminService;
import com.ucmed.hnust.util.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ZY-LJ-1446 on 2018/1/23.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @Override
    public Admin selectByAdminInfo(Admin admin) {
        return adminMapper.selectByAdminInfo(admin);
    }

    @Override
    public String cxfDemo1(String name) {
        redisCacheUtil.setCacheObjectForqywx("cxfdemo1", name);
        return redisCacheUtil.getCacheObjectForqywx("cxfdemo1").toString();
    }
}
