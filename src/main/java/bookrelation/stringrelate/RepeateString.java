package bookrelation.stringrelate;

/**
 * 写一个方法, 给一个由 N 个字符构成的字符串 A和一个由 M 个字符构成的字符串 B, 返回 A 必须重复的次数，使得 B 是重复字符串的子串.如果 B 不可能为重复字符串的子串, 则返回 -1.

 注意事项：
 Assume that 0 <= N <= 1000, 1 <= M <= 1000

 样例：
 给出 A = abcd, B = cdabcdab
 你的方法需要返回 3, 因为在重复字符串 A 3次之后我们得到了字串 abcdabcdabcd. 字符串B是这个字符串的一个子串.
 */
public class RepeateString {

    public static int repeatTimesReal(String a, String b) {
        if (b.isEmpty()) {
            return 0;
        }
        if ((a.isEmpty() && !b.isEmpty()) || !a.contains(String.valueOf(b.charAt(0)))) {
            return -1;
        }
        int times = 0;
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int index = a.indexOf(String.valueOf(b.charAt(0)));
        int len = charsA.length;
        for (int i = 0; i < charsB.length; i++) {
            if (index < len) {
                if (charsA[index] == charsB[i]) {
                    index ++;
                } else {
                    return -1;
                }
            } else {
                index = 0;
                i --;
                times ++;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        String shortStr="abcd";
        String longStr="cdabcdabcdab";
       int times= RepeateString.repeatTimesReal(shortStr,longStr);
       System.out.println(times);

    }
}
