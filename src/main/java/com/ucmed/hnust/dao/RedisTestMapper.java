package com.ucmed.hnust.dao;

import com.ucmed.hnust.pojo.RedisTest;

import java.util.List;

/**
 * Created by ZY-LJ-1446 on 2018/3/30.
 */
public interface RedisTestMapper {
    List<RedisTest> selectAllUser();
    void insertUser(RedisTest redisTest);
}
