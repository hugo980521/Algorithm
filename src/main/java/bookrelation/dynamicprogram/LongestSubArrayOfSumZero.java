package bookrelation.dynamicprogram;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为零的最大连续子数组
 *
 * 我首先想到的是前缀数组和，遍历一遍数组，计算出sum[i]（表示从0-i的子数组之和）。
 有了前缀数组和，只要sum[i]=sum[j]（i<j），那么区间[i+1,j]就是和为零的子数组，
 只要在遍历前缀数组和时记录最长的区间即可。
 需要注意的是：当sum[i]等于0时，其区间为[0,i]。
 在判断sum[i]=sum[j]（i<j）时，有个查找的过程，要么直接遍历j左边的所有数（增加时间复杂度），
 要么通过map来存储对应和的下标位置（空间换时间）。（详见代码）
 */
public class LongestSubArrayOfSumZero {

    public int longestSubArrayOfSumZero(int[] arr){
        System.out.println("=========longestSubArrayOfSumZero==========");
        int sz=arr.length;
        int[] preSum= new int[sz+1];

        for(int i=0;i<sz;i++){
            preSum[i+1]=preSum[i]+arr[i];

        }
        for(int i=0;i<preSum.length;i++){
            System.out.println("i="+i +"  "+preSum[i]);
        }

        int longest=0;
        int start=0;
        for(int i=1;i<=sz;i++){
            for(int j=0;j<i;j++){
                if(preSum[i]==preSum[j] && (i-j)>longest){
                    longest=i-j;
                    start=j;
                }
            }
        }
        System.out.println("start="+start+ "  longest="+longest);
        for(int i=start;i<start+longest;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return longest;
    }


    /**
     * O(n)
     * @param arr
     * @return
     */
    public int longestSubArrayOfSumZeroQuick(int[] arr){
        System.out.println("=========longestSubArrayOfSumZeroQuick=========");
        int sz=arr.length;
        Map<Integer,Integer> posMap = new HashMap<Integer,Integer>();

        int sum=0;
        int longest=0;
        int start=0;
        for(int i=0;i<sz;i++){
            sum=sum+arr[i];
            if(posMap.containsKey(sum)){
                int len=i-posMap.get(sum);
                if(len>longest){
                    longest=len;
                    start=posMap.get(sum)+1;
                }
            }else{
                posMap.put(sum,i);
            }
        }

        System.out.println("start="+start+ "  longest="+longest);
        for(int i=start;i<start+longest;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return longest;
    }

    public static void main(String[] args) {
        LongestSubArrayOfSumZero longestSubArrayOfSumZero = new LongestSubArrayOfSumZero();
        int[] arr={3,1,3,-1,-2,-1,2,-1,-1,4};
        longestSubArrayOfSumZero.longestSubArrayOfSumZero(arr);

        longestSubArrayOfSumZero.longestSubArrayOfSumZeroQuick(arr);
    }
}
