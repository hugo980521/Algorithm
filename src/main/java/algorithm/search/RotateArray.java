package algorithm.search;

public class RotateArray {
    public static int getMin(int[] numArr){
        // 数组为空返回0
        if(null==numArr || numArr.length==0){
            return 0;
        }

        int start=0;
        int end=numArr.length-1;
        int mid=(start+end)/2;
        while (start<end){
            if(numArr[start]>numArr[end]){
                start=mid;
            }else if(numArr[start]==numArr[end]&& numArr[mid]==numArr[start]) {
                return getMinInOrder(numArr,start,end);
            }else{
                end=mid;
            }
            mid=(start+end)/2;

        }

        return numArr[mid];

    }
    public static int getMinInOrder(int[] numArr,int start,int end){
        // 为空或者 start > end 返回0
        if(null==numArr || numArr.length==0 || start >end){
            return 0;
        }
        // 数组越界
        if(start>=numArr.length || end>=numArr.length || start<0|| end<0 ){
            return 0;
        }
        int minValue=numArr[start];
        for(int i=start+1;i<end;i++){
            if(minValue>numArr[i]){
                minValue=numArr[i];
            }
        }

        return minValue;

    }

    public static void main(String[] args) {
        int[] numArr=new int[]{3,4,5,1,2};
        int result=getMin(numArr);
        System.out.println(result);

        numArr=new int[]{1,0,1,1,1};
         result=getMin(numArr);
        System.out.println(result);
    }
}
