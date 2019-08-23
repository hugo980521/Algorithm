package leetcode.stringrelate;

import java.util.HashSet;

/**
 * [LeetCode] Longest Substring Without Repeating Characters 最长无重复字符的子串

 Given a string, find the length of the longest substring without repeating characters.
 Examples:
 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequenceand not a substring.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> t = new HashSet<Character>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right++));
                res = Math.max(res, t.size());
            } else {
                t.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring  lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String orgStr="abcabcbb";
        int length=lengthOfLongestSubstring.lengthOfLongestSubstring(orgStr);
        System.out.println(length);

        orgStr="bbbbb";
         length=lengthOfLongestSubstring.lengthOfLongestSubstring(orgStr);
        System.out.println(length);
    }
}
