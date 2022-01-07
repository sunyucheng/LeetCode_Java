package lc20220106;

public class SumofRange2 {
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		NumArray2 arr = new NumArray2(nums);
		System.out.println(arr.sumRange(0, 2));
	}
}

class NumArray2 {
    //定义前缀和数组
    //这个前缀和数组的意义就是
    public int[] preSum;

    //构造器函数，可以理解为初始化函数
    public NumArray2(int[] nums) {
        //因为preSum只是声明了，还没有定义，所以这样是不对的，赋值语句应该写在定义的后面
        //preSum[0] = 0;
        preSum = new int[nums.length+1];
        preSum[0] = 0;
        for(int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }
    
    //查询闭区间[left,right]的累加和
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}