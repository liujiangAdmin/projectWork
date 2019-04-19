package com.ucmed.hnust.service.impl;

import com.ucmed.hnust.dao.RedisTestMapper;
import com.ucmed.hnust.pojo.RedisTest;
import com.ucmed.hnust.service.RedisTestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZY-LJ-1446 on 2018/3/30.
 */

@Service("redisTestService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
public class RedisTestServiceImpl implements RedisTestService{
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private RedisTestMapper redisTestMapper;

    @Cacheable("selectAllUser")//标注该方法查询的结果进入缓存，再次访问时直接读取缓存中的数据
    @Override
    public List<RedisTest> selectAllUser() {
        logger.info("selectAllUser去查了数据库");
        return redisTestMapper.selectAllUser();
    }
    @Cacheable("selectAllUser1")//标注该方法查询的结果进入缓存，再次访问时直接读取缓存中的数据
    @Override
    public List<RedisTest> selectAllUser1() {
        return redisTestMapper.selectAllUser();
    }

    @CacheEvict(value= {"selectAllUser"},allEntries=true)//清空缓存，allEntries变量表示所有对象的缓存都清除
    @Override
    public void insertUser(RedisTest redisTest) {
        redisTestMapper.insertUser(redisTest);
    }
}
