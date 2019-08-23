package util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxinliang
 * Date: 14-1-17
 * Time: 上午11:51
 * To change this template use File | Settings | File and Code Templates.
 */
public class PassWordUtil {


    /**
     * 注册密码加密规则
     *
     * @param password
     * @return
     */
    public static String getMd5Password(String password) {
        String pass = DigestUtils.md5Hex("&*()" + password + "!@#$%^");
        return pass;
    }

    /**
     * 支付密码加密规则
     *
     * @param password
     * @return
     */
    public static String getMd5PayPassword(String password) {
        String pass = DigestUtils.md5Hex(password);
        return pass;
    }

}
