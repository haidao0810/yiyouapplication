package com.kf.service;

import com.kf.mapper.dao.DeviceDAO;

import java.util.Map;

/**
 * Created by CCX on 2019/11/29.
 */

public interface SysManagerService {
     /**
      * 通过linkKey
      * @param linkKey
      * @return
      */
     DeviceDAO findDeviceByLinkKey(String linkKey);
     DeviceDAO findDeviceById(String deviceId);
     long  insertDevice(Map<String,String> param);
}
