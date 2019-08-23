package bookrelation.dynamicprogram;

import util.StringUtils;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    /**
     * 动态规划
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null || s.length()==0){
            return true;
        }

        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0;i<s.length();i++)
        {
            StringBuilder str = new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++)
            {
                if(res[j] && dict.contains(str.toString()))
                {
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }

    /**
     * BFS
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, List<String> dict) {
        if (dict.contains(s)){
            return true;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        //使用set去检查去除重复计算
        //这是是时间复杂度降到O(N^2)的关键
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        while (!queue.isEmpty()) {
            int curIdx = queue.poll();
            for (int i = curIdx + 1; i <= s.length(); i++) {
                if (visited.contains(i)){
                    continue;
                }

                if (dict.contains(s.substring(curIdx, i))) {
                    //如果到达中重点，
                    //注意此时的i是curIdx + 1
                    if (i == s.length()){
                        return true;
                    }

                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }

    /**
     * 递归查找
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreakRecursive(String s, Set<String> dict) {
        if(StringUtils.isBlank(s)){
            return true;
        }
        if (dict.contains(s)){
            return true;
        }
        for(int i=0;i<s.length();i++){
            if(dict.contains(s.substring(0,i+1))){
                if(wordBreakRecursive(s.substring(i+1),dict)){
                   return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Set<String> dict=new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        String s="codeleet";
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreakRecursive(s,dict));
    }
}
