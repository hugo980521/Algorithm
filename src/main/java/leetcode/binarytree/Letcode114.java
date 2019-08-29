package leetcode.binarytree;

/**
 给定一个二叉树，原地将它展开为链表。

 例如，给定二叉树

 1
 / \
 2   5
 / \   \
 3   4   6
 */
public class Letcode114 {
  public void flatten(TreeNode root) {
    if(null ==root){
      return;
    }
    flatten(root.left);
    flatten(root.right);
    TreeNode tempLeft=root.left;
    TreeNode tempRight=root.right;

    root.left=null;
    if(null != tempLeft){
      root.right=tempLeft;
      while(tempLeft.right!=null){
        tempLeft=tempLeft.right;
      }
      tempLeft.right=tempRight;
    }
  }
}
