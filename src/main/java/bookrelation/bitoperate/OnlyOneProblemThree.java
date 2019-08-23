package bookrelation.bitoperate;

/**
 给定一数组，数组中的数字均为int类型，除了一个数出现一次，其他都出现了三次，请找出这个数；
 */
public class OnlyOneProblemThree {
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
            if(bits[i] % 3 == 1){
                result += 1 << i;
            }
        }
        return result;
    }

    public static int singleNumberII(int[] nums){
        int one=0;
        int two=0;
        int three=0;

        // | 两个数只要有一个为1则为1，否则就为0。
        // ^ 相同则为0，不相同则为1。
        // ~ 如果 位为0，结果是1，如果位为1，结果是0.
        // & 如果两个数都为1则为1，否则为0。
        System.out.println(one+" = "+Integer.toBinaryString(one));
        System.out.println(two+" = "+Integer.toBinaryString(two));
        System.out.println(three+" = "+Integer.toBinaryString(three));

        System.out.println("========================");


        for(int i=0;i<nums.length;i++){
            System.out.println("========================"+i+"========================");
            System.out.println("one="+one+" = "+Integer.toBinaryString(one));
            System.out.println("nums[i]="+nums[i]+" = "+Integer.toBinaryString(nums[i]));
            System.out.println("before two="+two+" = "+Integer.toBinaryString(two));
            int temp=one&nums[i];
            System.out.println("one&nums[i]="+ temp + "=" + Integer.toBinaryString(temp));

            System.out.println();
            two |= one&nums[i];
            System.out.println("after【two |= one&nums[i];】 two="+two+" = "+Integer.toBinaryString(two));

            System.out.println();

            System.out.println(" before one="+one+" = "+Integer.toBinaryString(one));
            one ^= nums[i];

            System.out.println(" after【  one ^= nums[i]】 one="+one+" = "+Integer.toBinaryString(one));
            System.out.println();

            System.out.println(" before one="+one+" = "+Integer.toBinaryString(one));
            System.out.println("before two="+two+" = "+Integer.toBinaryString(two));
            int temp2=one&two;
            System.out.println("before one&two="+temp2+" = "+Integer.toBinaryString(temp2));
            three = ~(one&two);

            System.out.println(" after 【~(one&two)】 three="+three+" = "+Integer.toBinaryString(three));
            System.out.println();


            one&=three;
            System.out.println("after 【one&=three】one="+one+" = "+Integer.toBinaryString(one));
            System.out.println();

            two&=three;

            System.out.println("after 【two&=three】two ="+two+" = "+Integer.toBinaryString(two));
            System.out.println();

        }
        return one;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,4,1,1,1};
        OnlyOneProblemThree onlyOneProblemThree = new OnlyOneProblemThree();
        int number= onlyOneProblemThree.appearOnce(arr);
        System.out.println(number);
        number=onlyOneProblemThree.singleNumberII(arr);
        System.out.println(number);
    }
}
