package leetcode.stringrelate;

import util.StringUtils;

public class KMP {
    public static  int[] getNext(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        char[] p = str.toCharArray();
        int[] nextArr=new int[p.length];
        nextArr[0]=-1;
        int j=0;
        int k=-1;
        while(j<p.length-1){
            if(k==-1 || p[j]==p[k]){
                k++;
                j++;
                // 当两个字符相等时要跳过
                if(p[j]==p[k]){
                    nextArr[j]=nextArr[k];
                }else{
                    nextArr[j]=k;
                }

            }else{
               k=nextArr[k];
            }
        }

        return nextArr;
    }

    public  static int kmpIndex(String ts, String ps){
        if(StringUtils.isBlank(ts) || StringUtils.isBlank(ps)){
            return -1;
        }
        char[] t=ts.toCharArray();
        char[] p=ps.toCharArray();
        int i=0; // 主串位置
        int j=0; // 辅川位置
        int[] nextArr=getNext(ps);
        while(i<t.length && j<p.length){
            if(j==-1 ||t[i]==p[j]){
                i++;
                j++;
            }else{
                j=nextArr[j];
            }
        }
        int index=-1;
        if(j==p.length){
            index=i-j;
        }

        return  index;
    }

    public static void main(String[] args) {
        String ts="defabp";
        String ps="ab";
        System.out.println(kmpIndex(ts,ps));
    }

}
