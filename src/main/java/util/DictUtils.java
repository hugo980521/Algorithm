package util;




import com.talkingdata.bluecat.bean.EventType;
import com.talkingdata.bluecat.bean.Platform;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/4 0004.
 */
public class DictUtils {
    public static Map getEventTypeMap(){

            Map<String,String> localMap= new HashMap<String,String>();
            for(EventType loopBean: EventType.values()){
                localMap.put(String.valueOf(loopBean.getValue()),loopBean.getName());
            }
            return localMap;
    }

    public static Map getPlatformMap(){

        Map<String,String> localMap= new HashMap<String,String>();
        for(Platform loopBean: Platform.values()){
            localMap.put(String.valueOf(loopBean.getValue()),loopBean.getName());
        }
        return localMap;
    }


}
