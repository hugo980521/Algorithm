package leetcode.bitoperate;

public class LetCode169 {
  public int majorityElement(int[] nums) {
    if (null == nums || nums.length < 1) {
      return 0;
    }

    int count = 1;
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == res) {
        count++;
      } else {
        count--;
      }
      if (count == 0) {
        res = nums[i];
        count = 1;
      }
    }
    return res;

  }
}
