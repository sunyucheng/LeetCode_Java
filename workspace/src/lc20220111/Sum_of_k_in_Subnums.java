package lc20220111;

public class Sum_of_k_in_Subnums {
	public static void main(String[] args){
		int[] nums = {1,2,3};
		System.out.println(subarraySum(nums,3));
	}
	
	//穷举所有连续子数组，然后求解它们的和
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //构造前缀和数组
        int[] preSum = new int[n+1];
        //前缀和数组的第一个元素都是零
        preSum[0] = 0;
        //填满前缀和数组
        for(int i = 1 ; i < n+1 ;i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        //res记录结果,记录的是数组的个数，不是数组元素的个数
        int res = 0;
        //这里i一定是从1开始的，因为preSum[0] = 0
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(preSum[i] - preSum[j] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
