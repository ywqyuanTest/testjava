package ywq.dr.chaptr.ywq.dr.chaptr.util;

import com.mysql.jdbc.StringUtils;
import sun.nio.cs.ext.IBM037;

/**
 * Created by xm001 on 2016/3/11.
 */
public class CastUtil {

    /**
     * 转为String 型
     *
     */
    public static String castString(Object obj){

        return CastUtil.castString(obj, "");
    }

    private static String castString(Object obj, String s) {

        return obj != null ? String.valueOf(obj):s;
    }
    /**
     * 转为double型
     *
     */
    public static double castDouble(Object obj){
        return CastUtil.castDouble(obj,0);
    }

    public static double castDouble(Object obj, double i) {
        double doublevalue = i;
        if(obj !=null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try {
                    doublevalue  =Double.parseDouble(strValue);
                }catch (NumberFormatException e){

                    doublevalue = i;
                }
            }
        }
        return doublevalue;
    }

    /**
     * 转为long
     */
    public static long castLong(Object obj){
        return CastUtil.castLong(obj,0);
    }

    private static long castLong(Object obj, long i) {

        long longValue = i;
        if(obj !=null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try {
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue = i;
                }
            }
        }
        return  longValue;
    }
    /**
     * 转为整型
     */
    public static int castInt(Object obj) {
        return CastUtil.castInt(obj, 0);
    }

    private static int castInt(Object obj, int i) {

        int intvalue = i;
        if(obj !=null){
            String strvalue = castString(obj);
            if(StringUtil.isNotEmpty(strvalue)){
                try{
                    intvalue = Integer.parseInt(strvalue);
                }catch (NumberFormatException e){

                    intvalue = i;
                }
            }
        }
        return intvalue;
    }
    /**
     *
     * 转为boolean
     */

    public static boolean castBoolean(Object obj){
        return CastUtil.castBoolean(obj,false);
    }

    private static boolean castBoolean(Object obj, boolean b) {
        boolean booleanValue = b;
        if(obj != null){
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }

}
