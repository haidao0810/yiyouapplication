package com.kf.service.impl;

import com.kf.mapper.SysManagerMapper;
import com.kf.mapper.dao.DeviceDAO;
import com.kf.service.SysManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by CCX on 2019/11/29.
 */
@Service(value ="SysManagerImpl" )
public class SysManagerImpl implements SysManagerService {
    @Autowired
    SysManagerMapper sysManagerMapper;

    @Override
    public DeviceDAO findDeviceByLinkKey(String linkKey) {
        return sysManagerMapper.findDeviceByLinkKey(linkKey);
    }

    @Override
    public DeviceDAO findDeviceById(String deviceId) {
        return sysManagerMapper.findDeviceById(deviceId);
    }

    @Override
    public long insertDevice(Map<String, String> param) {
      long point=  sysManagerMapper.insertDevice(param);
      return point;
    }
}
