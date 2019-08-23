package bookrelation.dynamicprogram;

/**
 * //给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],…,k[m].
 // 请问k[0]k[1]…*k[m]可能的最大乘积是多少？
 // 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 //采用动态规划解法，状态转移方程为f(n)=max{f(i)*f(n-i)}

 */
public class CutRope {
    private static int  cutRope(int n){
        if(n<2){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        //创建数组存储子问题最优解
        // 数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。
        int[] arrInt=new int[n+1];

        //这些情况下，不剪的时候长度比剪的时候长，所以作为初始条件
        //这些都是子问题最优解,因为是子问题，所以这些情况可以不剪，因为可以看成它是分割后的一部分
        arrInt[0]=0;
        arrInt[1]=1;
        arrInt[2]=2;
        arrInt[3]=3;
        for(int i=4;i<n+1;i++){
            int max=0;
            int len=(i/2);
            for(int j=2;j<=len;j++){
               int mult=arrInt[j] * arrInt[i-j];
               if(max<mult){
                   max=mult;
               }
            }
            arrInt[i]=max;
        }
        for(int i=0;i<=n;i++){
           System.out.println("i="+i +" "+arrInt[i]);
        }
        return arrInt[n];
    }

    public static void main(String[] args) {
        System.out.println(cutRope(200));
    }
}
