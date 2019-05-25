package com.ucmed.hnust.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class RequestHttpPorxy {


    private RequestHttpPorxy(){}

    public static JSONObject requestPorxy(JSONObject req, String mUrl) throws IOException {
        JSONObject res = null;
        ArrayList<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
        pairs.add(new BasicNameValuePair("requestData", req.toString()));
        UrlEncodedFormEntity entity = null;
        HttpRequest httpRequest = null;
        HttpHost target = null;
        CloseableHttpResponse resp = null;
        try {
            URL url = new URL(mUrl);
            String protocol = url.getProtocol();
            int port = url.getPort();
            if(port == -1)
                port = url.getDefaultPort();
            target = new HttpHost(url.getHost(), port, protocol);
            if(pairs != null) {
                httpRequest = new HttpPost(mUrl);
                httpRequest.setHeader("K", "ZW5sNWVWOWhibVJ5YjJsaw==");
                entity = new UrlEncodedFormEntity(pairs, "utf-8");
                ((HttpPost) httpRequest).setEntity(entity);
            }
            httpRequest.addHeader("Content-type",
                    "application/x-www-form-urlencoded;charset=utf-8");
            httpRequest.addHeader("Accept",
                    "application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
            resp = HttpClientManagerFactory.getHttpClient().execute(target, httpRequest);
            String resStr = null;
            if(resp != null && resp.getStatusLine().getStatusCode() == 200) {
                resStr = EntityUtils.toString(resp.getEntity());
            }
            res = JSONObject.parseObject(resStr);
        } catch(Exception e) {

        } finally {
            if(resp!=null) {
                resp.close();// 关闭连接
            }
        }
        return res;
    }
}
