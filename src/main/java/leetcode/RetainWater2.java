package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * m 和 n 都是小于110的整数。每一个单位的高度都大于0 且小于 20000。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给出如下 3x6 的高度图:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * <p>
 * 返回 4。
 */
public class RetainWater2 {
  int[] dx = {0, 0, 1, -1};
  int[] dy = {1, -1, 0, 0};

  static class Idx implements Comparable<Idx>, Comparator<Idx> {
    int h;
    int x;
    int y;

    public Idx(int x, int y, int h) {
      this.x = x;
      this.y = y;
      this.h = h;
    }

    @Override
    public int compareTo(Idx idx) {
      return h - idx.h;
    }

    @Override
    public int compare(Idx idx, Idx t1) {
      return idx.h - t1.h; //设置最小优先队列的条件 以h为基准
    }
  }

  public int trapRainWater(int[][] heightMap) {
    if (heightMap.length == 0 || heightMap[0].length == 0) {
      return 0;
    }
    int n = heightMap.length;
    int m = heightMap[0].length;
    boolean[][] vis = new boolean[n][m];
    PriorityQueue<Idx> queue = new PriorityQueue<Idx>(); //smallest priority queue
    for (int i = 0; i < m; ++i) { //四周一定是不能注水的 所以把四周作为初始的访问对象
      vis[0][i] = true;
      queue.add(new Idx(0, i, heightMap[0][i]));
      vis[n - 1][i] = true;
      queue.add(new Idx(n - 1, i, heightMap[n - 1][i]));
    }
    for (int i = 1; i < n - 1; ++i) {
      vis[i][0] = true;
      queue.add(new Idx(i, 0, heightMap[i][0]));
      vis[i][m - 1] = true;
      queue.add(new Idx(i, m - 1, heightMap[i][m - 1]));
    }
    int ans = 0;
    while (!queue.isEmpty()) {
      Idx cur = queue.poll();
      for (int i = 0; i < 4; ++i) {
        int xi = cur.x + dx[i];
        int yi = cur.y + dy[i];
        if (xi >= 0 && yi >= 0 && xi < n && yi < m && !vis[xi][yi]) {
          ans += Math.max(0, cur.h - heightMap[xi][yi]); //取高度差
          queue.add(new Idx(xi, yi, Math.max(cur.h, heightMap[xi][yi]))); //把当前高度设置为比他高的方块的高
          vis[xi][yi] = true;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] water = new int[][]{
        {1, 4, 3, 1, 3, 2},
        {3, 2, 1, 3, 2, 4},
        {2, 3, 3, 2, 3, 1}

    };

    System.out.println(new RetainWater2().trapRainWater(water));
  }
}
