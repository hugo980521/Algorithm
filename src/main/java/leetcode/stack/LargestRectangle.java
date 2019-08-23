package leetcode.stack;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class LargestRectangle {


    // O(n) using one stack

    public static int largestRectangleArea(int[] height) {

        // Start typing your Java solution below

        // DO NOT write main() function

        int area = 0;

        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

        for (int i = 0; i < height.length; i++) {

            if (stack.empty() || height[stack.peek()] < height[i]) {

                stack.push(i);

            } else {

                int start = stack.pop();

                int width = stack.empty() ? i : i - stack.peek() - 1;

                area = Math.max(area, height[start] * width);

                i--;

            }

        }

        while (!stack.empty()) {

            int start = stack.pop();

            int width = stack.empty() ? height.length : height.length - stack.peek() - 1;

            area = Math.max(area, height[start] * width);

        }

        return area;

    }

    public static void main(String[] args){
       int[] height={2,1,5,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }
}
