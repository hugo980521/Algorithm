package leetcode.bitoperate;

public class SingleNumber {
    public static int getSingleNumber(int[] nums){
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            temp=temp^nums[i];
        }
        return temp;
    }

    public static int getSingleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int c : nums) {
            b = b ^ c & ~a;
            a = a ^ c & ~b;
        }
        return b;
    }
    /**
     * 其他都出现K次，返回只出现一次的值
     * K进制数相加
     * @param numArr
     * @return
     */
    public static int getSingleNumberK(int[] numArr,int k){
        int[] nagtive=new int[32];
        int[] positive=new int[32];

        for(int i=0;i<numArr.length;i++){
            int local=numArr[i];
            if(local >=0){
                addK(nagtive,local,k);
            }else{
                addK(positive,Math.abs(local),k);
            }

        }
        return getK(nagtive,k)-getK(positive,k);
    }

    public static void addK(int[] numArr,int b, int k){
        int temp=b;
        int index=0;
        while(temp!=0){
           numArr[index]= (numArr[index]+temp%k)%k;
            temp=temp/k;
            index++;
        }
    }
    public static int getK(int[] result,int k){

//        int base=k;
//        int value=0;
//        for(int i=0;i<numArr.length;i++){
//            base=base*i;
//            value+=numArr[i]+base;
//        }

        int res = 0;
        for (int i = result.length - 1; i != -1; i--) {
            res = res * k + result[i];
        }
        return res;

//        return value;
    }

    public static void main(String[] args) {
         int[] numArr=new int[]{2,2,3,5,3};
        int result=getSingleNumber(numArr);
        System.out.println(result);

        int[] numArrK=new int[] { -1, -1, -1, -1, -1, 2, 2, 2, 4, 2, 2 };
        int resultK=getSingleNumberK(numArrK,5);
        System.out.println(resultK);
    }
}
