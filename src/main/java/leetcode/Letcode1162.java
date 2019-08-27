package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。

 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。

 如果我们的地图上只有陆地或者海洋，请返回 -1。

  
 */
public class Letcode1162 {
  public int maxDistance(int[][] grid) {
    if(null ==grid){
      return -1;
    }
    int R=grid.length;
    int C=grid[0].length;
    List<GridItem> lstItem=new ArrayList<>();
    // 遍历访问为1的节点（陆地节点）
    Set<Integer> gridSet=new HashSet<>();
    for(int i=0;i<R;i++){
      for(int j=0;j<C;j++){
        gridSet.add(grid[i][j]);
        if(grid[i][j]==1){
          GridItem item=new GridItem(i,j,0);
          lstItem.add(item);
        }
      }
    }
    if(gridSet.size()==1){
      return -1;
    }

    int[] dirX=new int[]{0,0,1,-1};
    int[] dirY=new int[]{1,-1,0,0};
    int res=-1;
    while (!lstItem.isEmpty()){
      GridItem gridItem=lstItem.get(0);
      lstItem.remove(0);
       res=gridItem.level;
      for(int k=0;k<4;k++){
        int p=gridItem.x+dirX[k];
        int q=gridItem.y+dirY[k];
        if(0<=p && p<R && 0<=q & q<C && grid[p][q]==0){
          grid[p][q]=1;
          GridItem item=new GridItem(p,q , res+1);
          lstItem.add(item);
        }
      }
    }

    return res;

  }
}
class GridItem{
  public int x;
  public int y;
  public int level;
  public GridItem(int x,int y,int level){
    this.x=x;
    this.y=y;
    this.level=level;
  }
}
