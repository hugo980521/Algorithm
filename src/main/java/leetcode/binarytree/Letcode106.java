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
public class Letcode106 {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(postorder.length==0){
      return null;
    }
    int value=postorder[postorder.length-1];
    TreeNode treeNode=new TreeNode(value);
    int location=findIndex(inorder,value);

    List<Integer> leftPost=new ArrayList<>();
    List<Integer> rightPost=new ArrayList<>();
    List<Integer> leftIn=new ArrayList<>();
    List<Integer> rightIn=new ArrayList<>();

    if(location>-1){

      for(int i=0;i<location;i++) {
        leftPost.add(postorder[i]);
        leftIn.add(inorder[i]);
      }


      for(int i=location+1;i<inorder.length;i++){
        rightIn.add(inorder[i]);
      }
      for(int i=location;i<inorder.length-1;i++){
        rightPost.add(postorder[i]);
      }

    }

    treeNode.left=buildChild(leftIn,leftPost);
    treeNode.right=buildChild(rightIn,rightPost);
     return treeNode;
  }


  private  TreeNode buildChild( List<Integer> inorder,List<Integer> postorder){
    if(postorder.isEmpty()){
      return null;
    }
    TreeNode treeNode=new TreeNode(postorder.get(postorder.size()-1));

    List<Integer> leftPost=new ArrayList<>();
    List<Integer> rightPost=new ArrayList<>();
    List<Integer> leftIn=new ArrayList<>();
    List<Integer> rightIn=new ArrayList<>();

    int location=findIndex(inorder,postorder.get(postorder.size()-1));
    if(location>-1){
      for(int i=0;i<location;i++) {
        leftPost.add(postorder.get(i));
        leftIn.add(inorder.get(i));
      }

      for(int i=location+1;i<inorder.size();i++){
        rightIn.add(inorder.get(i));
      }
      for(int i=location;i<inorder.size()-1;i++){
        rightPost.add(postorder.get(i));
      }

    }

    treeNode.left=buildChild(leftIn,leftPost);
    treeNode.right=buildChild(rightIn,rightPost);

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
    int[] postorder=new int[]{1,2,3,4};
    int[] inorder=new int[]{4,3,2,1};

    new Letcode106().buildTree(postorder, inorder );
  }
}
