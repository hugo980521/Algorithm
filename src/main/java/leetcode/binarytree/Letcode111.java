package leetcode.binarytree;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Letcode111 {
  public int minDepth(TreeNode root) {
    if (null == root) {
      return 0;
    }
    int left=minDepth(root.left);
    int right=minDepth(root.right);
    if(root.left == null || root.right==null){
      return 1+left+right;
    }
    return 1+Math.min(left,right );
  }


}
