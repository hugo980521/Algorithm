package util;

import com.fasterxml.jackson.databind.JavaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1 0001.
 */
public class ListUtil {


    public static boolean isNotEmptyList(List lst){
        return !isEmptyList(lst);
    }

    public static boolean isEmptyList(List lst){
      boolean flag=false;
      if(null ==lst || lst.size() ==0){
          flag=true;
      }
      return  flag;
    }

    public static List<String> converToList(String str){
        List<String> lstLocal= new ArrayList<String>();
        if(StringUtils.isNotBlank(str)){

            String []  strArr= str.split(",");
            lstLocal =Arrays.asList(strArr);
        }
        return  lstLocal;
    }



    public static String  convertListToString(List<String> lstContent){
        String strLocal="";
        for(String content:lstContent){
            if(!StringUtils.isBlank(strLocal)){
                strLocal=strLocal+",";
            }
            if(StringUtils.isBlank(content)){
                content="";
            }
            strLocal=strLocal+content;
        }


        return strLocal;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return ObjectUtils.getObjectmapper().getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
