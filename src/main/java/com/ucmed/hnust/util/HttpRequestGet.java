package com.ucmed.hnust.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ZY-LJ-1446 on 2018/4/18.
 */
public class HttpRequestGet {
    private static final Logger logger = Logger.getLogger(HttpRequestGet.class);
    public static JSONObject sendGet(String url, Map<String, Object> map,
                                      String charset) {
        String param = getParam(map);
        String reponse = Get(url, param, charset);
        JSONObject res=JSONObject.parseObject(reponse);
        return res;
    }
    public static String getParam(Map<String, Object> map) {
        StringBuffer sb = new StringBuffer();
        // 构建请求参数
        if (map != null && map.size() > 0) {
            Iterator it = map.entrySet().iterator(); // 定义迭代器
            while (it.hasNext()) {
                Map.Entry er = (Map.Entry) it.next();
                sb.append(er.getKey());
                sb.append("=");
                sb.append(er.getValue());
                sb.append("&");
            }
        }
        return sb.toString();
    }
    public static String Get(String url, String param, String charset) {
        String result = "";
        String line;
        StringBuffer sb = new StringBuffer();
        BufferedReader in = null;
        HttpURLConnection conn = null;
        try {
            String urlNameString = url + "?" + param;
            logger.info(urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性 设置请求格式
            conn.setRequestProperty("contentType", charset);
            conn.setRequestProperty("content-type",
                    "application/x-www-form-urlencoded");
            // 设置超时时间
            conn.setConnectTimeout(6000);
            conn.setReadTimeout(6000);
            // 建立实际的连接
            conn.connect();
            // 定义 BufferedReader输入流来读取URL的响应,设置接收格式
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (conn != null)
                {
                    conn.disconnect();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
