package com.ucmed.hnust.controller;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by ZY-LJ-1446 on 2018/11/30.
 */

@RestController
@RequestMapping(value = "/threadTest")
public class ThreadTest {


    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private DeptService deptService;



    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String index1(HttpServletRequest request, ModelMap map, HttpServletResponse response) throws ExecutionException, InterruptedException {
        List<Object> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            //Future<Object> future = threadPoolTaskExecutor.submit(new ThredExecutorBean(i, deptService));
            //list.add(future.get());
        }
        return JSONObject.toJSONString(list);
    }

    @ResponseBody
    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public ResponseEntity<String> index3(HttpServletRequest request, ModelMap map, HttpServletResponse response){
        String result = "卓建科技";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
