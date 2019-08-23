package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Letcode137 {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> list = new ArrayList();
    int len = s.length();
    if (len <= 10){
      return list;
    }
    HashSet<String> set = new HashSet();
    for (int i = 10; i <= len; i++){
      String str = s.substring(i - 10, i);//取到i-10和i-1的字符串，共十位
      if (set.contains(str) && !list.contains(str)){
        list.add(str);
      } else {
        set.add(str);
      }
    }
    return list;
  }
}
