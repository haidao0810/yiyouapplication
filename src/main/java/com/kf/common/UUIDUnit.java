package com.kf.common;

import java.util.UUID;

public class UUIDUnit {

    public static String initUUID(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
}
