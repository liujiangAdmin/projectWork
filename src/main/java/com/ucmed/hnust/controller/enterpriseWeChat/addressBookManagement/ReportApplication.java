package com.ucmed.hnust.controller.enterpriseWeChat.addressBookManagement;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.controller.enterpriseWeChat.PublicVariable;
import com.ucmed.hnust.controller.enterpriseWeChat.TokenUtil;
import com.ucmed.hnust.util.*;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 检查检验单查询
 * Created by ZY-LJ-1446 on 2018/4/25.
 */
@Controller
@RequestMapping(value = "/reportApplication")
public class ReportApplication {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @RequestMapping(value = "/jydIndex", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model, ModelMap map, HttpServletResponse response) {
        if(request.getSession().getAttribute("user")==null)
        {
            String code = request.getParameter("code");
            Map<String, Object> map1 = new HashMap<>();
            map1.put("access_token", tokenUtil.getzjyyTokenImpl(PublicVariable.jydsecret));
            map1.put("code", code);
            JSONObject jsonObject = HttpRequestGet.sendGet(PublicVariable.hqcyxxbycode, map1, "utf-8");

            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("user_ticket", jsonObject.getString("user_ticket"));
            String res = HttpRequestPost.HttpRequest(PublicVariable.hqcyxqbyticket + tokenUtil.getzjyyTokenImpl(PublicVariable.jydsecret)
                    , "POST", jsonObject1.toString());

            JSONObject jsonObject2 = JSONObject.parseObject(res);
            map.put("errcode", "0");
            map.put("userid", jsonObject2.getString("userid"));
            map.put("name", jsonObject2.getString("name"));
            map.put("mobile", jsonObject2.getString("mobile"));
            //用户信息存入缓存
            request.getSession().setAttribute("user",jsonObject2.getString("userid")+","+jsonObject2.getString("name")+","+jsonObject2.getString("mobile"));
            request.getSession().setMaxInactiveInterval(60*60*2);
        }else{
           String user =  request.getSession().getAttribute("user").toString();
           String [] users =  user.split(",");
           map.put("errcode", "0");
           map.put("userid",users[0]);
           map.put("name",users[1]);
           map.put("mobile",users[2]);

        }
        //使用jsd-sdk
        StringBuffer url = request.getRequestURL();
        if (request.getQueryString() != null) {
            url.append('?');
            url.append(request.getQueryString());
        }
        String jsUrl = url.toString();

        String ticket = tokenUtil.getTicket(PublicVariable.jydsecret);
        String noncestr =  Tool.getNoncestr();
        String timestamp = Tool.getTimestamp();
        String signature = tokenUtil.getSignature(noncestr,ticket,timestamp,jsUrl);
        map.put("noncestr",noncestr);
        map.put("timestamp",timestamp);
        map.put("signature",signature);
        map.put("appid",PublicVariable.corpid);
        return "/jyd/jydIndex";
    }
    @RequestMapping(value = "/jydList", method = RequestMethod.POST)
    public String jydList(HttpServletRequest request, Model model, ModelMap map, HttpServletResponse response) {
        //获取身份证号码
        String dayNum = "500";
        String id_card = request.getParameter("cardNum");
        JSONObject data = new JSONObject();
        JSONObject data1 = new JSONObject();
        JSONObject invoker_content = new JSONObject();
        JSONObject invoker_content1 = new JSONObject();
        invoker_content.put("apiId", "JYDLXX");
        invoker_content.put("CAOZUOYDM", "APP");
        invoker_content.put("CAOZUOYXM", "昆山二院APP");
        invoker_content.put("FENYUANDM", "");
        invoker_content.put("CAOZUORQ", KunshanSecondDateUtil.getCurrentDateTime());
        invoker_content.put("XITONGBS", "APP");
        invoker_content.put("KAISHIRQ", KunshanSecondDateUtil.getDateByDays2(-Integer.parseInt(dayNum)));

        //结束时间选择当前时间
        invoker_content.put("JIESHURQ", KunshanSecondDateUtil.getDateByDays2(0));
        invoker_content.put("JIUZHENLY", "1");
        invoker_content.put("BINGRENID", id_card);
        //data1
        invoker_content1.put("apiId", "JYDLXX");
        invoker_content1.put("CAOZUOYDM", "APP");
        invoker_content1.put("CAOZUOYXM", "昆山二院APP");
        invoker_content1.put("FENYUANDM", "");
        invoker_content1.put("CAOZUORQ", KunshanSecondDateUtil.getCurrentDateTime());
        invoker_content1.put("XITONGBS", "APP");
        invoker_content1.put("KAISHIRQ", KunshanSecondDateUtil.getDateByDays2(-Integer.parseInt(dayNum)));

        //结束时间选择当前时间
        invoker_content1.put("JIESHURQ", KunshanSecondDateUtil.getDateByDays2(0));
        invoker_content1.put("JIUZHENLY", "2");
        invoker_content1.put("BINGRENID", id_card);
        data.put("invoker_content", invoker_content);
        data1.put("invoker_content", invoker_content1);
        JSONObject params = new JSONObject();
        JSONObject params1 = new JSONObject();
        params.put("app_id", "zsyy_android");
        params.put("app_key", "ZW5sNWVWOWhibVJ5YjJsaw==");
        params.put("coder", "enNseVpXNXNOV1ZXT1doaWJWSjVZakpzYXc9PQ");
        params.put("api_name", "api.nuts.invoker");
        params.put("data", data);
        //params1
        params1.put("app_id", "zsyy_android");
        params1.put("app_key", "ZW5sNWVWOWhibVJ5YjJsaw==");
        params1.put("coder", "enNseVpXNXNOV1ZXT1doaWJWSjVZakpzYXc9PQ");
        params1.put("api_name", "api.nuts.invoker");
        params1.put("data", data1);

        String url = "http://jump.ksey.zwjk.com:8000/api/exec.htm";
        JSONObject res1 = null;
        JSONObject res2 = null;
        try {
            res1 = RequestHttpPorxy.requestPorxy(params, url);
            res2 = RequestHttpPorxy.requestPorxy(params1, url);
        } catch (Exception e) {

            map.put("errcode", "1");
        }

        JSONArray j1 = analyticalReportList(res1.toString());
        JSONArray j2 = analyticalReportList(res2.toString());
        j1.addAll(j2);
        if (j1.size() > 0) {
            for (int i = 0; i < 1; i++) {
                JSONObject object = j1.getJSONObject(i);
                map.put("HZname", object.getString("BINGRENXM"));
                map.put("idCard", id_card);
            }
            map.put("errcode", "0");
            map.put("listsize", j1.size());
            map.put("list", j1);
        } else {
            map.put("errcode", "1");
            map.put("errmsg", "暂无报告单");
        }

        return "/jyd/jydList";
    }

    private JSONArray analyticalReportList(String res) {
        JSONArray jsonArray = new JSONArray();
        JSONObject resObj = JSONObject.parseObject(res);
        JSONArray retdate = resObj.getJSONObject("return_data").getJSONArray("ret_data");
        for (int i = 0; i < retdate.size(); i++) {
            JSONObject reti = retdate.getJSONObject(i);
            JSONArray jianyanxx = reti.getJSONArray("JIANYANXX");
            if (jianyanxx.size() > 0) {
                for (int j = 0; j < jianyanxx.size(); j++) {
                    JSONObject jsonObject = jianyanxx.getJSONObject(j);
                    String json = jsonObject.getString("JIANYANXMMX");
                    try {
                        String jianyanName = "";
                        JSONArray ja = JSONArray.parseArray(json);
                        for (int k = 0; k < ja.size(); k++) {

                            JSONObject jak = ja.getJSONObject(k);
                            if (k == ja.size() - 1) {
                                jianyanName += jak.getString("XIANGMUMC");
                            } else {
                                jianyanName += jak.getString("XIANGMUMC") + "/";
                            }
                        }
                        jsonObject.put("reportName", jianyanName);
                    } catch (Exception e) {
                        JSONObject jo = JSONObject.parseObject(json);
                        jsonObject.put("reportName", jo.getJSONObject("JIANYANXM").getString("XIANGMUMC"));

                    }
                    jsonArray.add(jsonObject);
                }
            }
        }
        return jsonArray;
    }
}
