package bookrelation.bitoperate;

/**
 * 一个整数序列，每个元素出现两次，
 * 只有一个(两个)出现一次，找到这个(这两个)元素
 */
public class OnlyOneProblemSingle {
    public int findNumsAppearOne(int[] arr){
        int number=arr[0];
        for(int i=1;i<arr.length;i++){
            number=number ^ arr[i];
        }

        return number;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,4,3,6,3,2,5,5};
        OnlyOneProblemSingle onlyOneProblemSingle = new OnlyOneProblemSingle();
        int number= onlyOneProblemSingle.findNumsAppearOne(arr);
        System.out.println(number);
    }
}
