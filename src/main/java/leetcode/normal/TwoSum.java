package leetcode.normal;

import com.fasterxml.jackson.databind.ObjectMapper;
import util.ObjectUtils;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            m.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            if (m.containsKey(t) && m.get(t) != i) {
                res[0] = i;
                res[1] = m.get(t);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper= ObjectUtils.getObjectmapper();
        TwoSum twoSum = new TwoSum();
        int[] numArr={2, 7, 11, 15};
        int target=13;
       int[] result= twoSum.twoSum(numArr,target);
       System.out.println("target="+target);
       System.out.println("result="+ObjectUtils.getObjectStr(result));

    }
}
