package leetcode.stringrelate;

import util.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class ReplaceStd {
    /**
     * 字符串替换函数
     * @param source
     * @param replace
     * @return
     */
    public  static String replace(String source,String replace){
        if(StringUtils.isBlank(source) || StringUtils.isBlank(replace)){
            return  source;
        }
        Set<Character> replaceSet=new HashSet<Character>();
        for(int i=0;i<replace.length();i++){
            replaceSet.add(replace.charAt(i));
        }
        StringBuffer sb= new StringBuffer();
        for(int i=0;i<source.length();i++){
            char temp=source.charAt(i);
            if(!replaceSet.contains(temp)){
                sb.append(temp);
            }
        }


        return  sb.toString();
    }

    public static void main(String[] args) {
        String source="They are students.";
        String replace="aeiou";
       System.out.println( replace(source,replace));
    }
}
