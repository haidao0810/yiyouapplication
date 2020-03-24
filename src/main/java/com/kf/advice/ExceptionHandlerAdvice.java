package com.kf.advice;

import com.kf.common.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    @ExceptionHandler(DeviceNothingnessException.class)
    public String handleDeviceException(DeviceNothingnessException e){
        return JSONResult.initErrorResult(e.error_code,e.getMessage()).toJsonString();
    }
    @ExceptionHandler(ExcelFileException.class)
    public String handleNoExcelFileException(ExcelFileException e){
        return JSONResult.initErrorResult(e.error_code,e.getMessage()).toJsonString();
    }
}
