package leetcode.bitoperate;

import jnr.ffi.annotations.In;

public class BitOperate {

    public static int bitCount(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    public static int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a;
        int carry = b;

        while (carry != 0) {
            int temp = sum;
            sum = sum ^ carry;
            carry = (temp & carry) << 1;
        }
        return sum;
    }

    public static int subtract(int a, int b) {
        if (b == 0) {
            return a;
        }

        int temp=~b+1;
        return add(a,temp);
    }

    public static int multiply(int a, int b) {
        if(a==0 || b==0){
            return 0;
        }
       // 求补码
        int multiplier=getCom(a);
        int multiplicand=getCom(b);

        int product=0;
        while(multiplicand!=0){
            if((multiplicand & 0x1) ==1){
                product=add(product,multiplier);
            }
            multiplier=multiplier<<1;
            multiplicand=multiplicand>>1;
        }
        // 计算符号
        if((a^b)<0){
            product=getCom(product);
        }

        return product;
    }

    // 求补码
    private static int getCom(int value){
        int rtnValue=value;
        if(rtnValue<0){
            rtnValue=add(~value,1);
        }
        return rtnValue;
    }

    //求商
    public static int divide(int a, int b) {
        if(b==0){
            return 0;
        }

        //对被除数和除数取绝对值
        int dividend=getCom(a);
        int divisor=getCom(b);
        int remainder=dividend;
        int quotient=0; // 余数
        while(remainder>=divisor){
            quotient=add(quotient,1);
            remainder=subtract(remainder,divisor);
        }

        // 求商的符号
        if((a^b)<0){
            quotient=add(~quotient,1);
        }
        return quotient;



    }

    //求余
    public static int remainder(int a, int b) {
        if(b==0){
            return 0;
        }
        //对被除数和除数取绝对值
        int dividend = a < 0 ? add(~a, 1) : a;
        int divisor = b < 0 ? add(~b, 1) : b;

        //对被除数和除数的绝对值求商
        int remainder = dividend;
        int quotient = 0;

        while (remainder >= divisor) {
            remainder = subtract(remainder, divisor);
            quotient = add(quotient, 1);
        }

        //求余的符号
        if (a < 0) {
            remainder = add(~remainder, 1);
        }

        return remainder;
    }

    public static int getMax(int a, int b){
        int temp=a-b;
        int signA=sign(temp);
        int signB=flip(signA);

        return a*signA+b*signB;
    }

    public static int getMax2(int a, int b){
        int c=a-b;
         int sa=sign(a);
        int sb=sign(b);
        int sc=sign(c);
        int diffSab=sa^sb;
        int sameSab=flip(diffSab);
        int returnA=sa*diffSab+sc*sameSab;
        int returnB=flip(returnA);

        return a*returnA+b*returnB;
    }

    public static int flip(int n){
        return  n^1;
    }

    public static int sign(int n){
        int sign=n>>31;
        return flip(sign&1);
    }

    public static int updateBits(int n,int m,int i,int j){
        // 边界条件
        if(i>31 || j>31 || j<i || i<1|| j<1|| m<0 || n<0){
            return 0;
        }


        // 取得m的位数
        int mLen=0;
        int mTemp=m;
        while(mTemp!=0){
            mLen++;
            mTemp= mTemp>>1;
        }
        int len=j-i+1;
        if(len<mTemp){
            return 0;
        }


        int  nClear=clear(n,i,j);
        System.out.println("nClear:"+ Integer.toBinaryString(nClear));
        // m左移
        int mLocal=m<<i;
        System.out.println("mLocal:"+ Integer.toBinaryString(mLocal));
        int result=nClear|mLocal;

        return result;
    }


    /**
     * 下标从0开始 1是第2位
     * @param n
     * @param i
     * @param j
     * @return
     */
    public static int clear(int n, int i,int j){
        // 将n的i到j清零
        int mask=getMask(n,i,j);
        int nClear=n&mask;
        return  nClear;
    }

    private static int getMask(int n,int i,int j){
        int allOne=~0;
        int  right=allOne<<(j+1);
        System.out.println("right:"+Integer.toBinaryString(right));
        int left=(1<<i)-1;
        System.out.println("left:"+Integer.toBinaryString(left));
        System.out.println("left|right:"+Integer.toBinaryString((left|right)));
        int mask=left|right;
        return mask;
    }
    /**
     * 把 i到j以外的清零 下标从 0开始
     * @param n
     * @param i
     * @param j
     * @return
     */
    public static int clearNot(int n,int i,int j){
        int mask=getMask(n,i,j);
        mask=~mask;
        int result=n&mask;
        return result;
    }

    /**
     * 把指定位置1，下标从0开始
     * @return
     */
    public static int setToOne(int n,int i){
        int nLocal=n;
        System.out.println("n:"+Integer.toBinaryString(nLocal));
        System.out.println("1<<"+i+":"+Integer.toBinaryString((1<<i)));
        nLocal=nLocal|(1<<i);
        return nLocal;
    }

    /**
     * 把指定位置0，下标从0开始
     * @return
     */
    public static int setToZero(int n,int i){
        int nLocal=n;
        System.out.println("n:"+Integer.toBinaryString(nLocal));
        nLocal=nLocal&(~(1<<i));
        return nLocal;
    }

    /**
     * 获取指定位上的数字 ，下标从0开始
     * @return
     */
    public static int getIndex(int n,int i){
        System.out.println("n:"+Integer.toBinaryString(n));
        int nLocal=n>>(i+1);
        System.out.println("n>>"+(i+1)+":"+Integer.toBinaryString(nLocal));
        nLocal=nLocal&1;
        return nLocal;
    }


    public static int missingNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor ^ nums.length;
    }

    public static void main(String[] args) {
        int result=0;
//        int result = bitCount(-1);
//        System.out.println(result);
//
//        result = subtract(-2, 2);
//        System.out.println(result);
//
//        result = add(-2, 2);
//        System.out.println(result);
//
//        result = multiply(-2, 3);
//        System.out.println(result);
//
//        result = divide(-2, 2);
//        System.out.println(result);
//
//        result=getMax(-2,8);
//        System.out.println(result);
//
//        result=getMax2(-2,Integer.MAX_VALUE);
//        System.out.println(result);
//        result=updateBits(1024,19,2,6);
//       System.out.println(result);
//       result=clearNot(31,3,4);
//      System.out.println(result);

        result=getIndex(-8,1);
        System.out.println(result);

        int[] numArr= new int[]{0,1,2};
        System.out.println(missingNumber(numArr));
    }
}
