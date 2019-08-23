package leetcode;

import java.util.Stack;

public class RetainWater {
  public int trap(int[] height) {
    if(null==height || height.length<3){
      return 0;
    }

    Stack<Integer> container=new Stack<>();
    int res=0;
    for(int j=0;j<height.length;j++){
     while (!container.isEmpty() && height[j]>height[container.peek()]){
       int top=container.pop();
       if(container.isEmpty()){
         break;
       }
       int distance=j-container.peek()-1;
       int tempHeight=Math.min(height[j],height[container.peek()] )-height[top];
       res=res+distance*tempHeight;

     }
     container.push(j);
    }
    return res;

  }

  public static void main(String[] args) {
    int[] water=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    water=new int[]{1,1,1};
    System.out.println(new RetainWater().trap(water));

  }
}
