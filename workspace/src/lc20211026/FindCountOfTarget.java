package lc20211026;

public class FindCountOfTarget {
	public int search(int[] nums, int target) {
        return findRight(nums, target) - findRight(nums, target - 1);
    }

    //查找target的右边界的函数（通过二分法，属于二分法演进的一个题目）
    //想找到数组中target的个数，就要找到target的右边界和target的-1的右边界，相减即可
    public int findRight(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
