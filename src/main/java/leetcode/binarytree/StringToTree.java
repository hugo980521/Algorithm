package leetcode.binarytree;

import jnr.ffi.annotations.In;
import util.ObjectUtils;
import util.StringUtils;

import java.util.Stack;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 * <p>
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 * <p>
 * You always start to construct the left child node of the parent first if it exists.
 * <p>
 * Example:
 * <p>
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 * <p>
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * <p>
 * Note:
 * <p>
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
 */
public class StringToTree {

   public static BinaryTreeNode strTotree(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
        for (int i = 0; i < s.length(); ++i) {
            int j = i;
            char tempChar = s.charAt(i);
            if (tempChar == ')') {
                st.pop();
            } else if ((tempChar >= '0' && tempChar <= '9') || tempChar == '-') {
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    ++i;
                }
                BinaryTreeNode cur = new BinaryTreeNode(Integer.parseInt(s.substring(j, i - j +1)));
                if (!st.empty()) {
                    BinaryTreeNode t = st.peek();
                    if (ObjectUtils.isEmptyObject(t.left)) {
                        t.left = cur;
                    } else {
                        t.right = cur;
                    }
                }
                st.push(cur);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String str="4(2(3)(1))(6(5))";
        BinaryTreeNode binaryTreeNode=strTotree(str);
        System.out.print("GOOD");
    }
}
