package leetcode;

public class Letcode1145 {
  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    // 查找x的父节点及自身
    TreeNode current=find( root, x);
    if(null == current){
      System.out.println("null");
      return false;
    }
    int left=calcNodeNum(current.left);
    int right=calcNodeNum(current.right);
    int other=n-left-right-1;
    int maxNum= Math.max(other,Math.max(left, right ) ) ;
    int halfNum=(n+1)/2;
    System.out.println("halfNum="+halfNum);
    if(maxNum>=halfNum){
      return true;
    }{
      return false;
    }
  }

  public int calcNodeNum(TreeNode root){
    if(null==root){
      return 0;
    }
    return 1+calcNodeNum(root.left)+calcNodeNum(root.right);
  }

  public TreeNode find(TreeNode root,int x){
    if(null==root){
      return null;
    }
    if(root.val==x){
      return root;
    }
    TreeNode left=find(root.left, x);
    if(null !=left){
      return left;
    }

    TreeNode right=find(root.right, x);
    if(null !=right){
      return right;
    }
    return null;
  }

}

   class TreeNode {
      public  int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode(int x) { val = x; }
  }
