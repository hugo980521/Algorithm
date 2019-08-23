package bookrelation.dynamicprogram;

/**
 * 扔棋子
 */
public class ThrowChess {

    public static void main(String[] args) {
        ThrowChess s = new ThrowChess();
        // s.maximalRectangle(new boolean[][]
        // {{true,true,false,false,true},{false,true,false,false,true},{false,false,true,true,true},{false,false,true,true,true},{false,false,false,false,true}});
        // s.maximalRectangle(new boolean[][] {{true}});
        // s.pick(new int[] {10,4,5,12});
        // s.shortestPalindrome("aacecaaa");
        int res = s.drop(1000);
        System.out.println(res);

        int max = s.drop_dp(1000,2);
        System.out.println(max);
    }

    //N層，2個棋子
    //數學特性
    public int drop(int n) {
        // x*x+x-2n>=0
        int a = 1;
        int b = 1;
        int c = -2 * n;

        double[] res = equation(a, b, c);

        return (int) Math.ceil(res[0]);
    }
    double[] equation(int a, int b, int c) {
        double delta = b * b - 4 * a * c;
        double[] res;
        if (delta < 0) {
            return new double[0];
        } else if (delta > 0) {
            res = new double[2];
            double tmp1,tmp2;
            tmp1 = ((-b + Math.sqrt(delta)) / (2 * a));
            tmp2 = ((-b - Math.sqrt(delta)) / (2 * a));
            res[0] = Math.max(tmp1, tmp2);
            res[1] = Math.max(tmp1, tmp2);
        } else {
            res = new double[] {-b / (2 * a)};
        }
        return res;
    }

    //N層，k個棋子
    //動態規劃
    public int drop_dp(int LAYERS, int CUPS ) {
        int[][] dp = new int[LAYERS+1][CUPS+1];
        int[][] route = new int[LAYERS+1][CUPS+1];
        //边界
        for(int i=1; i<=LAYERS; i++) {
            dp[i][1] = i;
        }
        for(int i=1; i<=CUPS; i++) {
            dp[1][i] = 1;
            route[1][i]=0;
        }

        for(int j=2;j<CUPS;j++){
            for(int i=2;i<LAYERS;i++){
                dp[i][j]=i;
                route[i][j]=0;
                for(int k=1;k<i;k++){
                    int mini=Math.max(dp[k-1][j-1],dp[i-k][j])+1;
                    route[i][j]=mini<=dp[i][j]?k:route[i][j];
                    dp[i][j]=mini<dp[i][j]?mini:dp[i][j];
                }
            }
        }

        return dp[LAYERS-1][CUPS-1];
    }

}
