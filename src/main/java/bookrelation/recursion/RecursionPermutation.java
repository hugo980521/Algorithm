package bookrelation.recursion;

/**
 * 为方便起见，用123来示例下。123的全排列有123、132、213、231、312、321这六种。首先考虑213和321这二个数是如何得出的。显然这二个都是123中的1与后面两数交换得到的。然后可以将123的第二个数和每三个数交换得到132。同理可以根据213和321来得231和312。因此可以知道——全排列就是从第一个数字起每个数分别与它后面的数字交换。

 由于全排列就是从第一个数字起每个数分别与它后面的数字交换。我们先尝试加个这样的判断——如果一个数与后面的数字相同那么这二个数就不交换了。如122，第一个数与后面交换得212、221。然后122中第二数就不用与第三个数交换了，但对212，它第二个数与第三个数是不相同的，交换之后得到221。与由122中第一个数与第三个数交换所得的221重复了。所以这个方法不行。


 换种思维，对122，第一个数1与第二个数2交换得到212，然后考虑第一个数1与第三个数2交换，此时由于第三个数等于第二个数，所以第一个数不再与第三个数交换。再考虑212，它的第二个数与第三个数交换可以得到解决221。此时全排列生成完毕。
 这样我们也得到了在全排列中去掉重复的规则——去重的全排列就是从第一个数字起每个数分别与它后面非重复出现的数字交换。
 */
public class RecursionPermutation {
    public static void permutate(String input) {
        if (input == null)
            throw new IllegalArgumentException();
        char[] data = input.toCharArray();
        permutate(data, 0);
    }

    public static void permutate(char[] data, int begin) {
        int length = data.length;
        if (begin == length){
            System.out.println(data);
        }

        for (int i = begin; i < length; i++) {
            if (isUnique(data, begin, i)) {
                swap(data, begin, i);
                permutate(data, begin + 1);
                swap(data, begin, i);
            }
        }
    }

    private static boolean isUnique(char[] data, int begin, int end) {
        for (int i = begin; i < end; i++)
            if (data[i] == data[end]) {
                return false;
            }

        return true;
    }

    private static void swap(char[] data, int left, int right) {
        char temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }


    public static void main(String... args) {
        RecursionPermutation.permutate("aac");
    }

}
