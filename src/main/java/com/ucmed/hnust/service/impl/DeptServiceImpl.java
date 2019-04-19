package com.ucmed.hnust.service.impl;

import com.ucmed.hnust.dao.DeptMapper;
import com.ucmed.hnust.pojo.Dept;
import com.ucmed.hnust.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZY-LJ-1446 on 2018/4/19.
 */
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> selectDept() {
        return deptMapper.selectDept();
    }
}
