package com.kf.common;

import org.springframework.http.HttpStatus;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/**
 * Created by CCX on 2019/11/3.
 */
public class JSONResult extends HashMap<String,Object> {
    public static final String KEY_STATUS = "status";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_DATA = "data";


    public static JSONResult initSuccessResult(String message){
        JSONResult jsonResult=new JSONResult();
        jsonResult.put(KEY_STATUS, HttpStatus.OK.value());
        jsonResult.put(KEY_MESSAGE, message);
        return jsonResult;

    }
    public static JSONResult initErrorResult(int errorCode,String message){
        JSONResult jsonResult=new JSONResult();
        jsonResult.put(KEY_STATUS, errorCode);
        jsonResult.put(KEY_MESSAGE, message);
        return jsonResult;
    }

    /**
     * 设置data
     */
    public JSONResult pusData(Object object){
        this.put(KEY_DATA,object);
        return this;
    }

    public String toJsonString(){
        return JSONObject.toJSONString(this);
    }
}
