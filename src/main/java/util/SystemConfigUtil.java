package util;


import java.util.Map;

public class SystemConfigUtil {

    static SystemConfigUtil configs = null;


    private Map<String, String> nameMap = null;

    public Map<String, String> getNameMap() {
        return nameMap;
    }

    public void setNameMap(Map<String, String> nameMap) {
        this.nameMap = nameMap;
    }

    public static SystemConfigUtil getInstance() {
        if (configs == null) {

            configs = (SystemConfigUtil) SpringContextUtil.getBean("systemConifg");
        }
        return configs;
    }

    public static String getMapByKey(final String key) {
        return SystemConfigUtil.getInstance().getNameMap().get(key);
    }

    public String getStrByKey(final String key) {
        return nameMap.get(key);
    }
}
