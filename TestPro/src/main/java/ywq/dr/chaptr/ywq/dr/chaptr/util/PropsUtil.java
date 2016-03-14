package ywq.dr.chaptr.ywq.dr.chaptr.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by xm001 on 2016/3/11.
 */
public class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);


    public static Properties LoadProps(String fileName) {

        Properties properties = null;
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {

                throw new FileNotFoundException(fileName + "file is  not found");

            }
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {

            LOGGER.error("load properties file failure", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();

                } catch (Exception e) {

                    LOGGER.error("close input steam failure", e);
                }
            }
        }
        return properties;
    }
    /*
    *获取字符型属性
    *
     */
    public static String getString(Properties props,String key){

        return getString(props,key,"");
    }

    private static String getString(Properties props, String key, String s) {
        String value = s;
        if(props.containsKey(key)){
            value = props.getProperty(key);
        }
        return value;
    }
    /*
    *获取数值属性
     */
    public static int getInt(Properties properties,String key){

        return getInt(properties,key,0);
    }

    private static int getInt(Properties properties, String key, int s) {
        int value = s;
        if(properties.containsKey(key)){
            value = Integer.parseInt(properties.getProperty(key));

        }
        return  value;
    }
    /*
    * 获取布尔值
     */
    public static boolean getBoolean(Properties properties,String key){
        return getBoolean(properties,key,false);
    }

    private static boolean getBoolean(Properties properties, String key, boolean b) {

        boolean value = b;
        if(properties.containsKey(key)){
            value = CastUtil.castBoolean(properties.getProperty(key));
        }
        return  value;
    }


}
