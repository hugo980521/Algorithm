package bookrelation.dynamicprogram;

/**
 * 连续子数组的和

 */
public class FindMaxSum {

    //
    public int findGreatestSumOfSubArray(int[] array) {

        if(array == null || (array.length == 1 && array[0] <= 0))
            return 0;

        int cur = array[0];
        int sum = array[0];
        for(int i = 1;i < array.length;i++){
            if(cur < 0){
                cur = 0;
            }
            cur = cur + array[i];
            if(sum <= cur){
                sum = cur;
            }

        }
        return sum;
    }

    //用动态规划
    public int findGreatestSumOfSubArrayDp(int[] arr,int n){
        int sum = arr[0];
        int max = arr[0];
        for(int i = 1; i < n; i++){
            sum = getMax(sum+arr[i],arr[i]);
            if(sum >= max){
                max = sum;
            }

        }

        return max;
    }

    public int getMax(int a,int b){
        return a > b ? a: b;
    }

    public static void main(String[] args) {
         int[] sumArr= {1 ,-2 ,3 ,10 ,-4 ,7 ,2 ,5};
        FindMaxSum findMaxSum = new FindMaxSum();
        int max=findMaxSum.findGreatestSumOfSubArray(sumArr);
        System.out.println(max);
    }


}
