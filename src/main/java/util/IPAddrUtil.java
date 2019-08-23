package util;


import javax.servlet.http.HttpServletRequest;

/**
 * 说明：ip地址实用类
 *
 * @author kuangzuoqiang
 * @version 2013-4-8
 */
public class IPAddrUtil {

    /**
     * 根据request请求，获取访问的真正ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        //防止多级代理形成以逗号相隔的多个ip
        return ip.split(",")[0].trim();
    }

    /**
     * 获取第一层服务器的地址（有可能是项目地址，有可能是反向代理地址）
     *
     * @param request
     * @return
     */
    public static String getFirstServerAddr(HttpServletRequest request) {
        String bases = request.getHeader("X-FORWARDED-HOST");
        if (bases == null || bases.length() < 1) {
            bases = request.getHeader("Host");
        }

        if (bases == null || bases.length() < 1) {
            bases = request.getServerName() + ":" + request.getServerPort();
        }

        return request.getScheme() + "://" + bases;
    }

}
