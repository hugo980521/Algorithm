package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:
 给定如下二叉树，以及目标和 sum = 22，

 */
public class Letcode113 {
  public List<List<Integer>> pathSumRecursion(TreeNode root, int sum) {
       List<Integer> temp=new ArrayList<>();
       List<List<Integer>> result=new ArrayList<>();
       travel(root, sum, 0, temp, result);
       return result;
  }

  private void travel(TreeNode root, int sum, int pre,List<Integer> path, List<List<Integer>>result){
    if(null==root){
      return;
    }
    if(root.right==null && root.left==null){
       if(pre+root.val==sum){
         List<Integer> temp=new ArrayList<>();
         temp.addAll(path);
         temp.add(root.val);
         result.add(temp);
       }
    }
    path.add(root.val);
    if(null !=root.left){
      travel(root.left,sum,pre+root.val,path,result);
    }

    if(null !=root.right){
      travel(root.left,sum,pre+root.left.val,path,result);
    }
  }
  public List<List<Integer>> pathSumNormal(TreeNode root, int sum) {
    List<List<Integer>> result=new ArrayList<>();
    if(null == root){
      return result;
    }
    List<Node> nodesLst=new ArrayList<>();
    Node node=new Node(root,0,new ArrayList<Integer>());
    nodesLst.add(node);

    while (!nodesLst.isEmpty()){
      List<Node> tempLst=new ArrayList<>();
      while(!nodesLst.isEmpty()){
        Node treeNode=nodesLst.get(0);
        nodesLst.remove(0);
        if(treeNode.current.left==null && treeNode.current.right==null){
           if(treeNode.parentValueSum+treeNode.current.val == sum){
             List<Integer> lstTemp=new ArrayList<>();
             lstTemp.addAll(treeNode.paraentNodes);
             lstTemp.add(treeNode.current.val);
             result.add(lstTemp);
           }
        }
        List<Integer> lstTemp=new ArrayList<>();
        lstTemp.addAll(treeNode.paraentNodes);
        lstTemp.add(treeNode.current.val);
        if(treeNode.current.left!=null){
          Node nodeTemp=new Node(treeNode.current.left, treeNode.current.val+treeNode.parentValueSum,lstTemp);
          tempLst.add(nodeTemp);
        }
        if(treeNode.current.right!=null){
          Node nodeTemp=new Node(treeNode.current.right, treeNode.current.val+treeNode.parentValueSum,lstTemp);
          tempLst.add(nodeTemp);
        }
      }
      nodesLst=tempLst;
    }

    return result;
  }



}
class Node{
  public Node(TreeNode  current,int parentValueSum,List<Integer> paraentNodes){
    this.current=current;
    this.parentValueSum=parentValueSum;
    this.paraentNodes=paraentNodes;
  }
  public int parentValueSum=0;
  public  TreeNode current;
  public  List<Integer> paraentNodes=new ArrayList<>();
}
