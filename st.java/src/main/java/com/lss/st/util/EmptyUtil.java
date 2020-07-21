package com.lss.st.util;

import sun.invoke.empty.Empty;

import java.util.List;

public class EmptyUtil {
    public static boolean isEmpty(Object obj){
        if(obj == null){
            return true;
        }
        if((obj instanceof List)){
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String)){
            return  ((String) obj ).trim().equals("");
        }
        return false;
    }
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }
}
