package leetcode.binarytree;

import util.ObjectUtils;

import java.util.Stack;

/**
 *

 Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

 1
 \
 3
 /
 2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


 Note: There are at least two nodes in this BST.
 */
public class MinimumDifference {
    public static  BinaryTreeNode constructTree(){
        BinaryTreeNode root=new BinaryTreeNode();
        root.intValue=1;

        BinaryTreeNode right=new BinaryTreeNode();
        right.intValue=3;
        root.right=right;

        BinaryTreeNode left=new BinaryTreeNode();
        left.intValue=2;
        right.left=left;

        return root;
    }

    /**
     * 迭代的写法
     * @param root
     * @return
     */
    public static int getMinimumDifference(BinaryTreeNode root) {
        int res = Integer.MAX_VALUE, pre = -1;
        Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
        BinaryTreeNode p = root;
        while (ObjectUtils.isNotEmptyObject(p) || !st.empty()) {
            while (ObjectUtils.isNotEmptyObject(p)) {
                st.push(p);
                p = p.left;
            }
            p = st.pop();
            if (pre != -1){
                res = Math.min(res, p.intValue - pre);
            }
            pre = p.intValue;
            p = p.right;
        }
        return res;
    }

    /**
     * 递归 中序遍历
     * @param root
     * @param preRes
     */
    public static  void inorder(BinaryTreeNode root, PreRes preRes) {
        if (ObjectUtils.isEmptyObject(root)) {
            return;
        }
        inorder(root.left,preRes);
        if (preRes.pre != -1) {
            preRes.res = Math.min(preRes.res, root.intValue - preRes.pre);
        }
        preRes.pre = root.intValue;
        inorder(root.right, preRes);
    }

    public static void main(String[] args) {
        BinaryTreeNode root=constructTree();
        int result=getMinimumDifference(root);
        System.out.println(result);

        PreRes preRes = new PreRes();
        inorder(root,preRes);
        System.out.println(preRes.res);

    }
}

class PreRes{
    public  int pre=-1;
    public   int res=Integer.MAX_VALUE;

}