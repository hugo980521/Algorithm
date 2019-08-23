package leetcode.bitoperate;

public class Letcode318 {
  public int maxProduct(String[] words) {
    if(null==words || words.length==0){
      return 0;
    }
    int[] nums=new int[words.length];
    for(int i=0;i<nums.length;i++){
      int x=0;
      char[] charArr=words[i].toCharArray();
      for(char c:charArr){
        int cNum=c-'a';
        x=x|(cNum<<1);
      }
      nums[i]=x;
    }
    int ret=0;
    for(int i=0;i<nums.length;i++){
      for(int j=i+1;j<nums.length;j++){
        if((nums[i]&nums[j])>0 && ret<(words[i].length()*words[j].length())){
          ret=words[i].length()*words[j].length();
        }
      }
    }
    return ret;

  }

}
