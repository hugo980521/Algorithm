package util;

import java.util.UUID;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class BluecatUUIDUtil {
    public  static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        uuid=uuid.replace("-","");
        uuid="bluecat-"+uuid;

        return  uuid;
    }
}
