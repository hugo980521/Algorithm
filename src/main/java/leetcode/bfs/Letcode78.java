package leetcode.bfs;

import java.util.ArrayList;
import java.util.List;

public class Letcode78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      List<Integer> one = new ArrayList<>();
      one.add(num);
      result.add(one);
      int resultSize = result.size();
      for (int j = 0; j < resultSize - 1; j++) {
        List<Integer> newone = new ArrayList<>();
        newone.addAll(result.get(j));
        newone.add(num);
        result.add(newone);
      }
    }
    result.add(new ArrayList<>());
    return result;
  }


  public List<List<Integer>> subsetsDfs(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    dfs(nums, 0, cur, ans);
    return ans;
  }

  private void dfs(int[] nums, int last, List<Integer> cur, List<List<Integer>> ans) {
    ans.add(new ArrayList<>(cur));
    for (int i = last; i < nums.length; i++) {
      cur.add(nums[i]);
      dfs(nums, i + 1, cur, ans);
      cur.remove(cur.size() - 1);
    }
    System.out.println(ans.toString());
  }
  public static void main(String[] args) {
    int[] nums=new int[]{1,2,3};
    List<List<Integer>> result=new ArrayList<>();
    result=new Letcode78().subsets(nums);
    System.out.println("good");
  }
}
