package beautifulcode;

public class Permutation {
    public static void fullPermutation(int numArr[],int start,int end){
        // 递归终止条件
        if (start == end) {
            for (int i : numArr) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(numArr, i, start);
            fullPermutation(numArr, start + 1, end);
            swap(numArr, i, start);
        }
    }

    public static void swap(int[] numArr, int i,int j){
        int temp=numArr[i];
        numArr[i]=numArr[j];
        numArr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        fullPermutation(arr, 0, arr.length - 1);
    }
}
