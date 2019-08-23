package bookrelation.dynamicprogram;

/**
 * 赛诗会后，十二金钗待奔前程。分别宴上，12人各写了一首诗放入包囊。

 大家随机取一个，若取到自己的诗，则再取一个，并放回自己的诗，12人都拿到诗算一种分配。

 请问：共有多少种不同的分配？
 */
public class GoldenJubilee {

    /**
     * 动态规划
     * dp[n]=(n-1)*(dp[n-1]+dp[n-2])；

     初始状态：

     当n=1;dp[1]=0;

     当n=2;dp[2]=1;（两个数，只存在一种错排的可能）
     * @param n
     * @return
     */
    public long miscombinationDp(int n){
        long dp[]=new long[n+1];
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=(i-1)*(dp[i-1]+dp[i-2]);
        }
        return dp[n];
    }

    /**
     * 用两个变量代替动态规划数组
     *
     * @param n
     * @return
     */
    public long miscombinationNormal(int n){
        if(n<=2){
            return n-1;
        }
        long first=0;
        long second=1;
        long third=0;
        for(int i=3;i<=n;i++){
            third=(i-1)*(first+second);
            first=second;
            second=third;
        }
        return third;
    }

    public static void main(String[] args) {
        GoldenJubilee goldenJubilee = new GoldenJubilee();
        int n=30;
       long sum= goldenJubilee.miscombinationDp(n);
        System.out.println(sum);
    }
}
