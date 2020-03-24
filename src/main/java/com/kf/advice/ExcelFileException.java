package com.kf.advice;

import com.kf.common.CollectionCode;

/**
 * 不是Excel 文件错误
 */
public class ExcelFileException extends RuntimeException {
    public int error_code= CollectionCode.NET_EXCEL_FILE_CODE_601;
    public ExcelFileException(String message){
        super(message);
    }

    public int getErrorCode(){
        return error_code;
    }
}
