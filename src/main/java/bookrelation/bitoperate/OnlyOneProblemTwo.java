package bookrelation.bitoperate;

/**
 * 一个整型数组里除了两个数字之外，
 * 其他的数字都出现了两次。请些程序找出这两个只出现一次的数字。
 * 要求时间复杂度为O(n),空间复杂度为O(1).
 *
 * 假设两个只出现一次的数字分别为a、b，对数组元素进行两两异或后得到的值为c,
 * 可知c=a^b。因为a和b一定不同，所以c不等于0，那么c的二进制表示中一定有一位是1，
 * 即a,b在此位上分别为0,1或1,0。假设该位置是从低位起第x位，
 * 那么将数组分成两组，一组中的数字在第x位是0，
 * 另一组中的数字在第x位是1，则a和b分别属于两个子数组。
 * 分别求子数组中唯一只出现1次的数字，即可得到a和b
 */
public class OnlyOneProblemTwo {

    public void findNumsAppearOnceTwo(int[] arr){
        if(arr == null){
            return;
        }

        int number = 0;
        for(int i: arr){
            number^=i;
        }

        int index = findFirstBitIs1(number);
        int number1= 0,number2 = 0;
        for(int i : arr){
            if(isBit1(i,index)){
                number1^=i;
            } else{
                number2^=i;
            }

        }
        System.out.println(number1);
        System.out.println(number2);
    }
    private int findFirstBitIs1(int number){
        int indexBit = 0;
        while((number & 1)== 0){
            number = number >> 1;
            ++indexBit;
        }
        return indexBit;
    }
    private boolean isBit1(int number,int index){
        number = number >>index;
        return (number & 1) == 0;
    }

    public static void main(String[] args) {
         int[] arr = {2,4,3,6,3,2,5,5};

        OnlyOneProblemTwo onlyOneProblemTwo = new OnlyOneProblemTwo();
        onlyOneProblemTwo.findNumsAppearOnceTwo(arr);
    }
}
