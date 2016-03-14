package ywq.dr.chaptr.ywq.dr.chaptr.util;

import org.apache.commons.collections.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by xm001 on 2016/3/11.
 */
public class CollectionUtil {

    /**
     * 判断Collection 是否为空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection){
        return CollectionUtil.isEmpty(collection);
    }

    public static boolean isNotEmpty(Collection<?> collection){
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?,?> map){

        return MapUtils.isEmpty(map);
    }

    public static boolean isNotEmpty(Map<?,?> map){

        return !isEmpty(map);
    }

}
