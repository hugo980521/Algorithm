package leetcode.unionset;

import util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class Letcode685 {
  public int[] findRedundantDirectedConnection(int[][] edges) {
    int canA = -1;
    int canB = -1;
    Map<Integer, Integer> inMap = new HashMap<>();
    int vectorNum = 0; // 顶点数
    for (int i = 0; i < edges.length; i++) {
      vectorNum = Math.max(vectorNum, Math.max(edges[i][0], edges[i][1]));
    }

    // 查找入度为 2 的顶点
    for (int i = 0; i < edges.length; i++) {
      int key = edges[i][1];
      if (inMap.containsKey(key)) {
        canA=inMap.get(key);
        canB=i;
      } else {
        inMap.put(key, i);
      }
    }
    // 初始化并查集
    UnionSetStandard d = new UnionSetStandard(vectorNum + 1);
    // 不存在入度为2的节点，直接查找环的最后出现节点
    for (int i = 0; i < edges.length; i++) {
      if ( canB==i) {
        continue;
      }

      int xParent = d.find(edges[i][0]);
      int yParent = d.find(edges[i][1]);
      if (xParent == yParent) {
        if (-1 == canB) {
          return edges[i];
        } else {
          return edges[canA];
        }
      } else {
        d.union(edges[i][0], edges[i][1]);
      }
    }

    return edges[canB];

  }

  public static void main(String[] args) {
    int[][] edges = new int[][]{
        {2, 1},
        {3, 1},
        {4, 2},
        {1, 4}
    };
    edges=new int[][]{{1,2},{1,3},{2,3}};
    int [] result=new Letcode685().findRedundantDirectedConnection(edges);
    System.out.println(ObjectUtils.getObjectStr(result));
  }

}
