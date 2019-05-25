import com.alibaba.fastjson.JSON;
import com.ucmed.hnust.pojo.RedisTest;
import com.ucmed.hnust.service.RedisTestService;
import com.ucmed.hnust.util.RedisCacheUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZY-LJ-1446 on 2018/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RedisTestTest {

    @Autowired
    private RedisTestService redisTestService;

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @Test
    public void selectAllUser()
    {
        List<RedisTest> list = redisTestService.selectAllUser();

        List<RedisTest> list1 = redisTestService.selectAllUser1();

    }
    @Test
    public void insertUser()
    {
        RedisTest redisTest = new RedisTest();
        redisTest.setUserName("a");
        redisTest.setSex("男");
        redisTest.setAge(24);
        redisTestService.insertUser(redisTest);
    }

    @Test
    public void test()
    {
        String key="name";
        redisCacheUtil.setCacheObject(key,"chenhong");
        String result= (String) redisCacheUtil.getCacheObject(key);

    }
    @Test
    public void test1()
    {
        List<String>list = new ArrayList<>();
        list.add("a");
        list.add("b");
        String key="name";
        redisCacheUtil.setCacheList(key,list);
        List<String>list1= (List<String>) redisCacheUtil.getCacheList(key);

    }
}
