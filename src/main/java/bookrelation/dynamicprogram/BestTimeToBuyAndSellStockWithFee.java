package bookrelation.dynamicprogram;

public class BestTimeToBuyAndSellStockWithFee {

  /**
   * 只交易一次
   *
   * @param prices
   *
   * @return
   */
  public static int maxProfitOnlyOnlyOne(int[] prices) {
    int curMin = prices[0];
    int res = 0;
    for (int i = 1; i < prices.length - 1; i++) {
      res = Math.max(res, prices[i] - curMin);
      curMin = Math.min(curMin, prices[i]);

    }
    return res;
  }


  /**
   * 不限制交易次数,不能同时进行多笔交易
   *
   * @param prices
   *
   * @return
   */
  public static int maxProfitOnlyNotlimit(int[] prices) {
    int max = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] - prices[i] > 0) {
        max += prices[i + 1] - prices[i];
      }
    }
    return max;
  }

  /**
   * 含冷冻期
   */
  public static int maxProfitWithCool(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }

    int pricesSize=prices.length;
    int[] buy=new int[pricesSize];
    int[] sell=new int[pricesSize];
    int[] cool=new int[pricesSize];
    for(int i=0;i<pricesSize;i++){
      buy[i]=0;
      sell[i]=0;
      cool[i]=0;
    }
    buy[0]=-prices[0];
    for (int i = 1; i < pricesSize; ++i) {
      sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
      buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
      cool[i] = Math.max(sell[i - 1],cool[i - 1]);
    }
    return Math.max(sell[pricesSize-1],cool[pricesSize-1] );
  }


  /**
   * 思路：动态规划
   * 带手续费
   */
  public static int maxProfitWithFee(int[] prices, int fee) {
    if (prices == null || prices.length <= 0 || fee < 0) {
      return 0;
    }

    // buy代表当天买股票的最大收益，sell代表当天卖出股票的最大收益
    int buy = Integer.MIN_VALUE;
    int sell = 0;

    for (int p : prices) {
      int tmp = buy;
      buy = Math.max(buy, sell - p - fee);
      sell = Math.max(sell, tmp + p);
    }

    return sell;
  }



  /**
   * 思路：动态规划
   * 状态穷举：
   * dp[i][k][1] 标识第i天 交易了k次手里持有股票的收益 ； dp[i][k][0] 标识第i天 交易了k次手里没有股票的收益
   * 状态转移：(买入股票的时候k+1)
   * dp[i][k][1]怎么获得，第i-1天持有股票没有卖出 dp[i-1][k][1]|| 第i-1天没有股票买入dp[i-1][k-1][0]-prices[i]
   * dp[i][k][0]怎么获得，第i-1天没有股票没有卖入 dp[i-1][k][0]|| 第i-1天有股票卖出 dp[i-1][k][0]+prices[i]
   * <p>
   * base case：
   * dp[-1][k][0] = dp[i][0][0] = 0 (没开始 或者 没有交易，手里没有股票)
   * dp[-1][k][1] = dp[i][0][1] = -infinity (没开始，或没交易， 手里有股票，因为此种情况不可能)
   * <p>
   * 优化后解法如下：
   * t[i][0]和t[i][1]分别表示第i比交易买入和卖出时 各自的最大收益
   */
  public static int maxProfitWithK(int k, int[] prices) {
    /**
     当k大于等于数组长度一半时, 问题退化为贪心问题此时采用 买卖股票的最佳时机 II
     的贪心方法解决可以大幅提升时间性能, 对于其他的k, 可以采用 买卖股票的最佳时机 III
     的方法来解决, 在III中定义了两次买入和卖出时最大收益的变量, 在这里就是k租这样的
     变量, 即问题IV是对问题III的推广, t[i][0]和t[i][1]分别表示第i比交易买入和卖出时
     各自的最大收益
     **/
    if (k < 1) {
      return 0;
    }
    if (k >= prices.length / 2) {
      return maxProfitOnlyNotlimit(prices);
    }
    int[][] t = new int[k][2];
    for (int i = 0; i < k; ++i) {
      t[i][0] = Integer.MIN_VALUE;
    }
    for (int p : prices) {
      t[0][0] = Math.max(t[0][0], -p);
      t[0][1] = Math.max(t[0][1], t[0][0] + p);
      for (int i = 1; i < k; ++i) {
        t[i][0] = Math.max(t[i][0], t[i - 1][1] - p);
        t[i][1] = Math.max(t[i][1], t[i][0] + p);
      }
    }
    return t[k - 1][1];
  }


  public static void main(String[] args) {
    int[] prices = {1, 3, 7, 5, 10, 3};
    System.out.println(maxProfitWithK(2,prices));
  }
}
