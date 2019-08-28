package leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Letcode207 {
  public boolean canFinish(int N, int[][] relations) {
    if(N<1 || null ==relations || relations.length<1){
      return true;
    }
    int R=relations.length;
    List<Set<Integer>> lstValue =new ArrayList<>();
    // 设置每个顶点的入度
    for(int i=0;i<N;i++){
      lstValue.add(new HashSet<>());
    }
    for(int i=0;i<R;i++){
      int key=relations[i][0];
      int value=relations[i][1];
      Set<Integer> valueSet=lstValue.get(key);
      valueSet.add(value);
    }

    // 初始化第一个顶点
    Queue<Integer> lstQueue=new LinkedList<>();
    for(int i=0;i<N;i++){
      if(lstValue.get(i).size() ==0){
        lstValue.set(i,null );
        lstQueue.add(i);
      }
    }


    int courseNum=0;
    int level=0;
    while(!lstQueue.isEmpty()){
      level++;
      // 访问课程
      while(!lstQueue.isEmpty()){
        courseNum++;
        Integer vector=lstQueue.poll();
        for(int i=0;i<lstValue.size();i++){
          Set<Integer> valueSet=lstValue.get(i);
          if(null !=valueSet){
            lstValue.get(i).remove(vector);
          }
        }
      }

      // 访问新的入度为0的节点
      for(int i=0;i<N;i++){
        if(null !=lstValue.get(i) && lstValue.get(i).size() ==0){
          lstValue.set(i,null );
          lstQueue.add(i);
        }
      }

    }
    if(courseNum==N){
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    int[][] relation=new int[][]{{1,0}};
    System.out.println(new Letcode207().canFinish(2,relation ));
  }
}
