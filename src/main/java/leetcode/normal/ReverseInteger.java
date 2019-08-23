package leetcode.normal;

/**
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class ReverseInteger {

    /**
     * 我们也可以用long long型变量保存计算结果，最后返回的时候判断是否在int返回内，参见代码如下：
     * @param x
     * @return
     */
    public static  int reverse(int x) {
        long  res = 0;
        while (x != 0) {
            res = 10 * res + x % 10;
            x /= 10;
        }
        int rtnValue=0;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            rtnValue= 0;
        }else{
            rtnValue=  (int) res;
        }
        return rtnValue;
    }

    public static void main(String[] args) {
        System.out.println(reverse(8000));
    }
}
