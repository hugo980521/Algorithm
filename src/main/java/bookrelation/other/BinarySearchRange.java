package bookrelation.other;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。

 如果目标值不在数组中，则返回[-1, -1]
 */
public class BinarySearchRange {


    public List<Integer> searchData(int[] A, int target){


        int first=0;
        int last=A.length-1;
        int mid=-1;

        // 二分查找查找，mid位置
        while(first<=last){
            mid=first+((last-first)>>1);
            if(A[mid]==target){
                break;
            }
            else if(A[mid]<target){
                first=mid+1;
            }else{
                last=mid-1;
            }

        }

        int left=-1;
        int right=-1;

        if(mid!= -1){
            left=mid;
            right=mid;

            int leftIndex=left-1;
            while((leftIndex >=0 ) && (A[leftIndex]==target)){
                left=leftIndex;
                leftIndex--;
            }

            int rightIndex=mid+1;
            while((rightIndex <A.length ) && (A[rightIndex]==target)){
                right=rightIndex;
                rightIndex++;
            }
        }

        List<Integer> lstResult=new ArrayList<Integer>();
        lstResult.add(left);
        lstResult.add(right);

        return lstResult;
    }


    public static void main(String[] args) {
        int[] arr={2,3,4,6,7,8,8,8,9,10};
        BinarySearchRange binarySearchRange = new BinarySearchRange();
        int n=8;
        List<Integer> result=binarySearchRange.searchData(arr,n);
        System.out.println("n="+n+ " result="+result);

         n=2;
         result=binarySearchRange.searchData(arr,n);
        System.out.println("n="+n+ " result="+result);

        n=10;
        result=binarySearchRange.searchData(arr,n);
        System.out.println("n="+n+ " result="+result);
    }


}
