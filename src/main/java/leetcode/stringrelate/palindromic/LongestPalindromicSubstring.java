package leetcode.stringrelate.palindromic;

/**
 * [LeetCode] Longest Palindromic Substring 最长回文串
 * <p>
 * <p>
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 * <p>
 * <p>
 * <p>
 * 这道题让我们求最长回文子串，首先说下什么是回文串，
 * 就是正读反读都一样的字符串，比如 "bob", "level",
 * "noon" 等等。那么最长回文子串就是在一个字符串中的那个最长的回文子串。
 * LeetCode中关于回文串的题共有五道，除了这道，其他的四道为 Palindrome Number 验证回文数字，
 * Validate Palindrome 验证回文字符串， Palindrome Partitioning 拆分回文串，Palindrome Partitioning II 拆分回文串之二，我们知道传统的验证回文串的方法就是两个两个的对称验证是否相等，那么对于找回文字串的问题，就要以每一个字符为中心，像两边扩散来寻找回文串，这个算法的时间复杂度是O(n*n)，可以通过OJ，就是要注意奇偶情况，由于回文串的长度可奇可偶，比如"bob"是奇数形式的回文，"noon"就是偶数形式的回文，两种形式的回文都要搜索，参见代码如下：
 */
public class LongestPalindromicSubstring {

    /**
     * 递归方式
     *
     * @param A
     * @param start
     * @param end
     * @return
     */
    public int getLongestPalindromeRecursive(String A, int start, int end) {
        if (start == end) {
            return 1;    //只有一个元素，回文长度为1
        }

        if (start > end) {
            return 0;   //因为只计算序列str[i....j]
        }


        //如果首尾相同,并且去掉首尾的字符串也是回文
        if ((A.charAt(start) == A.charAt(end)) && (getLongestPalindromeRecursive(A, start + 1, end - 1) == (end - start - 1))) {
            // 首尾相同，返回首尾都去掉后后的回文+2
            int length = 2 + getLongestPalindromeRecursive(A, start + 1, end - 1);
            return length;
        } else {
            //如果首尾不同，返回 首尾字符各去掉一个的回文最大值
            return Math.max(getLongestPalindromeRecursive(A, start, end - 1), getLongestPalindromeRecursive(A, start + 1, end));
        }

    }

    /**
     * 两侧比较法
     * <p>
     * 以abba这样一个字符串为例来看，abba中，一共有偶数个字，第1位=倒数第1位，第2位=倒数第2位......第N位=倒数第N位
     * 以aba这样一个字符串为例来看，aba中，一共有奇数个字符，排除掉正中间的那个字符后，第1位=倒数第1位......第N位=倒数第N位
     * 所以，假设找到一个长度为len1的子串后，我们接下去测试它是否满足，第1位=倒数第1位，第2位=倒数第2位......第N位=倒数第N位，
     * 也就是说，去测试从头尾到中点，字符是否逐一对应相等
     *
     * @param s
     * @return
     */
    public String longestPalindromeTwoSide(String s) {

        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();

        // check all possible sub strings
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int len = j - i;
                if (i == j) {
                    len = 1;
                }
                String curr = s.substring(i, j + 1);
                if (isPalindrome(curr)) {
                    if (len > maxPalinLength) {
                        longestPalindrome = curr;
                        maxPalinLength = len;
                    }
                }
            }
        }

        return longestPalindrome;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }


    /*
     * 参数A：给定字符串
     * 函数功能：返回字符串A中最长回文串的长度
     * 首先枚举出回文串的中心位置，然后，再在该位置上分别向左和向右扩展，记录并更新得到的最长回文串的长度。
     */
    public int getLongestPalindrome(String A) {
        char[] arrayA = A.toCharArray();
        int max = 0;
        int tempMax = 0;
        if (A.equals("") || A.equals(null)) {
            return 0;
        }

        for (int i = 0; i < arrayA.length; i++) {  //i为回文串的中心位置
            //当回文串位数为奇数时
            for (int j = 0; (i - j) >= 0 && (i + j) < arrayA.length; j++) {
                if (arrayA[i - j] != arrayA[i + j]) {
                    break;
                }

                tempMax = 2 * j + 1;
            }
            if (tempMax > max) {
                max = tempMax;
            }

            //当回文串位数为偶数时
            for (int j = 0; (i - j) >= 0 && (i + j + 1) < arrayA.length; j++) {
                if (arrayA[i - j] != arrayA[i + j + 1]) {
                    break;
                }
                tempMax = 2 * j + 2;
            }
            if (tempMax > max) {
                max = tempMax;
            }

        }
        return max;
    }

    /**
     * 假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出：
     * dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。
     * 这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，因此需要求出基准情况才能套用以上的公式：
     * a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true;
     * b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。
     * 有了以上分析就可以写出代码了。需要注意的是动态规划需要额外的O(n2)的空间。
     *
     * @param s
     * @return
     */
    public String getLongestPalindromeDp(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        String res = "";
        int max = 0;
        //创建一个行列均为字符串长度的二维数组，创建时默认初始化为false
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {//这里只考虑了i<=j的情况，因为i>j时均为false
//当i==j,j-i==1,j-i==2时，只要满足s.charAt(i) == s.charAt(j)就是回文字符串
//如果不是这样，还要判断当前回文字符串的子串是不是回文字符串，即dp[i + 1][j - 1])，这就是动
//态规划思想
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]));
                if (dp[i][j]) {//如果是回文字符串
                    if (j - i + 1 > max) {//并且比之前的回文字符串要长，更新字符串长度，记录字符串
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;

    }

    /**
     * Manacher 算法
     *
     * @param A
     */
    public int manacher(String A) {
        StringBuffer s = new StringBuffer("$#");
        for (int i = 0; i < A.length(); i++) {
            s.append(A.charAt(i));
            s.append("#");
        }
        A = s.toString();
        int[] P = new int[A.length()];
        int mx = 0, id = 0;
        for (int i = 1; i < A.length(); i++) {
            if (mx > i) {
                P[i] = Math.min(P[2 * id - i], mx - i);
            } else {
                P[i] = 1;
            }

            while (i + P[i] < A.length() && (i - P[i] >= 0) && A.charAt(i + P[i]) == A.charAt(i - P[i])) {
                P[i]++;
            }
            if (P[i] + i > mx) {
                mx = i + P[i];
                id = i;
            }
        }
        int result = -1;
        int i = 0, t = 0;
        for (; i < P.length; i++) {
            if (P[i] > result) {
                result = P[i];
                t = i;
            }
        }
        for (int j = t - result + 1; j <= t + result - 1; j++) {
            if (A.charAt(j) != '#') {
                System.out.print(A.charAt(j));
            }

        }
        int rtnValue = result - 1;
        System.out.println("\n最长字符串长度：" + rtnValue);
        return rtnValue;
    }

    public static void main(String[] args) {
        String str = "abcdea";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        int temp = longestPalindromicSubstring.getLongestPalindromeRecursive(str, 0, 5);
        System.out.println("getLongestPalindromeRecursive=" + temp);

        temp = longestPalindromicSubstring.getLongestPalindrome(str);
        System.out.println("getLongestPalindrome=" + temp);

        temp = longestPalindromicSubstring.longestPalindromeTwoSide(str).length();
        System.out.println("longestPalindromeTwoSide=" + temp);

        temp = longestPalindromicSubstring.getLongestPalindromeDp(str).length();
        System.out.println("getLongestPalindromeDp=" + temp);

        str = "bobd";
        temp = longestPalindromicSubstring.manacher(str);
        System.out.println("manacher=" + temp);


    }

}
