package com.funtl.my.shop.commons.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * HttpClient工具类
 *
 * @ClassName HttpClientUtils
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/6 9:13
 * @Version 1.0
 **/
public class HttpClientUtils {

    public static final String GET = "get";
    public static final String POST = "post";

    public static final String REQUEST_HEADER_CONNECTION = "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36)";

    /**
     * GET 请求
     * @param url 请求地址
     * @return
     */
    public static String doGet(String url) {
        return createRequestt(url, null, GET);
    }

    /**
     * GET 请求
     * @param url 请求地址
     * @param cookie cookie
     * @return
     */
    public static String doGet(String url,String cookie) {
        return createRequestt(url, cookie, GET);
    }

    /**
     * POST 请求
     * @param url 请求地址
     * @param params 请求参数(可选)
     * @return
     */
    public static String doPost(String url,BasicNameValuePair... params) {
        return createRequestt(url, null, POST, params);
    }

    /**
     * POST 请求
     * @param url 请求地址
     * @param params 请求参数(可选)
     * @param cookie cookie
     * @return
     */
    public static String doPost(String url,String cookie,BasicNameValuePair... params) {
        return createRequestt(url, cookie, POST, params);
    }

    /**
     * 创建请求
     * @param url 请求地址
     * @param cookie cookie
     * @param requestMethod 请求方式 get/post
     * @param params 请求参数 仅限于post请求用
     * @return
     */
    private static String createRequestt(String url, String cookie,String requestMethod, BasicNameValuePair... params) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = null;
        HttpPost httpPost = null;
        //响应
        CloseableHttpResponse httpResponse = null;
        //请求结果
        result = null;
        try {
            //GET请求
            if (GET.equals(requestMethod)) {
                httpGet = new HttpGet(url);
                // 设置长连接
                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                // 设置代理（模拟浏览器版本）
                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                // 设置 Cookie
                httpGet.setHeader("Cookie", cookie);
                httpResponse = httpClient.execute(httpGet);
            //POST请求
            } else if (POST.equals(requestMethod)) {
                httpPost = new HttpPost(url);
                // 设置长连接
                httpPost.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                // 设置代理（模拟浏览器版本）
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                // 设置 Cookie
                httpPost.setHeader("Cookie", cookie);

                //有参数进来
                if (params != null && params.length > 0) {
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params), "UTF-8"));//将数组转换为list
                }
                httpResponse = httpClient.execute(httpPost);
            }
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
