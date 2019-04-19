package com.ucmed.hnust.service;

import com.ucmed.hnust.pojo.RedisTest;

import java.util.List;

/**
 * Created by ZY-LJ-1446 on 2018/3/30.
 */
public interface RedisTestService {
    List<RedisTest> selectAllUser();
    List<RedisTest> selectAllUser1();
    void insertUser(RedisTest redisTest);
}
