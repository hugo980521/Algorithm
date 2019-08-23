package leetcode.stringrelate.palindromic;

import util.StringUtils;

/**
 * [LeetCode] Longest Palindromic Subsequence 最长回文子序列


 Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:

 4
 One possible longest palindromic subsequence is "bbbb".



 Example 2:
 Input:

 "cbbd"
 Output:

 2
 One possible longest palindromic subsequence is "bb".
 */
public class LongestPalidromicSubsequence {

    /**
     * 这道题给了我们一个字符串，让我们求最大的回文子序列，子序列和子字符串不同，不需要连续。而关于回文串的题之前也做了不少，处理方法上就是老老实实的两两比较吧。像这种有关极值的问题，最应该优先考虑的就是贪婪算法和动态规划，这道题显然使用DP更加合适。我们建立一个二维的DP数组，其中dp[i][j]表示[i,j]区间内的字符串的最长回文子序列，那么对于递推公式我们分析一下，如果s[i]==s[j]，那么i和j就可以增加2个回文串的长度，我们知道中间dp[i + 1][j - 1]的值，那么其加上2就是dp[i][j]的值。如果s[i] != s[j]，那么我们可以去掉i或j其中的一个字符，然后比较两种情况下所剩的字符串谁dp值大，就赋给dp[i][j]，那么递推公式如下：

     /  dp[i + 1][j - 1] + 2                       if (s[i] == s[j])

     dp[i][j] =

     \  max(dp[i + 1][j], dp[i][j - 1])        if (s[i] != s[j])
     * @param str
     * @return
     */
   public static int longestPalindromeSubseqDpNormal(String str) {
        int n = str.length();
        int[][]  dp =new int[n][n];
        String[][] dpStr= new String[n][n];
        char[] s=str.toCharArray();
        for (int i = n - 1; i >= 0; --i) {
            dp[i][i] = 1;
            dpStr[i][i]=String.valueOf(s[i]);
            for (int j = i + 1; j < n; ++j) {

                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    String tempStr=String.valueOf(s[i]);
                    if(StringUtils.isNotBlank(dpStr[i + 1][j - 1])){
                        tempStr+=dpStr[i + 1][j - 1];
                    }
                    tempStr+=String.valueOf(s[j]);
                    dpStr[i][j]=tempStr;
                } else {
                    int tempInt = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    String tempStr=dpStr[i + 1][j];
                    if(tempInt == dp[i][j - 1]){
                        tempStr=dpStr[i][j-1];
                    }
                    dpStr[i][j]=tempStr;
                    dp[i][j]=tempInt;
                }
            }
        }
        System.out.println(dpStr[0][n - 1]);
        return dp[0][n - 1];
    }

    public static int longestPalindromeSubseqDpQuick(String str) {
        int n = str.length();

        int[]  dp =new int[n];
        char[] s=str.toCharArray();
        String[] dpStr= new String[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            dpStr[i]=String.valueOf(s[i]);
        }

        for (int i = n - 1; i >= 0; --i) {
            int len = 0;
            for (int j = i + 1; j < n; ++j) {
                int t=dp[j];
                if (s[i] == s[j]) {
                    dp[j] = len + 2;
                }
                len = Math.max(len, t);
            }
        }
        int res = 0;
        for(int num:dp){
           res=Math.max(res,num);
        }
        return res;
    }


    public static String longestPalindromeSubseqRecursive(String str,int start, int end) {
        if(StringUtils.isBlank(str)){
            return "";
        }
        if (start == end) {
            return str.substring(start,start+1);
        }
         /* 首尾相同时，则首尾是回文子序列的一部分length+2，lps(str, start + 1, end - 1)表示去掉下标为start和end后的字符串进行递归的到的最长子序列；*/
        if (str.charAt(start) == str.charAt(end)) {
            String rtnValue= "";
            if((end-start)==1){
                rtnValue= String.valueOf(str.charAt(start))  +String.valueOf(str.charAt(end));
            }else{
                rtnValue= String.valueOf(str.charAt(start)) +longestPalindromeSubseqRecursive(str, start + 1, end - 1) +String.valueOf(str.charAt(end));
            }

            return  rtnValue;
        } else {
            if((end-start)>1){
                 /* 首尾不相同时，lps(str, start + 1, end)表示去掉下标为start后的字符串的最长子序列，lps(str, start, end - 1)表示去掉下标为end后的字符串的最长子序列*/
                String left=longestPalindromeSubseqRecursive(str, start, end - 1);
                String rtnValue=left;
                String right=longestPalindromeSubseqRecursive(str, start + 1, end);
                if(left.length()<right.length()){
                    rtnValue=right;
                }
                return rtnValue;
            }else{
                return "";
            }

        }
    }
    public static void main(String[] args) {
        String str="abdcba";
        int result=longestPalindromeSubseqDpNormal(str);
        System.out.println("method=longestPalindromeSubseqDpNormal  "+"str="+str+"   max sequence length= "+result);

         str="bbbab";
         result=longestPalindromeSubseqDpQuick(str);
        System.out.println("method=longestPalindromeSubseqDpQuick  "+"str="+str+"   max sequence length= "+result);

        String strRecursive="bbabcdeb";
        String resultRecursive=longestPalindromeSubseqRecursive(strRecursive,0,strRecursive.length()-1);
        System.out.println("method=longestPalindromeSubseqDpQuick  "+"str="+strRecursive+"   max sequence= "+resultRecursive);
    }
}
