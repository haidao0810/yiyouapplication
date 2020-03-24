package com.kf.utils;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by CCX on 2020/2/20.
 * restTemplate 工具类
 */
public class RestTemplateUtil {

    private static RestTemplate restTemplate;

    public static  RestTemplate getInstance(){
        if(restTemplate==null){
            restTemplate=new RestTemplate();
        }
       return restTemplate;
    }

    public static String postWay(String url ,Map param){
       return getInstance().postForObject(url,param,String.class);

    }

    public static String getWay(String url ,Map param){
        return getInstance().getForObject(url,String.class,param);
    }

}
