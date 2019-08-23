package leetcode.bitoperate;

public class Exchange {

   public static int exchangeOddEven(int x) {

        // write code here
        int odd = (x & 0xAAAAAAAA);//换取x的奇数位信息
        int even = (x & 0x55555555);//偶数位信息
        return (odd >> 1) + (even << 1);
    }


    public static void main(String[] args) {
        int result=exchangeOddEven(10);

        String strOdd=Integer.toBinaryString(0xAAAAAAAA);
        System.out.println(strOdd);
        String strEven =Integer.toBinaryString(0x55555555);
        System.out.println(strEven);
        System.out.println();
        System.out.println(0x55555555);


        System.out.println(result);
    }
}
