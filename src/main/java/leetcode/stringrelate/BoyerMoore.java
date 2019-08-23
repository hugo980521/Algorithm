package leetcode.stringrelate;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
    public static void main(String[] args) {
        String text = "here is a simple example";
        String pattern = "example";
        BoyerMoore bm = new BoyerMoore();
//        bm.boyerMoore(pattern, text);


         text = "ooos";
         pattern = "oos";
//        bm.boyerMoore(pattern, text);

        text = "CDABCABE";
        pattern = "DABCAB";
        bm.boyerMoore(pattern, text);
    }

    public static void boyerMoore(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        Map<String, Integer> bmBc = new HashMap<String, Integer>();
        int[] bmGs = new int[m];
        // proprocessing
        preBmBc(pattern, m, bmBc);
        preBmGs(pattern, m, bmGs);
        // searching
        int j = 0;
        int i = 0;
        int count = 0;
        while (j <= n - m) {
            for (i = m - 1; i >= 0 && pattern.charAt(i) == text.charAt(i + j); i--) { // 用于计数
                count++;
            }
            if (i < 0) {
                System.out.println("one position is:" + j);
                j += bmGs[0];
            } else {
                j += Math.max(bmGs[i], getBmBc(String.valueOf(text.charAt(i + j)), bmBc, m) -(m - 1 - i) );
            }
        }
        System.out.println("count:" + count);
    }

    public static void preBmBc(String pattern, int patLength, Map<String, Integer> bmBc) {
        System.out.println("bmbc start process...");
        for (int i = patLength - 2; i >= 0; i--) {
            if (!bmBc.containsKey(String.valueOf(pattern.charAt(i)))) {
                bmBc.put(String.valueOf(pattern.charAt(i)), (Integer) (patLength - i - 1));
            }
        }
    }

    public static int getBmBc(String c, Map<String, Integer> bmBc, int m) {
        // 如果在规则中则返回相应的值，否则返回pattern的长度
        if (bmBc.containsKey(c)) {
            return bmBc.get(c);
        } else {
            return m;
        }
    }

    public static void preBmGs(String pattern, int patLength, int[] bmGs) {
//        int i, j;
        int[] suffix = new int[patLength];
        suffix(pattern, patLength, suffix);
        // 模式串中没有子串匹配上好后缀，也找不到一个最大前缀
        for (int i = 0; i < patLength; i++) {
            bmGs[i] = patLength;
        }
        // 模式串中没有子串匹配上好后缀，但找到一个最大前缀
        for (int i = patLength - 1; i >= 0; i--) {
            if (suffix[i] == i + 1) {
                for (int j=0; j < patLength - 1 - i; j++) {
                    if (bmGs[j] == patLength) {
                        bmGs[j] = patLength - 1 - i;
                    }
                }
            }
        }
        // 模式串中有子串匹配上好后缀
        for (int i = 0; i < patLength - 1; i++) {
            bmGs[patLength - 1 - suffix[i]] = patLength - 1 - i;
        }
        System.out.print("bmGs:");
        for (int i = 0; i < patLength; i++) {
            System.out.print(bmGs[i] + ",");
        }
        System.out.println();
    }

    public static void suffix(String pattern, int patLength, int[] suffix) {
        suffix[patLength - 1] = patLength;
        int i,j,k;
        int result;
        for(i = patLength-2;i>=0;i--)
        {
            k = i;
            j=patLength-1;
            result = 0;
            while(k>=0 && pattern.charAt(k)==pattern.charAt(j) )
            {
                k--;
                j--;
                result++;
            }
            suffix[i] = result;
        }
    }


}
