package leetcode.stringrelate;

import util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Sunday算法
 */
public class Sunday {
    /**
     * 生成位置map
     * @param pattern
     * @return
     */
    public static Map<Character, Integer> getPosMap(String pattern){
        char[] cArr=pattern.toCharArray();
        Map<Character, Integer> posMap=new HashMap<Character, Integer>();
        for(int i=0;i<cArr.length;i++){
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
     * @param length
     * @param bad
     * @return
     */
    public static int getMove(Map<Character, Integer> posMap,int length,int cur,char bad){

        int rtnValue=0;
        if(posMap.containsKey(bad)){
            int index=posMap.get(bad);
            rtnValue=length-index;
        }else{
            int index=-1;
            rtnValue=length-index-cur;
        }

        return  rtnValue;
    }

    public static void sunday(String source, String pattern) {
        if(StringUtils.isBlank(source) || StringUtils.isBlank(pattern)){
            return;
        }

        Map<Character, Integer> posMap=getPosMap(pattern);
        char[] ts=source.toCharArray();
        char[] ps=pattern.toCharArray();

        int m=pattern.length();
        int i=0;
        int j=i;
        int count=0;
        while(i<source.length()){
            count++;
            if(ts[i]==ps[j]){
                // 匹配成功，打印位置
                if(j==(m-1)){
                    System.out.println("匹配成功，位置："+(i-j));
                    j=0;
                    i++;
                }else{
                    // 比较下一个字符
                    i++;
                    j++;
                }
            }else{
                int temp=i+m-j;
                if(temp<source.length()){
                    int index=getMove(posMap,m,j,ts[i+m-j]);
                    i+=(index-j);
                    j=0;
                }else{
                    break;
                }

            }

        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        String source="substring searchingsearch";
        String pattern="search";
        sunday(source,pattern);
         source="ooos";
         pattern="oos";
//        sunday(source,pattern);

    }


}
