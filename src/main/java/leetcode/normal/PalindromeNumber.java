package leetcode.normal;

/**
 * [LeetCode] Palindrome Number 验证回文数字


 Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 Follow up:

 Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    /**
     * 这道验证回文数字的题如果将数字转为字符串，就变成了验证回文字符串的题，
     * 没啥难度了，我们就直接来做follow up吧，不能转为字符串，
     * 而是直接对整数进行操作，我们可以利用取整和取余来获得我们想要的数字，
     * 比如 1221 这个数字，如果 计算 1221 / 1000， 则可得首位1，
     * 如果 1221 % 10， 则可得到末尾1，进行比较，然后把中间的22取出继续比较。代码如下：
     * @param x
     * @return
     */
    public  boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10){
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
