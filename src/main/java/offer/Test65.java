package offer;

import java.util.*;

/**
 *
 * Date: 2015-06-17
 * Time: 09:44
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 我们可以用STL中的deque来实现，接下来我们以数组{2,3,4,2,6,2,5,1}为例，来细说整体思路。
 *
 * 数组的第一个数字是2，把它存入队列中。第二个数字是3，比2大，所以2不可能是滑动窗口中的最大值，因此把2从队列里删除，再把3存入队列中。第三个数字是4，比3大，同样的删3存4。此时滑动窗口中已经有3个数字，而它的最大值4位于队列的头部。
 *
 * 第四个数字2比4小，但是当4滑出之后它还是有可能成为最大值的，所以我们把2存入队列的尾部。下一个数字是6，比4和2都大，删4和2，存6。就这样依次进行，最大值永远位于队列的头部。
 *
 * 但是我们怎样判断滑动窗口是否包括一个数字？应该在队列里存入数字在数组里的下标，而不是数值。当一个数字的下标与当前处理的数字的下标之差大于或者相等于滑动窗口大小时，这个数字已经从窗口中滑出，可以从队列中删除。
 */
public class Test65 {
    private static List<Integer> maxInWindows(List<Integer> data, int size) {
        List<Integer> windowMax = new LinkedList<>();

        // 条件检查
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }

        Deque<Integer> idx = new LinkedList<>();

        // 窗口还没有被填满时，找最大值的索引
        for (int i = 0; i < size && i < data.size(); i++) {
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }

            //  添加索引
            idx.addLast(i);
        }

        // 窗口已经被填满了
        for (int i = size; i < data.size(); i++) {
            // 第一个窗口的最大值保存
            windowMax.add(data.get(idx.getFirst()));

            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }

            // 删除已经滑出窗口的数据对应的下标
            if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
                idx.removeFirst();
            }

            // 可能的最大的下标索引入队
            idx.addLast(i);
        }

        // 最后一个窗口最大值入队
        windowMax.add(data.get(idx.getFirst()));

        return windowMax;

    }

    private static List<Integer> arrayToCollection(int[] array) {
        List<Integer> result = new LinkedList<>();
        if (array != null) {
            for (int i : array) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // expected {7};
        List<Integer> data1 = arrayToCollection(new int[]{1, 3, -1, -3, 5, 3, 6, 7});
        System.out.println(data1 + "," + maxInWindows(data1, 10));

        // expected {3, 3, 5, 5, 6, 7};
        List<Integer> data2 = arrayToCollection(new int[]{1, 3, -1, -3, 5, 3, 6, 7});
        System.out.println(data2 + "," + maxInWindows(data2, 3));

        // expected {7, 9, 11, 13, 15};
        List<Integer> data3 = arrayToCollection(new int[]{1, 3, 5, 7, 9, 11, 13, 15});
        System.out.println(data3 + "," + maxInWindows(data3, 4));

        // expected  {16, 14, 12};
        List<Integer> data5 = arrayToCollection(new int[]{16, 14, 12, 10, 8, 6, 4});
        System.out.println(data5 + "," + maxInWindows(data5, 5));

        // expected  {10, 14, 12, 11};
        List<Integer> data6 = arrayToCollection(new int[]{10, 14, 12, 11});
        System.out.println(data6 + "," + maxInWindows(data6, 1));

        // expected  {14};
        List<Integer> data7 = arrayToCollection(new int[]{10, 14, 12, 11});
        System.out.println(data7 + "," + maxInWindows(data7, 4));
    }
}
