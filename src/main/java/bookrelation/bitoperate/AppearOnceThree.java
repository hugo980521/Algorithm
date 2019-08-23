package bookrelation.bitoperate;

/**
 *给定一个数组，其中只有一个数x出现一次，别的数都出现3次，找出这个数x。（线性时间复杂度）
 */
public class AppearOnceThree {

    /**
     * 可以设置一个长度为32的int数组。统计每位上出现1的次数，如果次数能被3整除，说明x该位上为0，否则为1
     * @param nums
     * @return
     */
    public static int appearOnce(int[] nums){
        int len = nums.length;
        int[] bits = new int[32];
        for(int i = 0 ; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] += ((nums[i]>>j)&1);
            }
        }


        int result = 0;
        for(int i = 0 ; i < 32; i++){
            if(bits[i] % 3 == 1) {
                result += 1 << i;
            }
        }
        return result;
    }
}
