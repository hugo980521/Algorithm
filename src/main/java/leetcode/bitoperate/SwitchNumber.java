package leetcode.bitoperate;

public class SwitchNumber {
    public static void switchNumber(int a, int b){
        int localA=a;
        int localB=b;
        localA=localA^localB;
        localB=localB^localA;
        localA=localA^localB;

        System.out.println(localA+" "+ localB);

    }

    public static void main(String[] args) {
        switchNumber(-100,200);
    }
}
