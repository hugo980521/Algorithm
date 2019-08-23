package beautifulcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长递增子序列
 */
public class LongestIncreaseSequence {
    public static int getLongestSequence(int[] arr){
       int[] lenArr=new int[arr.length];
       for(int i=0;i<arr.length;i++){
           lenArr[i]=1;
           for(int j=0;j<i;j++){
               if(arr[i]>arr[j] && lenArr[j]+1 >lenArr[i]){
                   lenArr[i]=lenArr[j]+1;
               }
           }
       }
       int maxLen=lenArr[0];
       int pre=arr[0];
       for(int i=1;i<lenArr.length;i++){
           if(lenArr[i]==maxLen){
               if(pre<arr[i]){
                   pre=arr[i];
               }
           }
           if(maxLen<lenArr[i]){
               System.out.println(pre);
               pre=arr[i];
               maxLen=lenArr[i];
           }
       }
      System.out.println(pre);

       return maxLen;
    }

  public static int getLongestSequenceWithList(int[] nums){
    List<Integer> lstInt=new ArrayList<>();
    for(int i=0;i<nums.length;i++){
      if(lstInt.isEmpty()|| nums[i]>lstInt.get(lstInt.size()-1)){
        lstInt.add(nums[i]);
      }else if(nums[i]<lstInt.get(lstInt.size()-1)){
        // 二分查找 <=arr[i] 的第一个位置
        int low=0;
        int upper=lstInt.size()-1;
        while(low<upper){
          int mid=low+(upper-low)/2;
          if(lstInt.get(mid)<nums[i]){
            low=mid+1;
          }else{
            upper=mid;
          }
        }
        if(lstInt.get(upper)<nums[i]){
          lstInt.set(upper,nums[i]);
        }
      }
    }
    System.out.println(lstInt);

    return lstInt.size();
  }

  public static int getLongestSequenceDp(int[] nums){
    if (nums == null || nums.length == 0) return 0;
    List<Integer> dp = new ArrayList<>();
    dp.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      if (dp.contains(nums[i])) continue;
      else if (nums[i] > dp.get(dp.size()-1)) dp.add(nums[i]);
      else if (nums[i] < dp.get(dp.size()-1)) {
        int l = 0, r = dp.size()-1;
        while (l < r) {
          int mid = l + (r - l) / 2;
          if (dp.get(mid) < nums[i]) l = mid + 1;
          else r = mid;
        }
        if(dp.get(r)<nums[i]){
          dp.set(r, nums[i]);
        }

      }
    }
    return dp.size();

  }

    public static void main(String[] args) {
        int[] arr={1,-1,2,-3,4,-5,6,7};
        int result=getLongestSequenceWithList(arr);

        System.out.println();
        System.out.println(result);
    }
}
