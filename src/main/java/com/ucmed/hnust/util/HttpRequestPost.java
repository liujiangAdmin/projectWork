package com.ucmed.hnust.util;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by ZY-LJ-1446 on 2018/4/18.
 */
public class HttpRequestPost {


    public static String HttpRequest(String requestUrl, String requestMethod,
                                         String outputStr) {
        //JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        OutputStream out = null;
        InputStream input = null;
        InputStreamReader inputReader = null;
        BufferedReader reader = null;
        HttpURLConnection connection = null;
        try {
            // 建立连接
            URL url = new URL(requestUrl);
            connection = (HttpURLConnection) url.openConnection();
            // 设置http头部信息
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);
            connection.setConnectTimeout(6000);
            connection.setReadTimeout(6000);
            // 写入消息实体
            if (outputStr != null) {
                out = connection.getOutputStream();
                out.write(outputStr.getBytes("UTF-8"));
            }
            // 流处理
            input = connection.getInputStream();
            inputReader = new InputStreamReader(input, "UTF-8");
            reader = new BufferedReader(inputReader);
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
           //jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (Exception e) {
            //日志处理等，请自行实现
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (input != null) {
                    input.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (inputReader != null) {
                    inputReader.close();
                }
                if (connection != null)
                {
                    connection.disconnect();
                }
            } catch (Exception e) {
                //日志处理等，请自行实现

            }
        }
        return buffer.toString();
    }


    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    /*public static String doPost(String url, String params) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;

        try {

            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            else{
                logger.error("请求返回:"+state+"("+url+")");
            }
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }*/
}
