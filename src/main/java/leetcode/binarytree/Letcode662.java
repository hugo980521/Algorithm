package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

 示例 1:

 输入:

 1
 /   \
 3     2
 / \     \
 5   3     9

 输出: 4
 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 示例 2:

 输入:

 1
 /
 3
 / \
 5   3

 输出: 2
 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 示例 3:

 输入:

 1
 / \
 3   2
 /
 5

 输出: 2
 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 示例 4:

 输入:

 1
 / \
 3   2
 /     \
 5       9
 /         \
 6           7
 输出: 8
 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。

 */
public class Letcode662 {
  public int widthOfBinaryTree(TreeNode root) {
    List<QueueTreeNode> lstNodes=new ArrayList<>();
    lstNodes.add(new QueueTreeNode (root,1));

    int max=0;
    while(!lstNodes.isEmpty()){

      QueueTreeNode left=null;
      QueueTreeNode right=null;
      boolean firstFlag=true;
      List<QueueTreeNode> lstTemp=new ArrayList<>();
      while(!lstNodes.isEmpty()){
        QueueTreeNode node=lstNodes.get(0);
        lstNodes.remove(0);
        if(firstFlag){
          firstFlag=false;
          left=node;
        }
        right=node;
        if(node.treeNode.left !=null){
         lstTemp.add(new QueueTreeNode(node.treeNode.left, node.index*2));
        }
        if(node.treeNode.right !=null){
          lstTemp.add(new QueueTreeNode(node.treeNode.right, node.index*2+1));
        }
      }
      lstNodes=lstTemp;
      max=Math.max(max,right.index-left.index+1 );

    }

    return max;
  }

  class QueueTreeNode  {
    public TreeNode treeNode;
    public int index;
    public QueueTreeNode(TreeNode treeNode,int index){
      this.index=index;
      this.treeNode=treeNode;
    }
  }
}
