package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Letcode269 {
  public HashMap<Character, Set<Character>> createAdj(String[] list) {
    HashMap<Character, Set<Character>> adj = new HashMap<>();
    for (int i=0;i<list.length-1;i++) {
      String a = list[i];
      String b = list[i+1];
      for (int j=0;j<a.length() && j<b.length();j++) {
        if (a.charAt(j) == b.charAt(j)) {
          continue;
        }
        Set<Character> set = adj.getOrDefault(a.charAt(j),new HashSet<>());
        set.add(b.charAt(j));
        adj.put(a.charAt(j),set);
        break;
      }
    }
    return adj;
  }

  public String alienOrder(String[] words) {
    HashMap<Character, Set<Character>> adj = createAdj(words);
    StringBuilder res = new StringBuilder();
    boolean[] visited = new boolean[26];
    for (char c = 'a';c<='z';c++) {
      if (!visited[c-'a'] ) {
        if (adj.containsKey(c) && hasCycle(adj,c,new boolean[26],visited,res)) {
          return "";
        }
      }
    }
    for (String s: words) {
      for (char c: s.toCharArray()) {
        if (!visited[c-'a']) {
          res.append(c);
          visited[c-'a'] = true;
        }
      }
    }
    return res.toString();
  }
  public boolean hasCycle(HashMap<Character, Set<Character>> adj,
                          char cur,
                          boolean[] onstack,
                          boolean[] visited,
                          StringBuilder sb) {
    int index = cur-'a';
    if (onstack[index]) {
      return true;
    }
    if (visited[index]) {
      return false;
    }
    visited[index] = true;
    onstack[index] = true;
    for (char c: adj.getOrDefault(cur,new HashSet<>())) {
      if (hasCycle(adj,c,onstack,visited,sb)) {
        return true;
      }
    }
    sb.insert(0,cur);
    onstack[index] = false;
    return false;
  }

  public static void main(String[] args) {
    String[] words=new String[]{"wrt",
                          "wrf",
                          "er",
                          "ett",
                          "rftt"};
//    words=new String[]{"z","x","z"};
    String result=new Letcode269().alienOrder(words);
    System.out.println(result);
  }
}


