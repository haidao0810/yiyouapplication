package com.kf.help.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kf.advice.DeviceNothingnessException;
import com.kf.common.BConstant;
import com.kf.help.redis.RedisService;
import com.kf.mapper.dao.DeviceDAO;
import com.kf.service.SysManagerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * 设备信息拦截器
 */
public class DeviceInterceptor implements HandlerInterceptor {

    @Autowired
    RedisService redisService;
    @Autowired
    @Qualifier(value ="SysManagerImpl")
    SysManagerService sysManagerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String paramValue=request.getParameter("deviceId");
        if(StringUtils.isBlank(paramValue)){
            throw new DeviceNothingnessException("上传设备信息不存在");
        }else{
          String dState= (String) redisService.get(BConstant.REDIS_DEVICE_HEARD+paramValue);
          if(StringUtils.isBlank(dState)){
              DeviceDAO deviceDAO= sysManagerService.findDeviceById(paramValue);
              if(deviceDAO==null){
                  throw new DeviceNothingnessException("设备信息不存在");
              }else{
                  redisService.set(BConstant.REDIS_DEVICE_HEARD+paramValue,"1",2*24*60*60);
              }
          }
        }
        return true;//是否继续执行
    }
}
