package ywq.dr.chaptr.ywq.dr.chaptr.util;

import com.mysql.jdbc.StringUtils;

/**
 * Created by xm001 on 2016/3/11.
 */
public class StringUtil {


    public static boolean isEmpty(String strvalue) {
        if(strvalue!=null){
            strvalue = strvalue.trim();
        }
        return StringUtil.isEmpty(strvalue);
    }

    public static boolean isNotEmpty(String strvalue) {
        return !isEmpty(strvalue);
    }

}
