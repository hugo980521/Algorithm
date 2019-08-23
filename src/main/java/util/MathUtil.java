package util;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: liuyaqian
 * Date: 20151110
 * Time: 下午2:40
 * To change this template use File | Settings | File Templates.
 */
public class MathUtil {


    /**
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 2个参数的商
     */
    public static double div(Double v1, Double v2, int scale) {

        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        Double v1Local=v1;
        Double v2Local=v2;
        if(ObjectUtils.isEmptyObject(v1) ){
            v1Local=0d;
        }

        if(ObjectUtils.isEmptyObject(v2) ){
            v2Local=0d;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1Local));
        BigDecimal b2 = new BigDecimal(Double.toString(v2Local));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }



    /**
     * @param v1 乘数
     * @param v2 被乘数
     * @return 2个参数的积
     */
    public static double mul(Double v1, Double v2) {
        Double v1Local=v1;
        Double v2Local=v2;
        if(ObjectUtils.isEmptyObject(v1) ){
            v1Local=0d;
        }

        if(ObjectUtils.isEmptyObject(v2) ){
            v2Local=0d;
        }

        BigDecimal b1 = new BigDecimal(Double.toString(v1Local));
        BigDecimal b2 = new BigDecimal(Double.toString(v2Local));
        return b1.multiply(b2).doubleValue();
    }



    /**
     * 减法
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 结果
     */
    public static double sub(Double v1, Double v2) {
        Double v1Local=v1;
        Double v2Local=v2;
        if(ObjectUtils.isEmptyObject(v1)){
            v1Local=0d;
        }

        if(ObjectUtils.isEmptyObject(v2) ){
            v2Local=0d;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1Local));
        BigDecimal b2 = new BigDecimal(Double.toString(v2Local));
        return b1.subtract(b2).doubleValue();
    }



    /**
     * 加法
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 结果
     */
    public static double add(Double v1, Double v2) {
        Double v1Local=v1;
        Double v2Local=v2;
        if(ObjectUtils.isEmptyObject(v1)){
            v1Local=0d;
        }

        if(ObjectUtils.isEmptyObject(v2) ){
            v2Local=0d;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1Local));
        BigDecimal b2 = new BigDecimal(Double.toString(v2Local));
        return b1.add(b2).doubleValue();
    }

    /**
     * 加法
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 结果
     */
    public static Long add( Long v1, Long v2) {
        Long v1Local=v1;
        Long v2Local=v2;
        if(ObjectUtils.isEmptyObject(v1)){
            v1Local=0l;
        }

        if(ObjectUtils.isEmptyObject(v2) ){
            v2Local=0l;
        }
        BigDecimal b1 = new BigDecimal(Long.toString(v1Local));
        BigDecimal b2 = new BigDecimal(Long.toString(v2Local));
        return b1.add(b2).longValue();
    }


    /**
     * 三数连加
     *
     * @param v1
     * @param v2
     * @param v3
     * @return 结果
     */
    public static double add(Double v1, Double v2, Double v3) {
        Double v1Local=v1;
        Double v2Local=v2;
        Double v3Local=v3;
        if(ObjectUtils.isEmptyObject(v1) ){
            v1Local=0d;
        }

        if(ObjectUtils.isEmptyObject(v2) ){
            v2Local=0d;
        }

        if(ObjectUtils.isEmptyObject(v3) ) {
            v3Local = 0d;
        }

        BigDecimal b1 = new BigDecimal(Double.toString(v1Local));
        BigDecimal b2 = new BigDecimal(Double.toString(v2Local));
        BigDecimal b3 = new BigDecimal(Double.toString(v3Local));
        return b1.add(b2).add(b3).doubleValue();
    }

    /**
     *  四数连加
     *
     * @param v1
     * @param v2
     * @param v3
     * @return 结果
     */
    public static double add(Double v1, Double v2, Double v3,Double v4) {
        Double v1Local=v1;
        Double v2Local=v2;
        Double v3Local=v3;
        Double v4Local=v4;
        if(ObjectUtils.isEmptyObject(v1)){
            v1Local=0d;
        }

        if(ObjectUtils.isEmptyObject(v2) ){
            v2Local=0d;
        }

        if(ObjectUtils.isEmptyObject(v3)) {
            v3Local = 0d;
        }


        if(ObjectUtils.isEmptyObject(v4)) {
            v4Local = 0d;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1Local));
        BigDecimal b2 = new BigDecimal(Double.toString(v2Local));
        BigDecimal b3 = new BigDecimal(Double.toString(v3Local));
        BigDecimal b4 = new BigDecimal(Double.toString(v4Local));
        return b1.add(b2).add(b3).add(b4).doubleValue();
    }



    public static double pow(Double v1, int n) {
        Double v1Local=v1;
        if(ObjectUtils.isEmptyObject(v1) ){
            v1Local=0d;
        }

        BigDecimal b1 = new BigDecimal(Double.toString(v1Local));
        return b1.pow(n).doubleValue();
    }


    /**
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static Double round(Double v, int scale) {
        Double vLocal=v;
        if(ObjectUtils.isEmptyObject(v) ){
            vLocal=0d;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(vLocal));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * zhaoyan
     *
     * @param v     不需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 直接舍弃小数点后两位之后的结果
     */
    public static Double roundNoUp(Double v, int scale) {
        Double vLocal=v;
        if(ObjectUtils.isEmptyObject(v)){
            vLocal=0d;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(vLocal));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_FLOOR).doubleValue();
    }



    /**
     * @param v         四舍五入的数字
     * @param roundType 四舍五入的形式
     * @param scale     小数点后保留几位
     * @return 四舍五入的结果
     */
    public static Double round(Double v, int roundType, int scale) {
        Double vLocal=v;
        if(ObjectUtils.isEmptyObject(v) ){
            vLocal=0d;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(vLocal));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, roundType).doubleValue();
    }

    /**
     * 空时变成0
     * @param value
     * @return
     */
    public static double excludeNull(Double value){
        double rtnDouble=0;
        if(ObjectUtils.isNotEmptyObject(value)){
            rtnDouble=value;
        }

        return rtnDouble;
    }


}
