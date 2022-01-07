package lc20220106;

public class SumofRange {
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		NumArray arr = new NumArray(nums);
		System.out.println(arr.sumRange(0, 2));
	}
}

class NumArray {
    //属性
    //属性基本上会出现在构造器之中
    public int[] nums;

    //构造器函数，可以理解为初始化函数
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    //查询闭区间[left,right]的累加和
    public int sumRange(int left, int right) {
        int res = 0;
        for(int i = left; i <= right; i++){
            res += nums[i];
        }
        return res;
    }
}
