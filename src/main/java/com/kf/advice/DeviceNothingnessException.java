package com.kf.advice;

import com.kf.common.CollectionCode;

/**
 * 设备不存在异常处理
 */
public class DeviceNothingnessException extends RuntimeException {
    public int error_code= CollectionCode.NET_ERROR_CODE_6030;
    public DeviceNothingnessException(String message){
        super(message);
    }
    public int getErrorCode(){
        return error_code;
    }
}
