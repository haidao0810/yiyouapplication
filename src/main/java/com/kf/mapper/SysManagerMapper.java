package com.kf.mapper;

import com.kf.mapper.dao.DeviceDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Created by CCX on 2019/11/9.
 */
@Mapper
/**
 * 设备信息mapper
 */
public interface SysManagerMapper {


     DeviceDAO findDeviceByLinkKey(String linkKey);
     DeviceDAO findDeviceById(String deviceId);
     long insertDevice(Map<String,String> param);
}
