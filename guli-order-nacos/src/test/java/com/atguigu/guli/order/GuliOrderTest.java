package com.atguigu.guli.order;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuliOrderTest {
    public static void main(String[] args) throws IOException {
        //初始化客户端
        HttpClient httpclient = HttpClients.createDefault();
        //设置get请求地址
        HttpGet httpGet = new HttpGet("http://www.atguigu.com");
        //执行请求得到结果
        HttpResponse response = httpclient.execute(httpGet);
        //获取状态码
        int statusCode = response.getStatusLine().getStatusCode();
        //解析响应体
        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(statusCode);
        System.out.println(result);
        //post方式请求
//        HttpPost httpPost = new HttpPost("http://httpbin.org/post");
//        List<NameValuePair> nvps = new ArrayList<>();
//        nvps.add(new BasicNameValuePair("username", "vip"));
//        nvps.add(new BasicNameValuePair("password", "secret"));
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
    }
}
