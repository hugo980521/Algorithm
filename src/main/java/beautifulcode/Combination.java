package beautifulcode;

import java.util.Arrays;

public class Combination {
    /**
     *
     * @param numArr 数组数组
     * @param n 总个数
     * @param m 取的个数
     * @param temp 临时数组
     * @param halfSum m个数的和大于halfSum
     * @param result m个数的和大于halfSum，且最小的结果数组
     */
    public static void comb(int[] numArr,int n,int m,int[] temp, int halfSum,int[] result){
        for(int i=n;i>=m;i--){
            temp[m-1]=numArr[i-1];
           if(m>1){
               comb(numArr,i-1,m-1,temp,halfSum,result);
           }else{
               int sum=0;
               for(int value:temp){
                   sum+=value;

               }
               System.out.println();

               if(sum>=halfSum){

                   if(result[temp.length]==0 || sum<result[temp.length]){
                       for(int k=0;k<temp.length;k++){
                           result[k]=temp[k];
                       }
                       result[temp.length]=sum;
                   }
               }

           }
        }
    }

    /**
     * 总个数为2n的数组，分为两个数组，每个数组个数为n,子数组和之差最小
     * @param numArr
     * @return
     */
    public static int[] getMax(int[] numArr){

        int sum=0;
        for(int i=0;i<numArr.length;i++){
            sum+=numArr[i];
        }
        int half=sum/2;
        if(sum%2==1){
            half++;
        }

        int num=numArr.length/2;
        int[] temp=new int [num];
        int[] result=new int [num+1];

        comb(numArr,numArr.length,num,temp,half,result);

        return result;
    }

    /**
     * 总个数为2n的数组，分为两个数组，每个数组个数不限制,子数组和之差最小
     * @param numArr
     * @return
     */
    public static void getMaxNum(int[] numArr){

        int sum=0;
        int len=numArr.length;
        for(int i=0;i<len;i++){
            sum+=numArr[i];
        }
        int half=sum/2;
        int[][] dp=new int[len+1][half+1];
        for(int i=1;i<=len;i++){
            for(int j=1;j<=half;j++){
               if(j>=numArr[i-1]){
                  dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-numArr[i-1]]+numArr[i-1]);
               }else{
                   dp[i][j]=dp[i-1][j];
               }
            }
        }
        for(int i=1;i<=len;i++){
            System.out.println();
            System.out.print(numArr[i-1]+"  ");
            for(int j=1;j<=half;j++){
                System.out.print(dp[i][j]+"  ");
            }
        }
        System.out.println();
        int j=dp[len][half];
        int i=len;
        while(j>0 && i>0){
            if(j>=numArr[i-1]){
               System.out.println(numArr[i-1]);
               j=j-numArr[i-1];
            }
            i--;
        }


//        System.out.println(dp[len][half]);

        return ;
    }


    public static void main(String[] args) {
        int[] numArr={ 1,3 ,11, 2, 5, 7,8};
        int[] result=getMax(numArr);
//        Arrays.stream(result).forEach(System.out::println);
        for(int i=0;i<result.length-1;i++){
            System.out.println(result[i]);
        }
        getMaxNum(numArr);

    }
}
