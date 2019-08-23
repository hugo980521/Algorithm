package leetcode.normal;

import java.util.Arrays;

/**
 * Median of Two Sorted Arrays 两个有序数组的中位数
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class TwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }

    int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findKth(nums2, nums1, k);
        }
        if (m == 0) {
            return nums2[k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        int i = Math.min(m, k / 2);
        int j = Math.min(n, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }
    }

    public static void main(String[] args) {
        TwoSortedArrays twoSortedArrays=new TwoSortedArrays();
        int[] aArr={3,4,5,6};
        int[] bArr={2,11,13,13,15};
       double result= twoSortedArrays.findMedianSortedArrays(aArr,bArr);
       System.out.println(result);
    }
}