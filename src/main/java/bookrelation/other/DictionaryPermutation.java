package bookrelation.other;

import java.util.Arrays;

/**
 * 全排列
 * 给出一个字符串，输出所有可能的排列。
 */
public class DictionaryPermutation {

        private char[] data;
        private int length;

        public void permutate(String input) {
            // change the data type to we needed
            changeToData(input);
            // sort the data from small to big
            Arrays.sort(data);
            // output all the order
            System.out.println(data);
            while (nextPermutate()) {
                System.out.println(data);
            }
        }

        private void changeToData(String input) {
            if (input == null)
                return;
            data = input.toCharArray();
            length = data.length;
        }

        private boolean nextPermutate() {
            int end = length - 1;
            int swapPoint1 = end, swapPoint2 = end;
            // the actual swap-point is swapPoint1 - 1
            while (swapPoint1 > 0 && data[swapPoint1] <= data[swapPoint1 - 1])
                swapPoint1--;
            if (swapPoint1 == 0)
                return false;
            else {
                while (swapPoint2 > 0 && data[swapPoint2] <= data[swapPoint1 - 1])
                    swapPoint2--;
                swap(data, swapPoint1 - 1, swapPoint2);
                reverse(data, swapPoint1, end);
                return true;
            }
        }

        private void swap(char[] data, int left, int right) {
            char temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }

        private void reverse(char[] data, int left, int right) {
            for (int i = left, j = right; i < j; i++, j--){
                swap(data, i, j);
            }

        }

        public static void main(String... args) {
            DictionaryPermutation p = new DictionaryPermutation();
            p.permutate("aab");
        }


}
