package lc20220210;

import java.util.Arrays;

public class Find_the_midNum_in_array {
	public static void main(String[] args){
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {6,7,8,9};
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}
	
	//这个函数的返回值是double，由于/这个算出来的是整型，所以要加一个double的强制类型转换
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] arr = new int[l1 + l2];
        for(int i = 0; i < l1; i++){
            arr[i] = nums1[i];
        }
        for(int j = l1; j < arr.length; j++){
            arr[j] = nums2[j-l1];
        }
        Arrays.sort(arr);
        if(arr.length % 2 != 0){
            return arr[arr.length/2];
        }else{
            return (double)(arr[arr.length/2-1]+arr[arr.length/2])/2;
        }
    }
}
