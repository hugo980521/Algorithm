package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Letcode105 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder.length==0){
      return null;
    }
    int value=preorder[0];
    TreeNode treeNode=new TreeNode(value);
    int location=findIndex(inorder,value);

    List<Integer> leftPre=new ArrayList<>();
    List<Integer> rightPre=new ArrayList<>();
    List<Integer> leftIn=new ArrayList<>();
    List<Integer> rightIn=new ArrayList<>();

    if(location>-1){

      for(int i=1;i<=location;i++) {
        leftPre.add(preorder[i]);
      }

      for(int i=0;i<location;i++){
        leftIn.add(inorder[i]);
      }
      for(int i=location+1;i<inorder.length;i++){
        rightPre.add(preorder[i]);
        rightIn.add(inorder[i]);
      }
    }

    treeNode.left=buildChild(leftPre,leftIn);
    treeNode.right=buildChild(rightPre,rightIn);
     return treeNode;
  }


  private  TreeNode buildChild(List<Integer> preorder, List<Integer> inorder){
    if(preorder.isEmpty()){
      return null;
    }
    TreeNode treeNode=new TreeNode(preorder.get(0));
    int location=findIndex(inorder,preorder.get(0));
    List<Integer> leftPre=new ArrayList<>();
    List<Integer> rightPre=new ArrayList<>();
    List<Integer> leftIn=new ArrayList<>();
    List<Integer> rightIn=new ArrayList<>();

    if(location>-1){
      for(int i=1;i<=location;i++) {
        leftPre.add(preorder.get(i));
      }

      for(int i=0;i<location;i++){
        leftIn.add(inorder.get(i));
      }
      for(int i=location+1;i<inorder.size();i++){
        rightPre.add(preorder.get(i));
        rightIn.add(inorder.get(i));
      }
    }

    treeNode.left=buildChild(leftPre,leftIn);
    treeNode.right=buildChild(rightPre,rightIn);

    return treeNode;
  }

  private int findIndex(int[] inorder,int value){
    for(int i=0;i<inorder.length;i++){
      if(inorder[i]==value){
        return i;
      }
    }
    return -1;
  }

  private int findIndex(List<Integer> inorder,int value){
    for(int i=0;i<inorder.size();i++){
      if(inorder.get(i)==value){
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] preorder=new int[]{1,4,2,3};
    int[] inorder=new int[]{1,2,3,4};

    new Letcode105().buildTree(preorder,inorder );
  }
}
