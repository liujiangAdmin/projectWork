package com.ucmed.hnust.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ZY-LJ-1446 on 2018/7/20.
 */
public class HttpPostKeyValue {


    public static JSONObject sendPost(String url, Map<String, Object> map,
                                      String charset) {
        String param = getParam(map);
        String reponse = Post(url, param, charset);
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
    public static String Post(String url, String param, String charset) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        String line;
        HttpURLConnection conn = null;
        StringBuffer sb = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性 设置请求格式
            conn.setRequestProperty("contentType", charset);
            conn.setRequestProperty("content-type",
                    "application/x-www-form-urlencoded");
            // 设置超时时间
            conn.setConnectTimeout(6000);
            conn.setReadTimeout(6000);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应 设置接收格式
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            System.out.println("发送 POST请求出现异常!" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (conn != null)
                {
                    conn.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
