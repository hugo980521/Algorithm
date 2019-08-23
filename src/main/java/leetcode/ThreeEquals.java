package leetcode;

/**
 * 给定一个由 0 和 1 组成的数组 A，将数组分成 3 个非空的部分，使得所有这些部分表示相同的二进制值。
 *
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 *
 * A[0], A[1], ..., A[i] 组成第一部分；
 * A[i+1], A[i+2], ..., A[j-1] 作为第二部分；
 * A[j], A[j+1], ..., A[A.length - 1] 是第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 *
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-equal-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeEquals {
  public   int[] threeEqualParts(int[] nums){
    int[] fail=new int[]{-1,-1};
    if(nums==null || nums.length<3){
      return fail;
    }
    // 判断 1的个数是否能整除3
    int countOneNum=0;
    for(int i=0;i<nums.length;i++){
      if(nums[i]==1){
        countOneNum++;
      }
    }
    if(countOneNum%3 !=0){
      return fail;
    }

    int firstIndex=0;
    int secondIndex=0;
    int thirdIndex=0;
    int partNum=countOneNum/3;
    int secondPartNum=1+partNum;
    int thirdPartNum=1+2*partNum;
    countOneNum=0;
    for(int i=0;i<nums.length;i++){
      if(nums[i]==1){
        countOneNum++;
        if(countOneNum==1){
          firstIndex=i;
        }else if(countOneNum==secondPartNum){
          secondIndex=i;
        }else if(countOneNum==thirdPartNum){
          thirdIndex=i;
        }
      }
    }
    // 全0 直接返回
    if(countOneNum==0){
      return new int[]{0,nums.length-1};
    }

    // 比较 左 三分之一
    int compareLenth=nums.length-thirdIndex;
    if(secondIndex-firstIndex <compareLenth){
      return fail;
    }

    if(!check(nums, firstIndex, thirdIndex, compareLenth)){
      return fail;
    }

    // 比较 右 三分之一
    if(thirdIndex-secondIndex<compareLenth){
      return fail;
    }
    if(!check(nums, secondIndex, thirdIndex, compareLenth)){
      return fail;
    }


    return new int[]{firstIndex+compareLenth-1,secondIndex+compareLenth};
  }

  private  boolean check(int[] nums, int firsStart,int secondStart,int compareLength){

      for(int i=0;i<compareLength;i++){
        if(nums[firsStart+i]!=nums[secondStart+i]){
          return false;
        }
      }
      return true;
  }

  public static void main(String[] args) {
    int[] nums=new int[]{0,1,0,1,1};
    nums=new int[]{0,0,0,0};
    int[] result=new ThreeEquals().threeEqualParts(nums);
    for(int p:result){
      System.out.println(p);
    }
  }
}
