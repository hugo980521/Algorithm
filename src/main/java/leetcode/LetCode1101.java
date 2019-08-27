package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetCode1101 {
  public int earliestAcq(int[][] logs, int N) {
    int R=logs.length;
    int C=logs[0].length;
    // 按照时间从小到大排列
    List<QueueItemAsc> lstLocal=new ArrayList<>();
    for(int i=0;i<R;i++){
      QueueItemAsc item=new QueueItemAsc(logs[i][1],logs[i][2] ,logs[i][0]);
      lstLocal.add(item);
    }
    Collections.sort(lstLocal);

    // 初始化并查集
    UnionSetStandard d=new UnionSetStandard(N+1);

    int count=0;
    int earliestTime=-1;
    for(QueueItemAsc itemAsc:lstLocal){
       int xParent=d.find(itemAsc.x);
       int yParent=d.find(itemAsc.y);
       if(xParent!=yParent){
         count++;
         earliestTime=itemAsc.score;
         d.union(itemAsc.x, itemAsc.y);
       }
    }
    if(count<N-1){
      return -1;
    }

    return earliestTime;

  }
}

class QueueItemAsc implements Comparable<QueueItemAsc> {
  public int compareTo(QueueItemAsc o) {
    return -(o.score - this.score);
  }

  public QueueItemAsc(int x, int y, int score) {
    this.x = x;
    this.y = y;
    this.score = score;
  }

  public int x;
  public int y;
  public int score;

}


class UnionSetStandard {
  int[] par = null;

  public UnionSetStandard(int n) {
    par = new int[n];
    for (int i = 0; i < n; i++) {
      par[i] = i;
    }


  }

  public int find(int x) {
    while (x != par[x]) {
      x = par[x];
    }
    return par[x];
  }

  public void union(int x, int y) {
    int xParent = find(x);
    int yParent = find(y);
    if (xParent == yParent) {
      return;
    }
    par[yParent] = xParent;
  }
}
