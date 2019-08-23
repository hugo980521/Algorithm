package beautifulcode;

public class MaxProductSequence {
    /**
     * 动态规划，每一步只需要记住其前一步的整数最大值和负数的最小值。
     * @param nums
     * @return
     */
    public static  int maxProduct(int[] nums) {
        int posmax=nums[0],negmax=nums[0],max=nums[0];

        for(int i=1;i<nums.length;i++){
            int tempPosMax = posmax;
            int tempNegMax = negmax;
            posmax = Math.max(nums[i],Math.max(nums[i]*tempPosMax,nums[i]*tempNegMax));
            negmax = Math.min(nums[i],Math.min(nums[i]*tempPosMax,nums[i]*tempNegMax));
            if(Math.max(posmax,negmax) > max){
                max = Math.max(posmax,negmax);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int[] arr={0,1,96,-1,0,-8,-12};
        int result=maxProduct(arr);
        System.out.println(result);
    }
}
