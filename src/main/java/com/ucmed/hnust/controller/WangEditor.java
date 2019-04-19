package com.ucmed.hnust.controller;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.controller.enterpriseWeChat.PublicVariable;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZY-LJ-1446 on 2018/5/30.
 */
@Controller
@RequestMapping(value = "/wangEditor")
public class WangEditor {

    private static final Logger logger = Logger.getLogger(WangEditor.class);

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index1(HttpServletRequest request, ModelMap map, HttpServletResponse response){

        return "/wangEditor/index";
    }

    @RequestMapping(value= "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request,
                         @RequestParam(value="myFileName")MultipartFile mf) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("upload");

        String path = PublicVariable.fileuploaduri;
        String filename = mf.getOriginalFilename();
        String[] names=filename.split("\\.");
        String tempNum=(int)(Math.random()*100000)+"";
        String uploadFileName=tempNum +System.currentTimeMillis()+"."+names[names.length-1];
        File filepath = new File(path,uploadFileName);
        mf.transferTo(filepath);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data","http://test.lj.ucmed.cn/image/"+uploadFileName);
        return jsonObject.toString();
    }
}
