package leetcode.stringrelate;

import util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Horspool {

    /**
     * 生成位置map
     * @param pattern
     * @return
     */
    public static Map<Character, Integer> getPosMap(String pattern){
        char[] cArr=pattern.toCharArray();
        Map<Character, Integer> posMap=new HashMap<Character, Integer>();
        for(int i=cArr.length-1;i>=0;i--){
            char temp=cArr[i];
            if(!posMap.containsKey(temp)){
                posMap.put(temp,i);
            }
        }

        return posMap;

    }

    /**
     * 取得移动的位置
     * @param posMap
     * @param cur
     * @param bad
     * @return
     */
    public static int getMove(Map<Character, Integer> posMap,int cur,char bad){
        int index=-1;
        if(posMap.containsKey(bad)){
            index=posMap.get(bad);
        }

        return  cur-index;
    }

    public static void horspool(String source, String pattern) {
        if(StringUtils.isBlank(source) || StringUtils.isBlank(pattern)){
            return;
        }

        Map<Character, Integer> posMap=getPosMap(pattern);
        char[] ts=source.toCharArray();
        char[] ps=pattern.toCharArray();

        int m=pattern.length();
        int i=m-1;
        int j=i;
        int count=0;
        while(i<source.length()){
            count++;
           if(ts[i]==ps[j]){
               // 匹配成功，打印位置
               if(j==0){
                   System.out.println("匹配成功，位置："+i);
                   j=m-1;
                   i+=(2*m-1);
               }else{
                   // 比较前一个字符
                   i--;
                   j--;
               }
           }else{
               int index=getMove(posMap,j,ts[i]);
               i+=index;
           }

        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        String source="abcdefabctabc";
        String pattern="abc";
//        horspool(source,pattern);

         source="ooos";
         pattern="oos";
//        horspool(source,pattern);

        source="osoo";
        pattern="soo";
        horspool(source,pattern);

    }

}
