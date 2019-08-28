package leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Letcode1168 {
  public int minCostToSupplyWater(int N, int[] wells, int[][] connections) {

    int connLength=connections.length;
    // 按权重排序边（升序）
    List<Item> lstLocal=new ArrayList<>();
    for(int i=0;i<connLength;i++){
      Item item=new Item(connections[i][0],connections[i][1],connections[i][2]);
      lstLocal.add(item);
    }
    for(int i=0;i<wells.length;i++){
      Item item=new Item(i+1,0,wells[i]);
      lstLocal.add(item);
    }
    Collections.sort(lstLocal);

    // 初始化并查集
    int[] dp=new int[N+1];
    for(int i=0;i<dp.length;i++){
      dp[i]=i;
    }
    // 按权重大小依次访问
    int res=0;
    int count=0;
    for(Item item:lstLocal){
      int x=find(dp, item.from);
      int y=find(dp, item.to);
      if(x!=y){
        count++;
        dp[x]=y;
        res=res+item.weight;
      }
      // 找完第N-条边
      if(count==N){
        return res;
      }
    }
    if(count<N){
      return -1;
    }

    return res;
  }

  private int find(int[] dp,int x){
    while (x!=dp[x]){
      x=dp[x];
    }
    return dp[x];
  }


  public static void main(String[] args) {
    int[][] connections=new int[][]{{1,2,1},{2,3,1}};
    int[] wells=new int[]{1,2,2};

    System.out.println(new Letcode1168().minCostToSupplyWater(3, wells,connections));

  }
}
