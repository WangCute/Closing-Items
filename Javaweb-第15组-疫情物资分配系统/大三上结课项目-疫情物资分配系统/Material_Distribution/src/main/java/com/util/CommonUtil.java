package com.util;

import java.util.UUID;

public class CommonUtil {
    // 生成id
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
