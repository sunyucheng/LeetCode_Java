package lc20211125;

public class BinarySearch {
	public static void main(String[] args){
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(search(nums,0));
	}
	
    //二分查找法
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            //目标值不存在则返回-1
            return -1;
        }
        //采用的是左闭右开的区间，区间内不会包含target
        //所以在初始值以及中间循环的时候都是左闭右开的
        //因为不存在则返回-1，所以需要考虑的是可能是进行二分查找之后发现不存在，则返回-1
        int res = -1;
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                res =  mid;
                break;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left  = mid + 1;
            }
        }
        return res;
    }
}
