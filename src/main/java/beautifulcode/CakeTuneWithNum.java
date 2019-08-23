package beautifulcode;

/**
 * 每次翻烙饼的时候，上面的若干个烙饼会被翻转。如果我们希望在排序过程中，翻转烙饼的总个数最少，结果会如何呢？
 */
public class CakeTuneWithNum {
    public static int max;
   public static int m_nMaxReverseCount;
    //记录所需要翻转的最少次数
    public static int estimateMin;
    //记录所需要翻转的最少次数
    public static int minNum;
    //记录所需要翻转的最少次数
    public static int[] cakeArray;

    //饼的数组序列
    public static int[] resultArray;
    //饼的数组序列
    public static int[] tempArray;
    //饼的数组序列
    public static int count = 0;

    // 最少反转烙饼个数
    public static int lowBound(int[] cakeArray) {
        int reduce = 0;
        int min = 0;
        for (int i = 0; i < cakeArray.length - 1; i++) {
            reduce = cakeArray[i] - cakeArray[i + 1];
            if (reduce == 1 || reduce == -1) {
            } else {
                min++;
            }
        }
        return min;
    }

    //翻转函数，将0-index翻转
    public static int reverse(int[] cakeArray, int index) {
        int i = 0;
        int j = index;
        int temp;
        int countLocal=0;
        while (i < j) {
            countLocal++;
            countLocal++;
            temp = cakeArray[i];
            cakeArray[i] = cakeArray[j];
            cakeArray[j] = temp;
            i++;
            j--;
        }
        return countLocal;
    }

    //判断翻转结果是否达到要求
    public static boolean isSorted(int[] cakeArray) {
        for (int i = 1; i < cakeArray.length; i++) {
            if (cakeArray[i - 1] > cakeArray[i]) {
                return false;
            }
        }
        return true;
    }

    //翻转主函数，递归求翻转过程，实际上是一棵搜索树
    public static void search(int[] cakeArray, int depth,int tatalReverseCount) {
//        estimateMin = lowBound(cakeArray);
//减支函数
        if (tatalReverseCount  > m_nMaxReverseCount) {
            return;
        }
        if (isSorted(cakeArray)) {
            if (m_nMaxReverseCount > tatalReverseCount) {
                m_nMaxReverseCount=tatalReverseCount;
                resultArray = tempArray;
                System.out.println("m_nMaxReverseCount="+m_nMaxReverseCount);
                for (int i = 1; i <= depth; i++) {
                    System.out.print(resultArray[i] + 1 + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 1; i < cakeArray.length; i++) {
            if (depth != 0 && tempArray[depth] == i) {
                continue;
            }
            int countLocal= reverse(cakeArray, i);
            tempArray[depth + 1] = i;
            search(cakeArray, depth + 1,tatalReverseCount+countLocal);
            reverse(cakeArray, i);
        }
    }

    public static void main(String[] args) {
        cakeArray = new int[]{4, 2, 1, 1};

        int n=cakeArray.length * cakeArray.length;
        resultArray = new int[n];
        tempArray = new int[n];
        for (int i = 0; i < n; i++) {
            tempArray[i] = 0;
            resultArray[i] = 0;
        }
        max = 2 * cakeArray.length;
        m_nMaxReverseCount=n;

        search(cakeArray, 0,0);
        System.out.println("\n最终最少翻转次数final_min = " + max);
        System.out.println("\nTotal Run Times: " + count);
    }

}
