package util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * 对象之间的转换
 * Created by yangguoliang on 2015/11/3.
 */
public class ObjectUtils {



    /**
     * 判断传入对象是否为空，空返回true，不为空返回false。
     * @param object
     * @return 判断结果
     */
    public  static boolean isEmptyObject(Object object){
        return(null==object);
    }

    /**
     * 判断传入对象是否为空，非空返回true，空返回false。
     * @param object
     * @return 判断结果
     */
    public  static boolean isNotEmptyObject(Object object){
        return(!isEmptyObject(object));
    }

    private static final ObjectMapper objectmapper = new ObjectMapper();

    static {
        objectmapper.registerModule(new JodaModule());
        objectmapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectmapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectmapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static ObjectMapper getObjectmapper(){
        return  objectmapper;
    }

    /**
     * 把对象序列化成json字符串
     * @param object
     * @return
     */
    public static  String getObjectStr(Object object){
        String rtnValue="";
        try {
            if(isNotEmptyObject(object)){
                rtnValue=objectmapper.writeValueAsString(object);
            }
        }catch (Exception ex){

        }
        return rtnValue;
    }
}
