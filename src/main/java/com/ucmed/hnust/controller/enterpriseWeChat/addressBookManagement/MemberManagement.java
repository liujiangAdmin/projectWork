package com.ucmed.hnust.controller.enterpriseWeChat.addressBookManagement;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.controller.enterpriseWeChat.PublicVariable;
import com.ucmed.hnust.controller.enterpriseWeChat.TokenUtil;
import com.ucmed.hnust.util.HttpRequestPost;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通讯录管理
 */
@Controller
@RequestMapping(value = "/memberManagement")
public class MemberManagement {
    private static final Logger logger = Logger.getLogger(MemberManagement.class);

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 创建成员
     * @param
     * */
    @RequestMapping(value = "/createmember",method= RequestMethod.GET,produces = "application/json;charset=utf-8")
    public @ResponseBody String createmember(HttpServletRequest request, Model model, ModelMap map, HttpServletResponse response)
    {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userid","zhangchao");
        jsonObject.put("name","张超");
        jsonObject.put("mobile","13397155127");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(2);
        jsonObject.put("department",jsonArray);
        jsonObject.put("position","职员");
        jsonObject.put("gender","1");
        jsonObject.put("email","2389188990@qq.com");
        jsonObject.put("enable",1);
        logger.info(jsonObject);
        return creatememberImpl(jsonObject);
    }
    private String creatememberImpl(JSONObject jsonObject)
    {
        String txltoken= tokenUtil.gettxlTokenImpl();
        String res=HttpRequestPost.HttpRequest(PublicVariable.creatememberuri+txltoken,"POST",jsonObject.toString());
        logger.info("createmember:"+res);
        return res.toString();
    }

}
