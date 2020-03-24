package com.kf.controller;

import com.alibaba.fastjson.JSONObject;
import com.kf.common.BConstant;
import com.kf.common.CollectionCode;
import com.kf.common.JSONResult;
import com.kf.common.UUIDUnit;
import com.kf.help.redis.RedisService;
import com.kf.mapper.dao.DeviceDAO;
import com.kf.service.SysManagerService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CCX on 2019/10/29.
 * 系统管理
 */

@RestController
@RequestMapping("api/sys_message/v1")
/**
 * 设备信息
 */
public class SysManagerController {

    private static Logger log = LoggerFactory.getLogger(SysManagerController.class);

    @Autowired
     @Qualifier(value ="SysManagerImpl")
    SysManagerService sysManagerService;

    @Autowired
    RedisService redisService;


    @PostMapping("/pos_sys_message.json")
    public String postSysMessage(@RequestParam (name = "imei", required = true ,defaultValue = "") String imei,
                               @RequestParam(name = "mac1",required = true ,defaultValue = "") String mac1,
                               @RequestParam(name = "mac2",required = true ,defaultValue = "") String mac2){
        log.info("imei: "+imei+" mac1: "+mac1+" mac2: "+mac2);
        if(StringUtils.isBlank(imei)){
            return  JSONResult.initErrorResult(CollectionCode.NET_ERROR_CODE_201,"缺少imei参数").toJsonString();
        }
        if(StringUtils.isBlank(mac1)){
            return  JSONResult.initErrorResult(CollectionCode.NET_ERROR_CODE_201,"缺少mac1参数").toJsonString();
        }
        if(StringUtils.isBlank(mac2)){
            return  JSONResult.initErrorResult(CollectionCode.NET_ERROR_CODE_201,"缺少mac2参数").toJsonString();
        }
        DeviceDAO deviceDAO= sysManagerService.findDeviceByLinkKey(imei+mac1);
        if(deviceDAO==null){
            Map<String,String> param=new HashMap<>();
            String uuId=UUIDUnit.initUUID();
            param.put("uuid", uuId);
            param.put("imei",imei);
            param.put("mac1",mac1);
            param.put("mac2",mac2);
            param.put("linkKey",imei+mac1);
            long result= sysManagerService.insertDevice(param);
            if(result>0){
                JSONObject dataObject=new JSONObject();
                dataObject.put("deviceId",uuId);
                redisService.set(BConstant.REDIS_DEVICE_HEARD+uuId,"1",2*24*60*60);
                return JSONResult.initSuccessResult("success").pusData(dataObject).toJsonString();
            }else{
                return JSONResult.initErrorResult(CollectionCode.NET_ERROR_CODE_403,"未知错误").toJsonString();
            }
        }else{
            JSONObject dataObject=new JSONObject();
            dataObject.put("deviceId",deviceDAO.getUuid());
            redisService.set(BConstant.REDIS_DEVICE_HEARD+deviceDAO.getUuid(),"1",2*24*60*60);
            return JSONResult.initSuccessResult("success").pusData(dataObject).toJsonString();
        }
    }


}
