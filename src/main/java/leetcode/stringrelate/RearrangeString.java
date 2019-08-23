
package leetcode.stringrelate;

import util.ObjectUtils;

import java.util.*;

/**
 Given a non-empty String str and an integer k, rearrange the String such that the same characters are at least distance k from each other.

 All input Strings are given in lowercase letters. If it is not possible to rearrange the String, return an empty String "".

 Example 1:
 str = "aabbcc", k = 3

 Result: "abcabc"

 The same letters are at least distance 3 from each other.
 Example 2:
 str = "aaabc", k = 3

 Answer: ""

 */
public class RearrangeString {
    public static void main(String[] args) {
        String str="aabbccdefg";
        String result=rearrangeString(str,3);
        System.out.println(result);

         str="aaadbbcc";
         result=rearrangeString(str,2);
        System.out.println(result);

    }

   public static String rearrangeString(String str, int k) {
        if (k == 0) {
            return str;
        }

        int len = str.length();
        Map<Character, CharCount> m = new HashMap<Character, CharCount>();
        char[] strArr = str.toCharArray();
        for (int i=0;i<strArr.length;i++) {
            char a=strArr[i];
            CharCount charCount=m.get(a);
            if(ObjectUtils.isEmptyObject(charCount)){
                charCount=new CharCount(1,a,i);
            }else{
                charCount.count++;

            }
            m.put(a,charCount);
        }

        Queue<CharCount> q = new PriorityQueue<CharCount>();

        for (char key:m.keySet()) {
            q.add(m.get(key));
        }
        StringBuffer res=new StringBuffer();
        while (!q.isEmpty()) {
            List<CharCount> lstCharCount= new ArrayList<CharCount>();
            int cnt = Math.min(k, len);
            for (int i = 0; i < cnt; ++i) {
                if (q.isEmpty()) {
                    return "";
                }
                CharCount t = q.poll();

                res.append(t.character);
                t.count--;
                if(t.count>0){
                    lstCharCount.add(t);
                }

                --len;
            }
            Queue<CharCount> qLocal = new PriorityQueue<CharCount>();
            for (CharCount a : lstCharCount){
                qLocal.add(a);
            }
            while (!q.isEmpty()){
                CharCount charCountLocal=q.poll();
                qLocal.add(charCountLocal);
            }
            q=qLocal;
        }
        return res.toString();
    }

}


class CharCount implements Comparable<CharCount>{
    public CharCount(Integer count, Character character, Integer firstIndex){
        this.count=count;
        this.character=character;
        this.firstIndex=firstIndex;
    }
    public Integer count;
    public  Character character;
    public  Integer firstIndex;
    public int compareTo(CharCount o){
        Integer differ=o.count-count;
        if(differ==0){
            differ=-1*(o.firstIndex-firstIndex);
        }
       return differ;
    }

}
