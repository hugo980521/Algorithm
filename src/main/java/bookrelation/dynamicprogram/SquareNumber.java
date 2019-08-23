package bookrelation.dynamicprogram;

/**
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。
 * 你需要让平方数的个数最少。
 */
public class SquareNumber {
    /**
     * @param n a positive integer
     * @return an integer
     */
   public static int PerfectSquares(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sqrtInt = (int) (Math.sqrt(i));
            if (sqrtInt * sqrtInt == i) {
                dp[i] = 1;
                continue;
            }
            int mincount = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                mincount = Math.min(mincount, dp[j * j] + dp[i - j * j]);
            }
            dp[i] = mincount;
        }
        return dp[n];
    }

    public static void main(String[] args) {
      int count= PerfectSquares(99);
      System.out.println(count);
    }
}
