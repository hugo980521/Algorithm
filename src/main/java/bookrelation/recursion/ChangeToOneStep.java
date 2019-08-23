package bookrelation.recursion;

/**
 * 假设有如下操作，偶数则除以2，奇数可以加1或减1，那么问给定某个数，让它变成1需要的最少操作是多少步？
 */
public class ChangeToOneStep {
    public int toOneStepRecursive(int n){
        if(n<1){
            return 0;
        }
        if(n==1){
            return 0;
        }
        if(n==2){
            return  1;
        }
        int mod=n%2;

        if(mod==0){
            int stepOdd=toOneStepRecursive(n-1)+1;
            int stepEven=toOneStepRecursive(n/2)+1;
            return Math.min(stepOdd,stepEven) ;
        }else{
            int stepOdd=toOneStepRecursive((n+1)/2)+2;
            int stepEven=toOneStepRecursive(n-1)+1;
            return Math.min(stepOdd,stepEven) ;

        }

    }

    public int toOneStepDp(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++){
          int mod=i%2;
          if(mod==1){
           // 奇数
              dp[i]=Math.min(dp[(i+1)/2]+2,dp[i-1]+1);
          }else{
              // 偶数
              dp[i]=Math.min(dp[i/2]+1,dp[i-1]+1);
          }

        }
        for(int i=0;i<=n;i++){
            System.out.println("i="+i+" dp:"+dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ChangeToOneStep changeToOneStep = new ChangeToOneStep();
        int n=1000;
        int stepRecursive=0;
        stepRecursive= changeToOneStep.toOneStepRecursive(n);
        int stepDp=0;
         stepDp= changeToOneStep.toOneStepDp(n);

       System.out.println("n="+n+"  stepRecursive="+stepRecursive  +" stepDp="+stepDp);
    }

}
