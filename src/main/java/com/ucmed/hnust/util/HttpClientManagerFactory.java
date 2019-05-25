package com.ucmed.hnust.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class HttpClientManagerFactory {


    private static PoolingHttpClientConnectionManager cm = null;


    /**
     * 最大连接数
     */
    public static final  int MAX_TOTAL_CONNECTIONS = 400;
    /**
     * 获取连接的最大等待时间
     */
    public static final  int WAIT_TIMEOUT = 60000;
    /**
     * 每个路由最大连接数
     */
    public static final  int MAX_ROUTE_CONNECTIONS = 800;
    /**
     * 连接超时时间
     */
    public static final int CONNECT_TIMEOUT = 10000;
    /**
     * 读取超时时间
     */
    public static final int READ_TIMEOUT = 40000;

    static {
        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
        }

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                .<ConnectionSocketFactory> create().register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory()).build();
        cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(MAX_TOTAL_CONNECTIONS);
        cm.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
        SocketConfig socketConfig = SocketConfig.custom()
                .setSoTimeout(WAIT_TIMEOUT).build();
        cm.setDefaultSocketConfig(socketConfig);
    }

    private HttpClientManagerFactory(){}

    public static CloseableHttpClient getHttpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(READ_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(WAIT_TIMEOUT).build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig).build();
        return httpClient;
    }

}
