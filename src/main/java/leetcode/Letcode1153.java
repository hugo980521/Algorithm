package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给出两个长度相同的字符串，分别是 str1 和 str2。请你帮忙判断字符串 str1 能不能在 零次 或 多次 转化后变成字符串 str2。
 * <p>
 * 每一次转化时，将会一次性将 str1 中出现的 所有 相同字母变成其他 任何 小写英文字母（见示例）。
 * <p>
 * 只有在字符串 str1 能够通过上述方式顺利转化为字符串 str2 时才能返回 True，否则返回 False。​​
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "aabcc", str2 = "ccdee"
 * 输出：true
 * 解释：将 'c' 变成 'e'，然后把 'b' 变成 'd'，接着再把 'a' 变成 'c'。注意，转化的顺序也很重要。
 * 示例 2：
 * <p>
 * 输入：str1 = "leetcode", str2 = "codeleet"
 * 输出：false
 * 解释：我们没有办法能够把 str1 转化为 str2。
 */
public class Letcode1153 {

  public boolean canConvert(String str1, String str2) {
    // 为空或长度不相等 返回false
    if (null == str1 || null == str2 || str1.length() != str2.length()) {
      return false;
    }
    // 相等,不用变换
    if (str1.equals(str2)) {
      return true;
    }
    // 两个字符串有一个用满小学字母，不能变换
    int constantNum=26;
    int[] indices = new int[constantNum];
    for (int i = 0; i < constantNum; i++) {
      indices[i] = -1;
    }
    char[] chA = str1.toCharArray();
    char[] chB = str2.toCharArray();
    for (int i = 0; i < chA.length; i++) {
      for (int j = 0; j < constantNum; j++) {
        if (indices[j] != -1 && chB[i] != chB[indices[j]] && chA[i] == chA[indices[j]]) {
          return false;
        }
      }
      indices[chB[i]-'a']=i;
    }
    for(int value:indices){
      if(value==-1){
        return true;
      }
    }

    return false;

  }

  private Set<Character> getSet(String str) {
    Set<Character> charactersSet = new HashSet<>();
    for (char ch : str.toCharArray()) {
      charactersSet.add(ch);
    }
    return charactersSet;
  }

  public static void main(String[] args) {
    String str1="alekefvwrzzcowensxdmgaaoirrdtwyeanlilhpdkxdznsiyljdvbkuengpbzdhxrbmehsbqywctdtbvgmwmfhwrtthykoteaoiswqozigivsqkdbwzztdsfkcpnzqzgeslqydnazduunvznonzxnovghbkeosyrkaypazpecnwtdkrqlfjshyrgtwufiakezaptjjvhtorrynuidxinotwhfk";
    String str2="xzhykanqmjmlttrahtedymyqhrbglcniopjkbgronxckmqemaummktnilxxpomuqxuwiwjitbylewxrxmrwbjgbjkohiimguweiybqrbfcymcostksckuykerqwaawkgphvfwvagwmlzqzwqqdvqrnigfwhmrxjvichursglqmjvpbbimfsalehnewfmbokwcvzqabxsoxppzwjdghoqwxgbbe";
    System.out.println(new Letcode1153().canConvert(str1, str2));
  }
}
