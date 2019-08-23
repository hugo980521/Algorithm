package algorithm.chapter_4_recursionanddp;

public class NQueensNormal {
  private int num;
  public int getNum(){
    return num;
  }
  private final   int MAX_QUEENS;
  private int[][] checkArr;
  public NQueensNormal(int n){
    this.MAX_QUEENS=n;
    this.checkArr=new int[MAX_QUEENS][MAX_QUEENS];
  }
  public boolean isVaid(int x,int y){
    for(int i=0;i<MAX_QUEENS;i++){
        if(checkArr[i][y] ==1){
          return false;
        }
    }

    for(int i=x-1,j=y-1;i>=0 && j>=0;i--,j--){
      if(checkArr[i][j]==1){
        return false;
      }
    }

    for(int i=x-1,j=y+1;i>=0 && j<MAX_QUEENS;i--,j++){
      if(checkArr[i][j]==1){
        return false;
      }
    }
    return true;
  }

  public void findQueen(int n){
     if(n>MAX_QUEENS-1){
       this.num++;
       return;
     }
     for(int i=0;i<MAX_QUEENS;i++){
       if(isVaid(n,i)){
         checkArr[n][i]=1;
         findQueen(n+1);
         checkArr[n][i]=0;
       }
     }
  }

  //===========================利用对称特性=============================

  /**
   * 判定是否可以放置
   * @param record
   * @param i
   * @param j
   * @return
   */
  private boolean checkWithRecord(int[] record, int i ,int j){
    for (int k = 0; k < i; k++) {
      if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
        return false;
      }
    }
    return true;
  }
  private int process(int[] record,int i,int n){
    if(i==n){
      return 1;
    }
    int res=0;
    for(int j=0;j<n;j++){
      if(checkWithRecord(record,i,j)){
        record[i]=j;
        res+=process(record,i+1 , n);
      }
    }
    return res;
  }

  public int findWithRecord(int n){
    int [] record = new int [n];
    int result=process(record,0,  n);
    return result;
  }
  public static void main(String[] args) {
    NQueensNormal queensNormal=new NQueensNormal(8);
    queensNormal.findQueen(0);
    System.out.println(queensNormal.getNum());

    int result=queensNormal.findWithRecord(8);
    System.out.println("result="+result);

  }
}
