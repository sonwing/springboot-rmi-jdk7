package com.snow.rmi.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * 类描述: 发起请求
 *
 * @author Snow
 * @version 1.0
 * @date 2019/10/28 11:04
 */
public class RequestUtil {
    @Value("${service.data}")
    private String data;

    /**
    * 功能描述:获取token
    * @param tokenUrl 获取token的url
    * @param paramMap 获取token需要的参数
    * @return java.lang.String
    * @author Administrator
    * @date 2019/10/28 11:05
    */
    public String getToken(String tokenUrl , Map<String, String> paramMap) throws Exception{
        String result =  HttpClientUtil.doGet(tokenUrl,paramMap);
        JSONObject jsonObject =  JSONObject.parseObject(result);
        return  jsonObject.getString("access_token");
    }
    /**
    * 功能描述:调用服务
    * @param serviceUrl 请求服务url
    * @param paramMap 请求服务携带参数
    * @return com.alibaba.fastjson.JSONArray 
    * @author Administrator
    * @date 2019/10/28 11:07
    */
    public JSONArray getData(String serviceUrl, Map<String, String> paramMap) throws Exception{
        String result =  HttpClientUtil.doPost(serviceUrl,paramMap);
        JSONObject jsonObject =  JSONObject.parseObject(result);
        return  jsonObject.getJSONArray(data);
    }
}
