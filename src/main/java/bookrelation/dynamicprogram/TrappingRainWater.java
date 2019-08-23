package bookrelation.dynamicprogram;

/**
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 题目的意思是说，给定一非负的整数数组，数组的每个数字表示柱子的高度，如果把这些柱子组成一个容器，最多能盛多少水？
 */
public class TrappingRainWater {

   public int maxTrappingWater(int[] water){
        int sz=water.length;

        int[] preMaxWater =new int[sz];
        preMaxWater[0]=0;
        for(int i=1;i<sz;i++){
            if(water[i]>preMaxWater[i-1]){
                preMaxWater[i]=water[i];
            }else{
                preMaxWater[i]=preMaxWater[i-1];
            }

        }

        int[] sufMaxWater = new int[sz];
        sufMaxWater[sz-1]=0;
        for(int i=sz-2;i>=0;i--){
            if(water[i]>sufMaxWater[i+1]){
                sufMaxWater[i]=water[i];
            } else{
                sufMaxWater[i]=sufMaxWater[i+1];
            }

        }

        int sum=0;
        for(int i=0;i<sz;i++){
            sum+=Math.max(0,Math.min(preMaxWater[i],sufMaxWater[i])-water[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int area=trappingRainWater.maxTrappingWater(arr);

        System.out.println(area);
    }
}
