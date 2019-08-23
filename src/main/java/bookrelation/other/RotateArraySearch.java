package bookrelation.other;

/**
 * 假设有个有序数组在某个位置旋转，得到新的数组，即为旋转有序数组。如：(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 现给定一个这样的数组，在数组中查找某个数。如果找到，返回下标，否则返回-1；
 */
public class RotateArraySearch {

    /**
     * 考虑一个旋转有序数组的特点：前面部分是递增的，后面部分也是递增的，即先后两部分都为递增有序数组，因此可以用二分查找来做。
     假设数组为A，下标从left到right，查找的数字为target，那么mid=(left+((right-left)>>1))
     如果A[mid]==target，则return mid；
     如果A[mid]>target或者A[mid]<target怎么办呢？以mid为界，左右两边不一定是有序的数组。此时我们先不比较A[mid]和target的大小。
     以mid为界，左右两边必定有一边为递增的有序数组，那么这就是我们要找的区间。
     如果A[mid]>A[left]，那么mid的左边部分为递增有序数组，如果target>=A[left] && target<A[mid]，那么right=mid-1；否则，left=mid+1;
     如果A[mid]<A[left]，那么mid的右边部分为递增有序数组，如果target>A[mid] && target<=A[right]，那么left=mid+1；否则，right=mid-1；
     * @param arr
     * @param target
     * @return
     */
    public int rotateArraySearchPart(int arr[],  int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > arr[left]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 当然，我们也可以从正常的思路去想，分别从A[mid]==target，A[mid]>target，A[mid]<target三部分去考虑边界条件。
     * @param arr
     * @param target
     * @return
     */
    public int rotateArraySearchNormal(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                if (arr[mid] > arr[left] || target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {
                if (arr[mid] < arr[right] || target >= arr[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int A[]={2,3,4,5,1};
        int B[]={5,1,2,3,4};

        RotateArraySearch rotateArraySearch = new RotateArraySearch();
        int target=5;
        int indexPart= rotateArraySearch.rotateArraySearchPart(A,target);
        int indexNormal= rotateArraySearch.rotateArraySearchNormal(A,target);
        System.out.println("target="+target);
        System.out.println("indexPart="+indexPart);
        System.out.println("indexNormal="+indexNormal);

         target=4;
         indexPart= rotateArraySearch.rotateArraySearchPart(B,target);
         indexNormal= rotateArraySearch.rotateArraySearchNormal(B,target);
        System.out.println("target="+target);
        System.out.println("indexPart="+indexPart);
        System.out.println("indexNormal="+indexNormal);
    }
}
