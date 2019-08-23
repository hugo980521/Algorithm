package algrightm.sort.count_sort.java;

import java.util.Collections;

public class CountSort {
    public static int[]  countSort(int[] a){
        // 取得最大值
        int maxValue=a[0];
        for(int i=1;i<a.length;i++){
            maxValue=Math.max(maxValue,a[i]);
        }

        // 定义中间数组
        int[] b=new int[maxValue+1];
        for(int i=0;i<a.length;i++){
           b[a[i]]++;
        }

        for(int i=1;i<maxValue+1;i++){
          b[i]=b[i]+b[i-1];
        }
        int[] c=new int[a.length];
        for(int i=0;i<a.length;i++){
            b[a[i]]--;
            c[b[a[i]]]=a[i];
        }

        return c;

    }

    public static void main(String[] args) {
        int a[]= {5,5,5,6,8,7,15};
       int[] result= countSort(a);
       for(int i=0;i<result.length;i++){
           System.out.println(result[i]+" ");
       }


    }
}
