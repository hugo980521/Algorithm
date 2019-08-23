package leetcode.bitoperate;

public class Letcode268 {
  public int missingNumber(int[] nums) {
    if(null==nums || nums.length==0){
      return -1;
    }
    int n=nums.length;
    int temp=n;
    for(int j=0;j<nums.length;j++){
      temp=temp^(j^nums[j]);
    }
    return temp;
  }
}
